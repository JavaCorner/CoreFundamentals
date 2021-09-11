package com.ab.core.nio;

import java.io.*;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.Instant;

/**
 * @author Arpit Bhardwaj
 *
 *
 * readResolve
 *      is used for replacing the object read from the stream.
 *      is used for enforcing singletons; when an object is read, replace it with the singleton instance.
 *      This ensures that nobody can create another instance by serializing and deserializing the singleton.
 *
 *
 * transient
 *      block a field from being serialized
 *  ObjectStreamField
 *      allows a field to be serialized
 */

public class CustomizeSerialization implements Serializable{

    private static final long serialVersionUID = -1894419180813272900L;

    private transient byte[] hash = new byte[32];
    public static final  CustomizeSerialization INSTANCE = new CustomizeSerialization();

    private static final ObjectStreamField[] serialPersistentFields = {
            new ObjectStreamField("email", String.class)
    };

    private CustomizeSerialization() {
        if (INSTANCE != null)
            throw new RuntimeException("Singleton instance already exists!");
    }

    //called by ObjectOutputStream during serialization process
    private void writeObject(ObjectOutputStream oos) throws IOException {
        //default writing behaviour
        oos.defaultWriteObject();
        //additional logic
        oos.writeObject(Instant.now());//writing timestamp
    }

    //called by ObjectInputStream during deserialization process
    private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
        // Configuring allow list
        ois.setObjectInputFilter(new ObjectInputFilter() {
            public Status checkInput(FilterInfo fi) {
                if (fi.arrayLength() > 10) return Status.REJECTED;
                if (fi.depth() > 10) return Status.REJECTED;
                if (fi.references() > 1000) return Status.REJECTED;
                return Status.UNDECIDED;
            }
        });

        //default reading behaviour
        ois.defaultReadObject(); //invokes the default deserialization mechanism, and it will deserialize your non-static, non-transient fields.
        //additional logic
        //hash = generateHash();

    }

    private Object readResolve() {
        return INSTANCE;
    }

    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        CustomizeSerialization instance = CustomizeSerialization.INSTANCE;

        System.out.println("Before serialization: " + instance);

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("file1.ser"))) {
            out.writeObject(instance);
        }

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("file1.ser"))) {
            CustomizeSerialization readObject = (CustomizeSerialization) in.readObject();
            System.out.println("After deserialization: " + readObject);
        }

    }
}
