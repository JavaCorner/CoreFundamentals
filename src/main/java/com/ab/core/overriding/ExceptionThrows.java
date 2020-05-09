package com.ab.core.overriding;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.SQLException;

/**
 * @author Arpit Bhardwaj
 *
 * Unchecked Exception:
 * Overriding method in Child class can throw any number of Unchecked Exception irrespective of Parent class overriden method has declared any Checked/Unchecked Exception or not.
 *
 * Checked Exception:
 * If say Overriden method of Parent class throws IOException, then overriding method in Child class can either throw
 * No Exception,
 * Same IOException,
 * Any number of Subclass of IOException like FileNotFoundException, EOFException etc.
 *
 * Not Allowed in Checked Exception
 * If say Overriden method of Parent class throws IOException, then overriding method in Child class
 * cannot throw exception from totally new inheritance hierarchy like SQLException.
 * cannot throw broader exception like Throwable or Exception in our case.
 */

class Parent1{
    protected Object connect(String s1) {
        System.out.println("Doing connection in Parent way");
        return null;
    }

    protected Object connect1(String s1) throws Exception{
        System.out.println("Doing connection in Parent way");
        return null;
    }

    protected Object connect2(String s1) throws IOException, SQLException {
        System.out.println("Doing connection in Parent way");
        return null;
    }

    protected Object connect3(String s1) throws IOException{
        System.out.println("Doing connection in Parent way");
        return null;
    }

    protected Object connect4(String s1){
        System.out.println("Doing connection in Parent way");
        return null;
    }

}

class Child1 extends Parent1{
    @Override
    public Integer connect(String s2){ //It will work
        System.out.println("Doing connection in Child way");
        return null;
    }
    @Override
    protected Object connect1(String s1) throws Exception, FileNotFoundException, MalformedURLException { //It will work
        System.out.println("Doing connection in Child way");
        return null;
    }
    @Override
    protected Object connect2(String s1) throws FileNotFoundException{ //It will work
        System.out.println("Doing connection in Child way");
        return null;
    }
    /*@Override
    protected Object connect3(String s1) throws Exception{ //It will NOT work
        System.out.println("Doing connection in Child way");
        return null;
    }*/
    /*@Override
    protected Object connect4(String s1) throws Exception{ //It will NOT work
        System.out.println("Doing connection in Child way");
        return null;
    }*/
}
public class ExceptionThrows {
}
