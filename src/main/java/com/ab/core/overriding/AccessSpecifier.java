package com.ab.core.overriding;

/**
 * @author Arpit Bhardwaj
 *
 * Overriding method in Child class can either have same access specifier as that of Parent class method
 * or can increase visibility but cannot decrease it.
 */
public class AccessSpecifier {
}

class AAccess{
    protected void connect(){};
}

class BAccess extends AAccess{
    @Override
    public void connect() {}
}

