package com.serli.tp.data.structures;

import com.serli.tp.java.oo.vehicules.Car;
import com.serli.tp.java.oo.vehicules.SportsCar;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SetTest {

    public static final String RENAULT = "Renault";
    public static final String PEUGEOT = "Peugeot";
    public static final String PORSHE = "Porshe";
    private Set<Car> carsSet;

    @Before
    public void before() {
        carsSet = new HashSet<Car>();
        carsSet.add(new Car(RENAULT, 2012));
        carsSet.add(new Car(PEUGEOT, 2013));
        carsSet.add(new Car(PEUGEOT, 2013));
        carsSet.add(new SportsCar(PORSHE, 2013, 4));
    }

    @Test
    public void shouldHave3Cars() {
        assertEquals(3, carsSet.size());
    }

    @Test
    public void shouldCheckAllCars() {
        Iterator<Car> iterator = carsSet.iterator();
        Set<String> carNames = new HashSet<String>();
        while (iterator.hasNext()){
            Car car = iterator.next();
            carNames.add(car.getName());
        }

        assertEquals(3, carNames.size());
        assertTrue(carNames.contains(RENAULT));
        assertTrue(carNames.contains(PEUGEOT));
        assertTrue(carNames.contains(PORSHE));
    }
}
