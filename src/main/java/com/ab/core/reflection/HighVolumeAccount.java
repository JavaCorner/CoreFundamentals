package com.ab.core.reflection;

public class HighVolumeAccount extends BankAccount implements Runnable {

    public HighVolumeAccount(String id) {
        super(id);
    }

    public HighVolumeAccount(String id, int balance) {
        super(id, balance);
    }

    private int[] readDailyDeposits(){
        int[] deposits = new int[10];
        System.out.println("readDailyDeposits method called");
        return deposits;
    }

    private int[] readDailyWithdrawals(){
        int[] withdrawals = new int[10];
        System.out.println("readDailyWithdrawals method called");
        return withdrawals;
    }
    @Override
    public void run() {
        for (int depositAmount: readDailyDeposits()
             ) {
            deposit(depositAmount);
        };
        for (int withrawalAmount: readDailyWithdrawals()
             ) {
            withdrawal(withrawalAmount);
        }
    }
}
