package com.ab.api;

/**
 * @author Arpit Bhardwaj
 *
 * service provider interface
 *
 * if the service provider interface references other classes in method signature , then they are considered part of service
 * Changing the service provider interface sometimes requires recompiling the service provider
 *
 * changing or adding the implementation does not require service to recompile
 */
public interface MessageService {
    String getMessage();
}
