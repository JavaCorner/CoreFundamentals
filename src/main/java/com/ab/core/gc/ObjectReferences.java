package com.ab.core.gc;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

/**
 * @author Arpit Bhardwaj
 *
 * Strong reference
 *  Any object which has Strong reference attached to it is not eligible for garbage collection.
 *
 * Weak Reference
 *  If JVM detects an object with only weak references (i.e. no strong or soft references linked to any object), this object will be marked for garbage collection.
 *  Available for garbage collection. But, it will be garbage collected only when JVM needs memory.
 *
 * Soft Reference
 *  Available for garbage collection, but it will not be garbage collected, until JVM is in need of memory badly.(OutOfMemoryError)
 *
 * Phantom Reference
 *  Available for garbage collection but this object is kept in 'refQueue' before removing it from the memory.
 */
public class ObjectReferences {
    public static void main(String[] args) throws InterruptedException {
        strongReference();
        weakReference();
        softReference();
        phantomReference();

        System.gc();
        Thread.sleep(2000);
    }

    private static void strongReference() {
        TestClass strongTestObjectRef = new TestClass("StrongObject");// strong reference
        strongTestObjectRef = null; //eligible for garbage collection.
    }

    private static void softReference() {
        TestClass strongTestObjectRef = new TestClass("SoftObject");
        strongTestObjectRef.getObjName();
        SoftReference<TestClass> softTestObjectRef = new SoftReference<>(strongTestObjectRef);
        strongTestObjectRef = null;

        strongTestObjectRef = softTestObjectRef.get();
        strongTestObjectRef.getObjName();
    }

    private static void weakReference() {
        TestClass strongTestObjectRef = new TestClass("WeakObject");
        strongTestObjectRef.getObjName();
        WeakReference<TestClass> weakTestObjectRef = new WeakReference<>(strongTestObjectRef);
        strongTestObjectRef = null;

        strongTestObjectRef = weakTestObjectRef.get();
        strongTestObjectRef.getObjName();
    }

    private static void phantomReference() {
        TestClass strongTestObjectRef = new TestClass("PhantomObject");
        strongTestObjectRef.getObjName();
        ReferenceQueue<TestClass> referenceQueue = new ReferenceQueue<>();
        PhantomReference<TestClass> phantomTestObjectRef = new PhantomReference<>(strongTestObjectRef,referenceQueue);
        strongTestObjectRef = null;

        strongTestObjectRef = phantomTestObjectRef.get();
        //strongTestObjectRef.getObjName();
    }
}
