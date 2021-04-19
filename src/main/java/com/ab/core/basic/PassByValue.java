package com.ab.core.basic;

/**
 * @author Arpit Bhardwaj
 *
 * Java is Strictly Pass by Value!
 *
 * In Primitive Type
 * Java creates a copy of the variable being passed in the method and then do the manipulations.
 * Hence the change is not reflected in the main method.
 *
 * In Reference Type
 * Java creates a copy of references and pass it to method
 * The changes are not reflected back in main methods if we change the object itself to refer some other location or object in passed method
 * Changes are reflected back if we do not assign reference to a new location or object:
 */
public class PassByValue {
    static class Test{
        int y;

        public Test() {
        }

        public Test(int y) {
            this.y = y;
        }

        @Override
        public String toString() {
            return "Test{" +
                    "y=" + y +
                    '}';
        }
    }
    public static void main(String[] args) {
        int x = 5;
        change(x);
        System.out.println(x);

        Test test = new Test(20);
        change(test);
        System.out.println(test);
    }

    private static void change(Test test) {
        //test = new Test();//uncomment to stop the changes to reflect back in main
        test.y = 30;
    }

    private static void change(int x) {
        x = 10;
    }
}
