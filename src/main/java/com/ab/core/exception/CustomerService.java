package com.ab.core.exception;

import java.util.List;

/**
 * @author Arpit Bhardwaj
 */
public class CustomerService {

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
