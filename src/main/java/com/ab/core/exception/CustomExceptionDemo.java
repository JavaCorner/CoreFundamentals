package com.ab.core.exception;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Arpit Bhardwaj
 *
 *  Custom Checked Exception
 *  Checked – Extends java.lang.Exception, for recoverable condition, try-catch the exception explicitly, compile error.
 *
 *  Custom Runtime Exception
 *  Unchecked – Extends java.lang.RuntimeException, for unrecoverable condition, like programming errors, no need try-catch, runtime error.
 */
public class CustomExceptionDemo {
    public static void main(String[] args) {
        customCheckedExceptionDemo();
        customUnCheckedExceptionDemo();
    }

    private static void customUnCheckedExceptionDemo() {
        CustomerService service = new CustomerService();
        List<String> data = new ArrayList<>(Collections.nCopies(51,"Sample"));
        service.analyze(data);
    }

    private static void customCheckedExceptionDemo() {
        CustomerService service = new CustomerService();

        try {
            Customer customer = service.findByName("");
        } catch (NameNotFoundException e) {
            e.printStackTrace();
        }
    }
}

class Customer {
    private String name;
    public Customer(String name) {
        this.name = name;
    }
}

class CustomerService {

    public Customer findByName(String name) throws NameNotFoundException {
        if ("".equals(name)){
            throw new NameNotFoundException("Name is Empty!");
        }
        return new Customer(name);
    }

    public void analyze(List<String> data){
        if (data.size() > 50){
            throw new ListTooLargeException("List cant exceed 50 items!");
        }
    }
}

//Custom Checked Exception
class NameNotFoundException extends Exception {
    public NameNotFoundException(String message) {
        super(message);
    }
    public NameNotFoundException(String message, Throwable e) {
        super(message,e);
    }
}

//Custom Runtime Exception
class ListTooLargeException extends RuntimeException {
    public ListTooLargeException(String message) {
        super(message);
    }
    public ListTooLargeException(String message,Throwable e) {
        super(message,e);
    }
}
