package com.ab.core.oop;

public class MultipleInheritance {

    interface Plant {
        default String grow() { return "Grow!"; }
    }

    interface Living {
        default String grow() { return "Super Growing!"; }
    }

    static class Tree implements Plant, Living, Broccoli {
        @Override
        public String grow() {
            return Broccoli.super.grow();
        }
        public static void main(String[] leaves) {
            Plant p = new Tree();
            System.out.print(((Living)p).grow());
        }
    }

    interface Broccoli extends Plant,Living{
        @Override
        default String grow() {
            return Living.super.grow();
            //or
            //return Plant.super.grow();
        }
    }
}
