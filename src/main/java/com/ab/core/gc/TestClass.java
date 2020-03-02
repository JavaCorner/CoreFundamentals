package com.ab.core.gc;

/**
 * @author Arpit Bhardwaj
 */
public class TestClass {
    private String objName;

    public TestClass(String objName) {
        this.objName = objName;
    }

    public String getObjName() {
        return objName;
    }

    @Override
    protected void finalize() throws Throwable {
        //super.finalize();
        System.out.println(this.objName + " garbage collected successfully");
    }
}
