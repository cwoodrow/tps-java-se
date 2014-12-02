package com.serli.tp.io;

import com.google.common.base.Preconditions;

import java.io.*;

import static com.google.common.base.Preconditions.checkArgument;

public class ObjectSerlialization {
    public void storeObjectIntoFile(String filePath, Object objectToSerialize) throws IOException {
        checkArgument(filePath != null);
        checkArgument(objectToSerialize != null);

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filePath));

        objectOutputStream.writeObject(objectToSerialize);

        objectOutputStream.close();
    }

    public Object getObjectFromFile(String filePath) throws IOException, ClassNotFoundException {
        checkArgument(filePath != null);

        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(filePath));

        return inputStream.readObject();
    }
}
