package com.ab.core.gc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Arpit Bhardwaj
 */
public class ReferenceQueueDemo {
    public static void main(String[] args) throws InterruptedException, IOException {
        Person p = new Person();
        ReferenceQueue<Person> referenceQueue = new ReferenceQueue<>();
        PersonWeakReference weakReference = new PersonWeakReference(p,referenceQueue);

        //run the cleaning in background thread
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                PersonWeakReference wr = null;
                try {
                    wr = (PersonWeakReference) referenceQueue.remove();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                wr.clean();
            }
        });
        p = null;
        System.gc();
        Thread.sleep(500);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Press any key to continue");
        br.readLine();
        executorService.shutdown();
    }
}

class Person{

}


class PersonWeakReference extends WeakReference<Person> {

    public PersonWeakReference(Person referent, ReferenceQueue<? super Person> q) {
        super(referent, q);
    }

    public void clean(){
        System.out.println("Cleaned");
    }
}