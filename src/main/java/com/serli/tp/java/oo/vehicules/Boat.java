package com.serli.tp.java.oo.vehicules;

import com.google.common.base.Preconditions;

import static com.google.common.base.Preconditions.checkArgument;

public class Boat extends Vehicule {
    public static final String NAVIGATING = "Navigating";

    private Propulsion propulsion;
    private String name;
    private boolean anchored;

    public Boat(Propulsion propulsion, String name) {
        checkArgument(propulsion != null);
        checkArgument(name != null && !name.isEmpty());

        this.propulsion = propulsion;
        this.name = name;
        this.anchored = true;
    }

    @Override
    public void start() {
        if (isAnchored()) {
            throw new UnsupportedOperationException("cannot start while anchored");
        }
        setState(NAVIGATING);
    }

    @Override
    public String describe() {
        String anchoredState;
        if (this.anchored) {
            anchoredState = "I am anchored";
        } else {
            anchoredState = "I am not Enchored";
        }
        return "I am a boat, My name is " + name + anchoredState + ", I am powered by " + propulsion + " and I am " + state;
    }

    public void throwAnchor() {
        if (state.equals(NAVIGATING)) {
            anchored = true;
        }
    }

    public void weighAnchor() {
        if (!state.equals(NAVIGATING)) {
            anchored = false;
        }
    }

    public boolean isAnchored() {
        return anchored;
    }

    public String getName() {
        return name;
    }

    public Propulsion getPropulsion() {
        return propulsion;
    }
}
