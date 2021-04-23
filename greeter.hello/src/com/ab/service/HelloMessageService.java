package com.ab.service;

import com.ab.api.MessageService;
import com.ab.util.CapitalizeUtil;

public class HelloMessageService implements MessageService {

    @Override
    public String getMessage() {
        return CapitalizeUtil.capitalize("HelloMessageService from greeter.hello");
    }
}
