/**
 * @author Arpit Bhardwaj
 *
 * Compile:
 * C:\Users\ARPIBHAR\IdeaProjects\CoreFundamentals\greeter.cli>javac -d out src/com/ab/main/Main.java src/module-info.java
 * Run:
 * C:\Users\ARPIBHAR\IdeaProjects\CoreFundamentals\greeter.cli>java -p out -m greeter.cli/com.ab.main.Main
 *
 * java --list-modules (list all the modules in JDK in sorted order)
 * java --describe-module java.sql (describes module)
 * java --show-module-resolution -p out -m <module names>
 *
 * Module Packaging
 * jar --create --file=mods/<jarname>.jar --module-version=1.0.0 -C out/ .
 * java --describe-module --file=mods/<jarname>.jar
 *
 * New Packaging Module
 *
 * jar --help
 *
 */
module greeter.cli {
    requires greeter.hello;
}