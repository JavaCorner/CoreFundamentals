package com.ab.core.cloning;

/**
 * @author Arpit Bhardwaj
 */
public class Employee implements Cloneable{
    private String name;
    private String designation;

    public Employee(String name, String designation) {
        this.name = name;
        this.designation = designation;
    }

    public String getName() {
        return name;
    }

    public String getDesignation() {
        return designation;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", designation='" + designation + '\'' +
                '}';
    }

    //return copy of a cloned object to support deep copy
    @Override
    protected Employee clone() {
        Employee cloneEmployee = null;
        try {
            cloneEmployee =  (Employee) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return cloneEmployee;
    }

}
