
/**
 * @author Arpit Bhardwaj
 *
 * Compile:
 *      C:\Users\ARPIBHAR\IdeaProjects\CoreFundamentals\greeter.cli>javac -d out src/com/ab/cli/Main.java src/module-info.java
 * Run:
 *      C:\Users\ARPIBHAR\IdeaProjects\CoreFundamentals\greeter.cli>java -p out -m greeter.cli/com.ab.cli.Main
 *
 * jdeps
 *      is a tool that help in finding outdated nonpublic apis in you project or class and suggest you the possible replacement
 *          jdeps -jdkinternals src/com/ab/cli/Main.class
 *      is also used to find the modules on which your jar file depends on...which is really helpful during migration
 *          jdeps -s <non modular jar file> //s stands for summary
 *      in case if you want to generate directly module-info.java
 *          jdeps --generate-module-info . <non modular jar file>
 *
 * Before making a decision to migrate to Java 9, it’s important to know the result you want to achieve:
 *
 * You just want to make your Java application simply run on JDK 9 and you don’t want to define any modules inside the code (Only the classpath is used).
 * You want to modularize only a part of an application and keep the rest of it not modularized (Both the classpath and the module path are used).
 * You want to modularize the whole application (Only the module path is used).
 *
 * Bottom Up Migration
 *      Start writing the module-info.java for jars from the leaf
 *      Third party jars you will be stuck and that's a limitation here.
 *
 * Top Down Migration.
 *      Starts by first moving all the modules to the module path as automatic modules.
 *      Start changing each module from an automatic module to a named module
 *      Start writing the module-info.java for jars
 *      it will create automatic module for third party jars placed in module path
 *
 * Named Modules:
 *      Named modules are actual proper modules which we create by defining module-info.java
 *
 * Automatic Module:
 *      Name derived from Jar file name or Automatic-Module-Name header
 *      The rules for determining the name include removing the extension, removing numbers, and changing special characters to periods (.)
 *      Exports and opens all packages
 *      implicitly requires all resolved modules
 *      can access the classpath which named modules cannot. this is key difference compare to named modules
 *      never contain module-info.java
 *
 * Unnamed Modules:
 *      All code present in classpath is treated by JVM as a unnamed module in JPMS
 *      is permitted to have a module‐info file, but the file is ignored if present.
 *      the unnamed module can read everything form the modular jdk at runtime because compile time strong encapsulation is enforced
 *
 * Code on the classpath can reference code in automatic, named, or unnamed module
 */

module greeter.cli {
    requires greeter.hello;
    requires greeter.api;
    uses com.ab.api.MessageService;
}