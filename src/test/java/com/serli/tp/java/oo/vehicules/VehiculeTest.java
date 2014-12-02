package com.serli.tp.java.oo.vehicules;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class VehiculeTest {
    @Test
    public void shouldAdd3Instances(){
        int initialNbInstances = Vehicule.getNbInstances();

        new Car(CarTest.NAME, CarTest.YEAR );
        new SportsCar(SportsCarTest.NAME, SportsCarTest.YEAR,SportsCarTest.NB_CYLINDERS);
        new Boat(Propulsion.ENGINE, BoatTest.NAME);

        assertEquals(3, Vehicule.getNbInstances() - initialNbInstances);
    }
}
