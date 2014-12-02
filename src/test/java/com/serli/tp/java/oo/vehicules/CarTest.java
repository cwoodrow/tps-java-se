package com.serli.tp.java.oo.vehicules;

import org.junit.Before;
import org.junit.Test;

import static com.serli.tp.helper.VehiculeAssert.assertDescribe;

public class CarTest {
    public static final String NAME = "Renault";
    public static final int YEAR = 2014;

    private Car testedObject;

    @Before
    public void before() {
        testedObject = new Car(NAME, YEAR);
    }

    @Test
    public void shouldDescribe() {
        assertDescribe(testedObject, Vehicule.STOPPED_STATE);
    }

    @Test
    public void shouldBeDrivingOnStart() {
        testedObject.start();
        assertDescribe(testedObject, Car.DRIVING_STATE);
    }

    @Test
    public void shouldBeStopped() {
        testedObject.stop();

        assertDescribe(testedObject, Vehicule.STOPPED_STATE);
    }


}
