package com.serli.tp.helper;

import com.serli.tp.java.oo.vehicules.Boat;
import com.serli.tp.java.oo.vehicules.Car;
import com.serli.tp.java.oo.vehicules.SportsCar;

import static org.junit.Assert.assertEquals;

public class VehiculeAssert {
    public static void assertDescribe(Car car, String state) {
        String describe = car.describe();
        assertEquals(createCarDescription(car, state), describe);
    }

    public static void assertDescribe(SportsCar sportsCar, String state) {
        String describe = sportsCar.describe();
        assertEquals(createSportsCarDescription(sportsCar, state), describe);
    }

    public static void assertDescribe(Boat boat, String state) {
        String anchoredState;
        if (boat.isAnchored()) {
            anchoredState = "I am anchored";
        } else {
            anchoredState = "I am not Enchored";
        }
        assertEquals(boat.describe(), "I am a boat, My name is " + boat.getName() + anchoredState + ", I am powered by " + boat.getPropulsion() + " and I am " + state);
    }

    private static String createCarDescription(Car car, String state) {
        return "I am a " + car.getName() + ", my year is " + car.getYear() + " I am " + state;
    }

    private static String createSportsCarDescription(SportsCar sportsCar, String state) {
        return createCarDescription(sportsCar, state) + "and I have " + sportsCar.getNbCylinders() + " cylinders";
    }
}
