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
 * If JVM detects an object with only weak references (i.e. no strong or soft references linked to any object),
 * this object will be marked for garbage collection.
 *
 * Soft Reference
 * Phantom Reference
 */
public class ObjectReferences {
    public static void main(String[] args) {
        TestClass strongTestObjectRef = new TestClass("Object1");// strong reference
        strongTestObjectRef = null; //eligible for garbage collection.

        weakReference();
        softReference();
        phantomReference();
    }

    private static void phantomReference() {
        TestClass strongTestObjectRef = new TestClass("Object2");// strong reference
        strongTestObjectRef.getObjName();
        ReferenceQueue<TestClass> referenceQueue = new ReferenceQueue<>();
        PhantomReference<TestClass> phantomTestObjectRef = new PhantomReference<>(strongTestObjectRef,referenceQueue);
        strongTestObjectRef = null;
        //Available for garbage collection.But, this object is kept in 'refQueue' before removing it from the memory.

        strongTestObjectRef = phantomTestObjectRef.get();
        strongTestObjectRef.getObjName();
    }

    private static void softReference() {
        TestClass strongTestObjectRef = new TestClass("Object2");// strong reference
        strongTestObjectRef.getObjName();
        SoftReference<TestClass> softTestObjectRef = new SoftReference<>(strongTestObjectRef);//Soft Reference
        strongTestObjectRef = null;
        //free for garbage collection then also it's not garbage collected, until JVM is in need of memory badly.(OutOfMemoryError)

        strongTestObjectRef = softTestObjectRef.get();
        strongTestObjectRef.getObjName();
    }

    private static void weakReference() {
        TestClass strongTestObjectRef = new TestClass("Object2");// strong reference
        strongTestObjectRef.getObjName();
        WeakReference<TestClass> weakTestObjectRef = new WeakReference<>(strongTestObjectRef);//weak reference
        strongTestObjectRef = null;
        //Available for garbage collection. But, it will be garbage collected only when JVM needs memory.

        strongTestObjectRef = weakTestObjectRef.get();
        strongTestObjectRef.getObjName();
    }
}
