package com.ab.core.nio;

import java.io.*;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.Instant;

public class CustomizeSerialization {

    class Person implements Serializable {

        private static final long serialVersionUID = -1894419180813272900L;

        private String name;
        private int age;
        private String city;

        private transient byte[] hash = new byte[32];

        public Person(String name, int age, String city) {
            this.name = name;
            this.age = age;
            this.city = city;
        }
        //below private methods is called by ObjectInputStream and ObjectOutputStream during serialization and deserialization process

        private void writeObject(ObjectOutputStream oos) throws IOException {
            //default writing behaviour
            oos.defaultWriteObject();
            //additional logic
            oos.writeObject(Instant.now());
        }

        private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
            //default reading behaviour
            ois.defaultReadObject();
            //additional logic
            //hash = generateHash();
        }

    }
}
