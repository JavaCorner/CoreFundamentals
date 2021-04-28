
/**
 * @author Arpit Bhardwaj
 *
 *  Module Naming Convention
 *  Allowed (letters, numbers, $, _, .)
 *  An identifier name must begin with a letter, dollar sign ($), or underscore (_).
 *  Numbers are permitted only for subsequent characters
 *  An identifier may not be a single underscore, though single dollar sign is required
 *  Dot(.) is alowed only in between
 *
 * Compile:
 * C:\Users\ARPIBHAR\IdeaProjects\CoreFundamentals\greeter.hello>javac -d out src/com/ab/main/Main.java src/module-info.java
 * or (if you multiple modules in a source directory)
 * javac -d out --module-source-path <src directory> -m <module names>
 * Run:
 * -p : Module Path
 * -m : modules
 * C:\Users\ARPIBHAR\IdeaProjects\CoreFundamentals\greeter.hello>java -p out -m greeter.hello/com.ab.main.Main
 *
 * requires <module>
 * exports <package>
 * opens <package>
 * open module implicitly opens all packages
 * requires transitive (whoever is requires x module get also all his requires transitive dependecies implicitly)
 * provides <package><type_name> with <package><type_name>
 * uses <package><type_name>
 *
 */

module greeter.hello {
    exports com.ab.service; //export to everyone
    //exports com.ab.service to greeter.cli; //export only to greeter.cli
    //opens com.ab.util; //open only for reflective access at runtime
    //opens com.ab.util to greeter.cli, java.base;//open only to greeter.cli and java.base
    requires greeter.api;
    provides com.ab.api.MessageService with com.ab.service.HelloMessageService;
}