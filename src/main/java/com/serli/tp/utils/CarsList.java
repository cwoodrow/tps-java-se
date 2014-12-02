package com.serli.tp.utils;

import com.serli.tp.java.oo.vehicules.Car;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name="cars")
@XmlAccessorType(XmlAccessType.FIELD)
public class CarsList {
    @XmlElement(name = "car")
    private List<Car> cars = new ArrayList<>();

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }


}
