package com.serli.tp.utils;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;

public class NumberFormatterTest {

    private List<Double> doublesToFormat;

    @Before
    public void before(){
        doublesToFormat = new ArrayList<Double>();
        doublesToFormat.add(3.4);
        doublesToFormat.add(42d);
        doublesToFormat.add(7.50004);
    }

    @Test
    public void test(){
        NumberFormat numberFormat = new DecimalFormat("#.##");

        List<String> formattedDoubles = new ArrayList<String>();
        for(Double doubleToFormat : doublesToFormat){
            String formatted = numberFormat.format(doubleToFormat);
            formattedDoubles.add(formatted);
            System.out.println(formatted);
        }

        //assertArrayEquals(new String[]{"3,40", "42,00", "7,50"}, formattedDoubles.toArray(new String[formattedDoubles.size()]));
    }
}
