package com.serli.tp.data.structures;

import com.serli.tp.java.oo.vehicules.Car;
import com.serli.tp.java.oo.vehicules.SportsCar;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static com.serli.tp.helper.VehiculeAssert.assertDescribe;
import static org.junit.Assert.assertEquals;

public class ListTest {

    private List<Car> carsList;

    @Before
    public void before() {
        carsList = new ArrayList<Car>();
        carsList.add(new Car("Renault", 2012));
        carsList.add(new SportsCar("Porshe", 2013, 4));
    }

    @Test
    public void shouldDescribe() {
        assertDescribe(carsList.get(0), Car.STOPPED_STATE);
    }

    @Test
    public void shouldCeckAllCars() {
        String carNames = "";
        for (Car car : carsList) {
            carNames += car.getName();
        }

        assertEquals(
                carsList.get(0).getName() + carsList.get(1).getName(),
                carNames);
    }
}
