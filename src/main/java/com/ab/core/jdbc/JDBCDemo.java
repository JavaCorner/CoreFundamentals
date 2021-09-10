package com.ab.core.jdbc;

import java.sql.*;
import java.time.LocalDate;

/**
 * @author Arpit Bhardwaj
 *
 * Class
 *      Driver Manager : Manages list of JDBC Drivers and creates connection objects
 * Interface:
 *      Driver : to interact with databases.
 *      Connection : represent a session with a specific database and creates all type of statements
 *      Statement : represent a basic SQL Statement
 *      Prepared Statement : represent a precompiled SQL Statement
 *      Callable Statement : represent calls SQL stored procedures and function
 *      ResultSet : represent a set of records returned by the execution of the query of DQL statement
 *
 * Disadvantages of Basic Statement
 *      Parameter concatenation present a security risk of SQL Injection
 *      Basic statement have to be parsed and recompiled before every execution
 *
 * By Default connections are in auto commit mode
 *      means commit occurs automatically when the statement processing successfully completes
 *      in order to change this default behaviour use setAutoCommit to false
 *
 * By Default ResultSet are forward direction means only next() method os enabled
 */
public class JDBCDemo {

    static String url = "jdbc:sql://localhost::3306/ticketdb";
    static String username = "sysman";
    static String password = "sysman";
    public static void main(String[] args) throws SQLException {
        try (Connection conn = DriverManager.getConnection(url,username,password)) {

            DatabaseMetaData metaData = conn.getMetaData();
            String databaseProductName = metaData.getDatabaseProductName();
            String databaseProductVersion = metaData.getDatabaseProductVersion();
            boolean b = metaData.supportsOuterJoins();
            boolean b1 = metaData.supportsSavepoints();
            //basicStatement(conn)
            //readWithExecuteQuery(conn);
            //insertUpdateDeleteWithExecuteUpdate(conn);
            //crudWithExecute(conn);
            //parametrizedStatements(conn);
            //callStoredProcedure(conn);
            //callStoredProcedureWithInParameter(conn);
            callStoredProcedureWithOutParameter(conn);
        }

    }

    private static void callStoredProcedureWithOutParameter(Connection conn) throws SQLException {
        String storedProcedure = "{ ?= call sp1(?,?) }";
        CallableStatement cs = conn.prepareCall(storedProcedure);
        cs.setDate("startDate", Date.valueOf(LocalDate.now()));
        cs.setDate("endDate", Date.valueOf(LocalDate.now()));
        cs.registerOutParameter(1, Types.DOUBLE);
        ResultSet rs = cs.executeQuery();//used for reading the data
        while (rs.next()){
            System.out.println(rs.getString(1));
        }
    }

    private static void callStoredProcedureWithInParameter(Connection conn) throws SQLException {
        String storedProcedure = "{ call sp1(?,?) }";
        CallableStatement cs = conn.prepareCall(storedProcedure);
        cs.setDate("startDate", Date.valueOf(LocalDate.now()));
        cs.setDate("endDate", Date.valueOf(LocalDate.now()));
        ResultSet rs = cs.executeQuery();//used for reading the data
        while (rs.next()){
            System.out.println(rs.getString(1));
        }
    }

    private static void callStoredProcedure(Connection conn) throws SQLException {
        String storedProcedure = "{ call sp1() }";
        CallableStatement cs = conn.prepareCall(storedProcedure);
        ResultSet rs = cs.executeQuery();//used for reading the data
        while (rs.next()){
            System.out.println(rs.getString(1));
        }
    }

    private static void parametrizedStatements(Connection conn) throws SQLException {
        String sql = "select * from t where c1 like ? and c2 like ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        //1 based
        //throws sql exception in case of invalid parameter index is passed or missed a parameter to set
        //order od setting parameter doesn't matter
        ps.setString(1,"%the%");
        ps.setString(2,"%the%");
        ps.setObject(3,1); //throws sql exception
        ResultSet rs = ps.executeQuery();//used for reading the data
        while (rs.next()){
            //can use column index (1 based) as well as column name
            //throws sql exception in case of invalid column index or column name is passed
            rs.getString(1);
            rs.getString("c2");
            rs.getObject(3);
        }

        //reusing prepared statement
        ps.setString(1,"%the%"); //overrides the first parameter
        rs = ps.executeQuery();//used for reading the data
    }

    private static void crudWithExecute(Connection conn) throws SQLException {
        String sql = "select * from t";
        PreparedStatement ps = conn.prepareStatement(sql);
        boolean isrs = ps.execute();//for generic purpose (handles all crud)
        if (isrs){
            ResultSet rs = ps.getResultSet();
            while (rs.next()){
                System.out.println(rs.getString(1));
            }
        }else{
            int affectedRowCount = ps.getUpdateCount();
            if (affectedRowCount > 0){
                System.out.println("Rows Updated : " + affectedRowCount);
            }
        }
    }

    private static void insertUpdateDeleteWithExecuteUpdate(Connection conn) throws SQLException {
        String sql = "insert into t (c1,c2) values ('v1',v2)";
        String sql1 = "update t set c1 = v1 where c2 = v2";
        String sql2 = "delete from t where c1 = v1";

        PreparedStatement ps = conn.prepareStatement(sql);
        int affectedRowCount = ps.executeUpdate();//used for insert update and delete queries
        if (affectedRowCount > 0){
            System.out.println("Rows Updated : " + affectedRowCount);
        }
    }

    private static void readWithExecuteQuery(Connection conn) throws SQLException {
        String sql = "select * from t";
        PreparedStatement ps = null;
        ps = conn.prepareStatement(sql);//precompile sql
        ResultSet rs = ps.executeQuery();//used for reading the data
        while (rs.next()){
            System.out.println(rs.getString(1));
        }
    }


    private static void basicStatement(Connection conn) throws SQLException {
        int price = 2;
        String sql = "select * from t where price > " + price;
        Statement ps = null;
        try {
            conn.setAutoCommit(false);
            ps = conn.createStatement();
            ResultSet rs = ps.executeQuery(sql);//need to parse and recompile sql before every execution

            //analyze result set
            ResultSetMetaData metaData = rs.getMetaData();
            for (int i = 0; i < metaData.getColumnCount(); i++) {
                String columnName = metaData.getColumnName(i);
                int columnType = metaData.getColumnType(i);
            }

            while (rs.next()){
                System.out.println(rs.getString(1));
            }
            conn.commit();
        } catch (SQLException e) {
            conn.rollback();
            String state = e.getSQLState(); //get the database error
            int errorCode = e.getErrorCode();
            e.printStackTrace();
        }
    }

    private static void trick1(Connection conn) throws SQLException {
        String sql = "select * from t";
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
            ResultSet rs1 = ps.executeQuery();
            ResultSet rs2 = ps.executeQuery(); //closes rs1
            //When running a query on a PreparedStatement, Java closes any already open ResultSet objects associated with the statement.
            while (rs1.next()){//throws SQL Exception
                System.out.println(rs1.getString(1));
            }

            while (rs2.next()){
                System.out.println(rs2.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
