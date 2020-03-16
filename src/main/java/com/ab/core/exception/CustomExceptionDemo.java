package com.ab.core.exception;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Arpit Bhardwaj
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
