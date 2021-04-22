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
 * C:\Users\ARPIBHAR\IdeaProjects\CoreFundamentals\testmodule>javac -d out src/com/ab/basic/ModuleBasic.java src/module-info.java
 * or (if you multiple modules in a source directory)
 * javac -d out --module-source-path <src directory> -m <module names>
 * Run:
 * -p : Module Path
 * -m : modules
 * C:\Users\ARPIBHAR\IdeaProjects\CoreFundamentals\testmodule>java -p out -m testmodule/com.ab.basic.ModuleBasic
 *
 * requires is followed by a module name
 * exports is followed by a package name
 *
 */
module testmodule {
}