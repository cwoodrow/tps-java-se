package com.serli.tp.java.oo.vehicules;

import static com.google.common.base.Preconditions.checkArgument;

public class SportsCar extends Car {
    public static final String DRIVING_FAST_STATE = "Driving Fast";
    private int nbCylinders;

    public SportsCar(String name, int year, int nbCylinders) {
        super(name, year);
        checkArgument(nbCylinders > 0);

        this.nbCylinders = nbCylinders;
    }

    @Override
    public void start() {
        setState(DRIVING_FAST_STATE);
    }

    @Override
    public String describe() {
        return super.describe() + "and I have " + nbCylinders + " cylinders";
    }

    public int getNbCylinders() {
        return nbCylinders;
    }
}
