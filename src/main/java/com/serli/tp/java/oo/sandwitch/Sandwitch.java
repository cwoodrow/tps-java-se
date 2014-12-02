package com.serli.tp.java.oo.sandwitch;

import com.serli.tp.java.oo.printable.CanPrintDescription;

public class Sandwitch implements CanPrintDescription {

    @Override
    public void printDescription() {
        System.out.println("I am a Sandwitch");
    }
}
