package com.ab.core.gc;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Arpit Bhardwaj
 */
public class PhantomReferenceDemo {
    public static void main(String[] args) throws InterruptedException {
        ReferenceQueue<People> referenceQueue = new ReferenceQueue<>();
        List<FinalizePeople> phantomRefList = new ArrayList<>();
        List<People> strongRefList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            People p = new People();
            strongRefList.add(p);
            phantomRefList.add(new FinalizePeople(p,referenceQueue));
        }

        strongRefList = null;
        System.gc();

        Thread.sleep(500);

        for (PhantomReference<People> phantomReference:
             phantomRefList) {
            System.out.println(phantomReference.isEnqueued());
        }

        Reference<? extends People> referenceFromQueue;
        while ((referenceFromQueue = referenceQueue.poll()) != null){
            ((FinalizePeople) referenceFromQueue).cleanUp();
        }
    }
}

class People{

}

class FinalizePeople extends PhantomReference<People>{

    /**
     * Creates a new phantom reference that refers to the given object and
     * is registered with the given queue.
     *
     * <p> It is possible to create a phantom reference with a <tt>null</tt>
     * queue, but such a reference is completely useless: Its <tt>get</tt>
     * method will always return null and, since it does not have a queue, it
     * will never be enqueued.
     *
     * @param referent the object the new phantom reference will refer to
     * @param q        the queue with which the reference is to be registered,
     */
    public FinalizePeople(People referent, ReferenceQueue<? super People> q) {
        super(referent, q);
    }

    public void cleanUp(){
        System.out.println("Cleaned Up");
    }
}