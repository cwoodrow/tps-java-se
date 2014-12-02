package com.serli.tp.utils;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.assertEquals;

public class DateFormatterTest {
    private Date date;

    @Before
    public void before() {
        // Thu Oct 18 14:13:45 CEST 2012
        date = new Date(1350562425211l);

    }

    @Test
    public void shouldFormatToddMMyyyy(){
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String formattedDate = dateFormat.format(date);

        assertEquals("18/10/2012", formattedDate);
    }

    @Test
    public void shouldFormatToTextDate(){
        DateFormat dateFormat = new SimpleDateFormat("EEEE dd MMMM yyyy à hh:mm");
        String formattedDate = dateFormat.format(date);

        assertEquals("jeudi 18 octobre 2012 à 02:13", formattedDate);
    }
}
