package com.ab.core.gc;

/**
 * @author Arpit Bhardwaj
 *
 * Garbage Collection Algorithm
 *      Reference Counting
 *      Mark Sweep Compact
 *      Copying
 *      Generational
 *          Young Generation (Minor GC)
 *              Eden Space
 *              Survivor Space (S0)
 *              Survivor Space (S1)
 *          Old Generation (Major GC called Full GC runs when Tenured space is full)
 *              Tenured
 *              PermGen -> Metaspace (starting java 8 metapsace replaced the permgen)
 *                  Contains:
 *                      all static content (static methods, static references)
 *                      class metadata
 *                      string pool
 *                  Problem with Permgen which are addressed in metaspace
 *                      size cannnot grow dynamically at runtime due to which OutOfMemoryError was frequent
 *                      not eligible for garbage collection
 *          Card Tables (in case young generation objects reference old generation objects)
 *      Incremental
 *
 * Garbage Collector
 *      Serial Collector
 *      Parallel Collector
 *          Concurrent Mark Sweep (CMS) - deprecated since java 9
 *          G1 Collector (supported since java 7 and is the default server collector in java 11)
 *
 * Tools for Monitoring Garbage Collection
 *      MXBeans (Programatically)
 *      Jstat
 *      Visual VM and Visual GC
 */