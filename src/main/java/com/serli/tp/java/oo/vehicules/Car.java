package com.serli.tp.java.oo.vehicules;

import com.google.common.base.Preconditions;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

import static com.google.common.base.Preconditions.checkArgument;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Car extends Vehicule implements Serializable{
    public static final String DRIVING_STATE = "driving";

    private String name;
    private int year;

    @SuppressWarnings("unused")
    private Car(){
    }

    public Car(String name, int year) {
        checkArgument(name != null && !name.isEmpty());
        checkArgument(year > 0);

        this.name = name;
        this.year = year;
    }

    @Override
    public void start() {
        setState(DRIVING_STATE);
    }

    @Override
    public String describe() {
        return "I am a " + name + ", my year is " + year + " I am " + state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Car car = (Car) o;

        if (year != car.year) {
            return false;
        }
        if (!name.equals(car.name)) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + year;
        return result;
    }

    public String getName() {

        return name;
    }

    public int getYear() {
        return year;
    }


}
