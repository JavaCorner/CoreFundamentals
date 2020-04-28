package com.ab.core.memoryleak;

/**
 * @author Arpit Bhardwaj
 *
 * 1.Referencing a heavy object with a static field.
 * 2.Calling String.intern() on Long String
 * 3.Unclosed Streams
 * 4.Unclosed Connections
 * 5.Adding Objects with no hashCode() and equals() into a HashSet
 *
 * Avoid
 *
 * 1. need to pay close attention to our usage of static;
 * 2. interned String objects are stored in PermGen space
 * 3. try-with-resource clause.
 * 4. always close connections
 * 5. crucial to provide the hashCode() and equals() implementations.
 *
 * The second solution is to use Java 8 – where the PermGen space is replaced by the Metaspace – which won’t lead to any OutOfMemoryError when using intern on Strings:
 * Project Lombok – this provides a lot of default implementation by annotations, e.g. @EqualsAndHashCode.
 *
 * Analyze
 *
 * 1. By adding the -verbose:gc parameter to the JVM configuration
 * 2. Using profiler such as Visual VM,YourKit
 *
 */
public class MemoryLeak {
}
