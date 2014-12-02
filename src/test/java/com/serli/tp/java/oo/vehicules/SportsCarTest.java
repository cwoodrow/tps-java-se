package com.serli.tp.java.oo.vehicules;

import org.junit.Before;
import org.junit.Test;

import static com.serli.tp.helper.VehiculeAssert.assertDescribe;

public class SportsCarTest {
    public static final String NAME = "Porsche";
    public static final int YEAR = 1974;
    public static final int NB_CYLINDERS = 12;
    private SportsCar testedObject;

    @Before
    public void before() {
        testedObject = new SportsCar(NAME, YEAR, NB_CYLINDERS);
    }

    @Test
    public void shouldDescribe() {
        assertDescribe(testedObject, Vehicule.STOPPED_STATE);
    }

    @Test
    public void shouldDriveFast() {
        testedObject.start();
        assertDescribe(testedObject, SportsCar.DRIVING_FAST_STATE);

    }
}
