package com.ab.cli;
import com.ab.api.MessageService;
import com.ab.service.HelloMessageService;

import java.lang.reflect.Type;
import java.util.ServiceLoader;

/**
 * @author Arpit Bhardwaj
 *
 * service consumer as well as service locator
 *
 * ServiceLoader allows you to make your application extensible
 * A service can be added without recompiling the entire application.
 */
public class Main {
    public static void main(String[] args) {
        //System.out.println("Hello from greeter.cli module");

        //HelloMessageService messageService = new HelloMessageService();
        //System.out.println(messageService.getMessage());

        ServiceLoader<MessageService> messageServices = ServiceLoader.load(MessageService.class);
        for (MessageService messageService : messageServices){
            System.out.println(messageService.getMessage());
        }

        //lazy instantiation of services
        /*messageServices.stream()
                .filter(provider -> provider.type().getClass().getTypeName() == "HelloMessageService")
                .map(ServiceLoader.Provider::get)
                .forEach(messageService -> messageService.getMessage());*/

        try {
            Type genericType = Class.forName("com.ab.util.CapitalizeUtil").getDeclaredField("secret").getGenericType();
            System.out.println(genericType.getTypeName());
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
