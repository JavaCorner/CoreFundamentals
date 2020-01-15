package com.ab.core.reflection;

public class NewAccountWorker implements TaskWorker,Runnable {
    BankAccount ba;
    @Override
    public void setTarget(Object target) {
        if(BankAccount.class.isInstance(target)){
            ba= (BankAccount) target;
        }else{
            throw new IllegalArgumentException();
        }
    }

    @Override
    public void doWork() {
        Thread t = new Thread(HighVolumeAccount.class.isInstance(ba)?(HighVolumeAccount)ba:this);
        t.start();
    }

    @Override
    public void run() {
        char txType = 0;
        int amt = 0;
        if(txType == 'w'){
            ba.withdrawal(amt);
        }else{
            ba.deposit(amt);
        }
    }
}
