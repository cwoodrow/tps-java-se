package com.serli.tp.java.oo.vehicules;

import com.serli.tp.java.oo.printable.CanPrintDescription;

/**
 * This class is an abstraction of a vehicule
 */
public abstract class Vehicule implements CanPrintDescription {
    public static final String STOPPED_STATE = "stopped";

    private static int nbInstances = 0;

    protected String state = STOPPED_STATE;

    protected Vehicule() {
        nbInstances++;
    }

    /**
     * Describes the vehicule
     * @return the description
     */
    public abstract String describe();

    public abstract void start();

    public void stop() {
        state = Vehicule.STOPPED_STATE;
    }

    protected void setState(String state) {
        this.state = state;
    }

    public void printDescription() {
        System.out.println(describe());
    }

    public static int getNbInstances() {
        return nbInstances;
    }
}
