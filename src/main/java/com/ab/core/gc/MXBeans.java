package com.ab.core.gc;

import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.util.List;

/**
 * @author Arpit Bhardwaj
 */
public class MXBeans {
    public static void main(String[] args) {
        List<GarbageCollectorMXBean> list = ManagementFactory.getGarbageCollectorMXBeans();
        for (GarbageCollectorMXBean bean:
             list) {
            System.out.println("Name : " + bean.getName());
            System.out.println("Number of collections : " + bean.getCollectionCount());
            System.out.println("Collection Time : " + bean.getCollectionTime() + "ms");
            System.out.println("Pool Names");
            for (String name:
                 bean.getMemoryPoolNames()) {
                System.out.println("\t" + name);
            }
            System.out.println();
        }
    }
}
