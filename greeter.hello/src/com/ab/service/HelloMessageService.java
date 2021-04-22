package com.ab.service;

import com.ab.util.CapitalizeUtil;

public class HelloMessageService {
    public String getMessage() {
        return CapitalizeUtil.capitalize("HelloMessageService from greeter.hello");
    }
}
