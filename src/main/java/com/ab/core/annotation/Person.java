package com.ab.core.annotation;

import com.ab.core.annotation.Version;

/**
 * @author Arpit Bhardwaj
 *
 * Attributes are set as list of name value pairs @Annotation(name=value, arrayName={e1,e2})
 *      When no attributes are used, then () can be ommited
 *      When only single attribute need to set, then its name can be omitted
 *      if array attribute has only one value, then {} can be omitted
 *      Attributes with default value can be omitted
 */

@Version(value=1)
@Version(2)
public class Person {

    protected Long id;
    protected String name;

    @Version(1)
    public Person(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    /*
    Warnings can be two types:
        unchecked : caused by the assignment of raw type to generic type variable
        deprecation : caused by the use of outdated APIs
     */
    @Version(1)
    @SuppressWarnings({"unchecked","deprecation"})
    public String greet(){
        return "Hi, I am " + this.name;
    }

    /*
    forRemoval
        true:indicates intent to remove the annotated program in future version
        false:indicates that the use of annotated program is discouraged, but at the time the program was annotated;
              there was no specific intent to remove it
     */
    @Deprecated(since="1.0.2",forRemoval = true)
    public String details(){
        return String.format("[%s] %s", this.id, this.name);
    }

    public String detailsV2(){
        return String.format("[%s] %s", this.id, this.name);
    }
}
