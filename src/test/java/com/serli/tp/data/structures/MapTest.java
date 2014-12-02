package com.serli.tp.data.structures;

import com.serli.tp.java.oo.vehicules.Car;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static com.serli.tp.helper.VehiculeAssert.assertDescribe;
import static org.junit.Assert.*;

public class MapTest {

    private Map<String, Car> carsByName;

    @Before
    public void before() {
        carsByName = new HashMap<String, Car>();

        carsByName.put("Renault", new Car("Renault", 2012));
        carsByName.put("Peugeot", new Car("Peugeot", 2013));
    }

    @Test
    public void shouldRetrieveFirstCar() {
        assertDescribe(carsByName.get("Renault"), Car.STOPPED_STATE);
    }

    @Test
    public void shouldRetrieveKeys() {
        Set<String> keys = carsByName.keySet();
        for(String key : keys){
            System.out.println(key);
        }

        assertEquals(2, keys.size());
    }
}
