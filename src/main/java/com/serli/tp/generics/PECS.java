package com.serli.tp.generics;

import com.serli.tp.java.oo.vehicules.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static com.google.common.base.Preconditions.checkArgument;

public class PECS {
    public List<String> getNames(List<? extends Car> cars) {
        checkArgument(cars != null);

        List<String> names = new ArrayList<String>();
        for (Car car : cars) {
            names.add(car.getName());
        }
        return names;
    }

    public void addNewRandomCar(List<? super Car> cars, int numberOfCarsToAdd) {
        checkArgument(cars != null);

        for (int i = 0; i < numberOfCarsToAdd; i++) {
            cars.add(new Car(UUID.randomUUID().toString(), (int) (1900 + Math.random() * 112)));
        }
    }
}
