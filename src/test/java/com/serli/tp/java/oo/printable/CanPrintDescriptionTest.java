package com.serli.tp.java.oo.printable;

import com.serli.tp.java.oo.sandwitch.Sandwitch;
import com.serli.tp.java.oo.vehicules.*;
import org.junit.Test;

public class CanPrintDescriptionTest {

    @Test
    public void shouldPrintDescription(){
        CanPrintDescription[] printables = {
                new Car(CarTest.NAME, CarTest.YEAR),
                new SportsCar(SportsCarTest.NAME, SportsCarTest.YEAR, SportsCarTest.NB_CYLINDERS),
                new Boat(Propulsion.SAIL, BoatTest.NAME),
                new Sandwitch()
        };

        for(CanPrintDescription printable : printables){
            printable.printDescription();
        }
    }
}
