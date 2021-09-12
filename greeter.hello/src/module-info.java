
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
 * Shorts
 *      module-path p
 *      module      m
 *
 * Compile Module
 *      javac -p <path to other module>
 *            -d <compiled output folder>
 *            -sourcepath <path to source code>
 *
 * Run Module
 *      java -p <path to compiled modules>
 *           -m <module name><fully qualified main class name>
 *           <arguments>
 *
 * Package module
 *      jar --create -f <path and name of jar file>
 *          --main-class <fully qualified main class name>
 *          -C <path to compiled module code>
 *
 * New Packaging Module
 *      jmod (create|extract|list|describe|hash) [options] jmod-file
 *
 * Verify Modules
 *      java --list-modules (list all the modules in JDK in sorted order)
 *      java --describe-module <module names> (describes module)
 *      java --show-module-resolution
 *              -p <path to modules>
 *              -m <module name><fully qualified main class name>
 *
 * Create Runtime Image
 *      jlink --module-path <path to compiled module and %JAVA_HOME/jmods folder>
 *            --add-modules <list of module names>
 *            --bind-services
 *            --launcher <command name>
 *            --output <name of the runtime image>
 * Compile:
 *      C:\Users\ARPIBHAR\IdeaProjects\CoreFundamentals\greeter.hello>javac -d out src/com/ab/main/Main.java src/module-info.java
 * Run:
 *      C:\Users\ARPIBHAR\IdeaProjects\CoreFundamentals\greeter.hello>java -p out -m greeter.hello/com.ab.main.Main
 *
 * <open(optional)> module <this module name> {
 *
 * all keywords are plural except open to whole module and version
 *      requires java.base //this reference is implicitly included in all modules
 *      requires <other module name>
 *      requires transitive <other module name> //whoever is requires this module get also all his requires transitive dependecies implicitly)
 *      requires static <other module name> //requires this module at compile time only
 *
 *      exports <package of this module to other module that require them>
 *      exports <package of this module to other module that require them> to <other module name comma separated>
 *
 *      opens <package of this module to other module via reflection>
 *      opens <package of this module to other module via reflection> to <other module name comma separated>
 *
 *      //below clause is used by service consumer or locator
 *      uses <fully qualified service name provided by other modules>
 *      //below clause is used by service provider
 *      provides <fully qualified service name to other modules> with <fully qualified service implementation name>
 *
 *      version <value>
 *      }
 *
 * open module implicitly opens all packages.
 * requires java.base is implied for all modules implicitly.
 */

module greeter.hello {
    exports com.ab.service; //export to everyone
    //exports com.ab.service to greeter.cli; //export only to greeter.cli
    //opens com.ab.util; //open only for reflective access at runtime
    //opens com.ab.util to greeter.cli, java.base;//open only to greeter.cli and java.base
    requires greeter.api;
    provides com.ab.api.MessageService with com.ab.service.HelloMessageService;
}