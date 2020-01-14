package com.ab.core.reflection;

public class AccessTypesClass {
    public static void main(String[] args) {
        BankAccount account = new BankAccount("1234");

        doWork(account);
    }

    private static void doWork(BankAccount account) {
        //1st Method
        //Class<?> cls = account.getClass();
        //2nd Method
        /*Class<?> cls = null;
        try {
            cls = Class.forName("com.ab.core.reflection.BankAccount");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }*/
        //3rd Method
        Class<?> cls = BankAccount.class;
        showName(cls);
    }

    private static void showName(Class<?> cls) {
        System.out.println(cls.getSimpleName());
    }
}
