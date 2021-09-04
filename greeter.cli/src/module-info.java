
/**
 * @author Arpit Bhardwaj
 *
 * Compile:
 * C:\Users\ARPIBHAR\IdeaProjects\CoreFundamentals\greeter.cli>javac -d out src/com/ab/cli/Main.java src/module-info.java
 * Run:
 * C:\Users\ARPIBHAR\IdeaProjects\CoreFundamentals\greeter.cli>java -p out -m greeter.cli/com.ab.cli.Main
 *
 * jdeps is a tool that help in finding outdated nonpublic apis in you project or class and suggest you the possible replacement
 * jdeps -jdkinternals src/com/ab/cli/Main.class
 * Jdeps tool is also used to find the modules on which your jar file depends on...which is really helpful during migration
 * jdeps -s <non modular jar file>
 * In case if you want to generate directly module-info.java
 * jdeps --generate-module-info . <non modular jar file>
 *
 * Bottom Up Migration
 * Start writing the module-info.java for jars from the leaf
 * Third party jars you will be stuck and thats a limitation here.
 *
 * Top Down Migration.
 * Start writing the module-info.java for jars from the root
 * it will create Automatic Module for third party jars placed in module path
 *
 * Named Modules:
 * Named modules are actual proper modules which we create by defining module-info.java
 *
 * Automatic Module:
 * Name derived from Jar file name or Automatic-Module-Name header
 * The rules for determining the name include removing the extension, removing numbers, and changing special characters to periods (.)
 * Exports and opens all packages
 * implicitly requires all resolved modules
 * can access the classpath which named modules cannot. this is key difference compare to named modules
 * Automatic modules never contain module-info.java
 *
 * Unnamed Modules:
 * All code present in classpath is treated by JVM as a unnamed module in JPMS
 * It doesn't have module-info.java specs
 * the unnamed module can read everything form the modular jdk at runtime because compile time strong encapsulation is enforced
 *
 */

module greeter.cli {
    requires greeter.hello;
    requires greeter.api;
    uses com.ab.api.MessageService;
}