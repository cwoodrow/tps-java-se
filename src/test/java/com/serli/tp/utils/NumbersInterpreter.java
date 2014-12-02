package com.serli.tp.utils;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NumbersInterpreter {
    public static String TO_INTERPRET = "3 4.7 4";

    @Test
    public void shouldInterpretString() {
        String[] split = TO_INTERPRET.split(" ");

        int sum = 0;
        for (String value : split) {
            double parsedDouble = Double.parseDouble(value);

            sum += Math.floor(parsedDouble);
        }

        assertEquals(11, sum);
    }
}
