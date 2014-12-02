package com.serli.tp.utils;

import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static org.junit.Assert.assertEquals;

public class DateTest {

    private Date date;

    @Before
    public void before() {
        // Thu Oct 18 14:13:45 CEST 2012
        date = new Date(1350562425211l);

    }

    @Test
    public void shouldExstractDMY() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        assertEquals(18, calendar.get(Calendar.DAY_OF_MONTH));
        assertEquals(9, calendar.get(Calendar.MONTH));
        assertEquals(2012, calendar.get(Calendar.YEAR));
    }

    @Test
    public void shouldMoveToFistDayOfTheLastWeek() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_YEAR, calendar.getActualMaximum(Calendar.DAY_OF_YEAR));


        assertEquals(31, calendar.get(Calendar.DAY_OF_MONTH));
        assertEquals(11, calendar.get(Calendar.MONTH));
        assertEquals(2012, calendar.get(Calendar.YEAR));
    }
}
