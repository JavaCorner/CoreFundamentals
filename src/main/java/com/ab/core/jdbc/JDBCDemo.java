package com.ab.core.jdbc;

import java.sql.*;

/**
 * @author Arpit Bhardwaj
 *
 */
public class JDBCDemo {

    static String url = "jdbc:sql://localhost::3306/ticketdb";
    static String username = "sysman";
    static String password = "sysman";
    public static void main(String[] args) throws SQLException {
        try (Connection conn = DriverManager.getConnection(url,username,password)) {
            //readWithExecuteQuery(conn);
            //insertUpdateDeleteWithExecuteUpdate(conn);
            //crudWithExecute(conn);
            parametrizedStatements(conn);
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
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();//used for reading the data
        while (rs.next()){
            System.out.println(rs.getString(1));
        }
    }
}
