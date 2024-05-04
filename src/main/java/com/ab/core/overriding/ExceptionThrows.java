package com.ab.core.overriding;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.SQLException;

/**
 * @author Arpit Bhardwaj
 *
 * Unchecked Exception:
 * Overriding method in Child class can throw any number of unchecked exception irrespective of parent class overriden method has declared any checked/unchecked exception or not.
 *
 * Checked Exception:
 * If say overriden method of parent class throws IOException, then overriding method in child class can either throw
 *      No Exception,
 *      Same IOException,
 *      Any number of Subclass of IOException like FileNotFoundException, EOFException etc.
 *
 * If say overriden method of parent class throws IOException, then overriding method in child class
 *      cannot throw exception from totally new inheritance hierarchy like SQLException.
 *      cannot throw broader exception like throwable or exception in our case.
 */
public class ExceptionThrows {
    class Parent1{
        protected void connect(String s1) {}
        protected void connect1(String s1) throws Exception{}
        protected void connect2(String s1) throws IOException, SQLException {}
        protected void connect3(String s1) throws IOException{}
        protected void connect4(String s1){}
    }

    class Child1 extends Parent1{
        @Override
        public void connect(String s2) throws IllegalArgumentException, ArrayIndexOutOfBoundsException{}
        @Override
        protected void connect1(String s1) throws Exception, FileNotFoundException, MalformedURLException {}
        @Override
        protected void connect2(String s1) throws FileNotFoundException{}
        /*@Override
        protected void connect3(String s1) throws Exception{}*/              //compile error
        /*@Override
        protected void connect4(String s1) throws FileNotFoundException{}*/  //compile error
    }

    public static void main(String[] args) {}
}
