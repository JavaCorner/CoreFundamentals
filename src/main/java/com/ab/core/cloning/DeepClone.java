package com.ab.core.cloning;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Arpit Bhardwaj
 */
public class DeepClone {

    private static final Logger logger = Logger.getLogger(DeepClone.class.getName());

    public static void main(String[] args) {
        logger.setLevel(Level.INFO);
        Collection<Employee> employeeSet = new HashSet<>();

        employeeSet.add(new Employee("Joe", "Manager"));
        employeeSet.add(new Employee("Tim", "Developer"));
        employeeSet.add(new Employee("Frank", "Developer"));

        logger.info("Original : " + employeeSet.toString());

        // creating copy of Collection using copy constructor (Shallow cloning)
        //Collection<Employee> employeeSetCopy = new HashSet<>(employeeSet);

        // use below approach for deep cloning
        Collection<Employee> employeeSetCopy = new HashSet<>(employeeSet.size());
        Iterator<Employee> copyIterator = employeeSet.iterator();
        while (copyIterator.hasNext()){
            employeeSetCopy.add(copyIterator.next().clone());
        }

        logger.info("Copy : " + employeeSetCopy.toString());

        Iterator<Employee> iterator = employeeSet.iterator();

        while (iterator.hasNext()){
            iterator.next().setDesignation("Staff");
        }

        logger.info("Original : " + employeeSet.toString());
        logger.info("Copy : " + employeeSetCopy.toString());

    }
}
