package com.serli.tp.generics;

import com.serli.tp.java.oo.vehicules.Car;
import com.serli.tp.java.oo.vehicules.SportsCar;
import com.serli.tp.java.oo.vehicules.Vehicule;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PECSTest {
    private PECS testedObject = new PECS();

    @Test
    public void shouldGetNames(){
        List<SportsCar> sportsCars = new ArrayList<SportsCar>();
        sportsCars.add(new SportsCar("Porsche", 2012, 6));
        sportsCars.add(new SportsCar("Ferrari", 1992, 12));
        List<String> carNames = testedObject.getNames(sportsCars);

        assertEquals(2, carNames.size());
        assertTrue(carNames.contains("Porsche"));
        assertTrue(carNames.contains("Ferrari"));
    }

    @Test
    public void shouldAddRandomCars(){
        List<Car> cars = new ArrayList<Car>();
        SportsCar peugeot = new SportsCar("PeugeotSport", 2014,12);
        cars.add(peugeot);

        testedObject.addNewRandomCar(cars, 10);

        assertEquals(11, cars.size());
        assertTrue(cars.contains(peugeot));
    }
}
