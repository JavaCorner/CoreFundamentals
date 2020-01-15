package com.ab.core.reflection;

import com.ab.core.annotation.WorkHandler;

@WorkHandler(useThreadPool = false)
public class AccountWorker implements Runnable{
    BankAccount ba;
    HighVolumeAccount hva;

    public AccountWorker(BankAccount ba) {
        this.ba = ba;
    }

    public AccountWorker(HighVolumeAccount hva) {
        this.hva = hva;
    }

    public void doWork(){
        Thread t = new Thread(hva != null? hva : this);
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
