package com.ab.core.oop;

/**
 * @author Arpit Bhardwaj
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

    static class Tree implements Living,Leaf, Plant {
        @Override
        public void grow() {
            //Leaf.super.grow();//compile error (redundant super call)
            Plant.super.grow();
        }
        public static void main(String[] leaves) {
            Plant p = new Tree();
            ((Living)p).grow();
        }
    }

    interface Plant extends Leaf,Living{
        @Override
        default void grow() {
            Living.super.grow();
            Leaf.super.grow();
        }
    }
}
