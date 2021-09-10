package com.ab.core.oop;

/**
 * @author Arpit Bhardwaj
 *
 * Inheritance Rule for Default Methods to resolve conflict
 *      Rule 1: A superclass method takes a priority over an interface default method
 *      Rule 2: A subtype interface's default method takes priority over a super-type interface's default method
 *      Rule 3: In case of conflict the concrete class must overiride deafult method and provide its own implementation
 *
 */
public class MultipleInheritance {

    interface Leaf {
        default void grow() {
            System.out.println("Leaf!!");
        }
    }

    interface Living {
        default void grow() {
            System.out.println("Living!!");
        }
    }

    static class Tree implements Living, Leaf, Plant {
        /*@Override
        public void grow() {
            System.out.println("Tree!!");
            //Leaf.super.grow();//compile error (redundant super call)
        }*/
        public static void main(String[] leaves) {
            Tree t = new Tree();
            ((Living)t).grow();//as per rule 2 subtype default method will be called
        }
    }

    interface Plant extends Leaf, Living{
        //as per rule 3 due to conflict Plant must override default method
        @Override
        default void grow() {
            System.out.println("Plant!!");
            Living.super.grow();
            //Leaf.super.grow();
        }
    }
}
