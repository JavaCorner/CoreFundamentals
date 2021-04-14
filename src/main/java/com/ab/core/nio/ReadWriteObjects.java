package com.ab.core.nio;

import java.io.*;

/**
 * @author Arpit Bhardwaj
 *
 */
public class ReadWriteObjects {
    public static void main(String[] args) {
        Person p1 = new Person("Arpit",30,"Bengaluru");
        Person p2 = new Person("Nisha",29,"Bengaluru");

        /*try (FileOutputStream fos = new FileOutputStream("files/persons.bin");
             ObjectOutputStream oos = new ObjectOutputStream(fos)){
            oos.writeObject(p1);
            oos.writeObject(p2);
        }catch (IOException e) {
            e.printStackTrace();
        }*/
        //if the class is not found which the persons.bin is referring then ClassNotFoundException is raised
        //if any filed name is changed in class which the persons.bin is referring then InvalidClassException is raised

        //java.io.InvalidClassException: com.ab.core.nio.Person; local class incompatible: stream classdesc serialVersionUID = -7137426691571486177, local class serialVersionUID = -1894419180813272900

        //in order to silently pass InvalidClassException, there should be a serialVersion Id present in class
        //missing fields will have default value
        try (FileInputStream fis = new FileInputStream("files/persons.bin");
             ObjectInputStream ois = new ObjectInputStream(fis)){
            System.out.println(ois.readObject());
            System.out.println(ois.readObject());
        }catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
