package com.ab.core.gc;

/**
 * @author Arpit Bhardwaj
 */
public class ReferenceTestClass {
    ReferenceTestClass refObject;
    private String name;

    public ReferenceTestClass(String name) {
        this.name = name;
    }

    @Override
    protected void finalize() throws Throwable {
        //super.finalize();
        System.out.println(this.name + " garbage collected successfully");
    }
}
