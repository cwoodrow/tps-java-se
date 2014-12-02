package com.serli.tp.io;

import com.serli.tp.java.oo.vehicules.Car;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ObjectSerlializationTest {
    private ObjectSerlialization testedObject = new ObjectSerlialization();

    @Test
    public void shouldSerializeAndUnSerialize() throws IOException, ClassNotFoundException {
        File tempFile = File.createTempFile("ObjectSerlializationTest", ".obj");

        testedObject.storeObjectIntoFile(tempFile.getAbsolutePath(), new Car("Peugeot", 2002));

        Object object = testedObject.getObjectFromFile(tempFile.getAbsolutePath());

        assertTrue(object instanceof Car);
        Car car = (Car) object;
        assertEquals("Peugeot", car.getName());
        assertEquals(2002, car.getYear());

    }
}
