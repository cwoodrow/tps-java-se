package com.serli.tp.generics;

import com.serli.tp.java.oo.vehicules.Car;
import com.serli.tp.java.oo.vehicules.SportsCar;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PairTest {
    @Test
    public void shouldCreateAnIntegersPair() {
        Pair<Integer> integersPair = new Pair<Integer>(2, 3);

        assertEquals(Integer.valueOf(2), integersPair.getLeft());
        assertEquals(Integer.valueOf(3), integersPair.getRight());
    }

    @Test
    public void shouldCreateACarsPair() {
        Car peugeot = new Car("Peugeot", 2013);
        SportsCar corvette = new SportsCar("Corvette", 2003, 8);
        Pair<Car> carsPair = new Pair<Car>(peugeot, corvette);

        assertEquals(peugeot, carsPair.getLeft());
        assertEquals(corvette, carsPair.getRight());
    }

}
