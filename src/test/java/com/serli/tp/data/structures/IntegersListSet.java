package com.serli.tp.data.structures;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class IntegersListSet {

    private List<Integer> integers;

    @Before
    public void before() {
        integers = new ArrayList<Integer>();
        Integer i = 12;
        integers.add(3);
        integers.add(2);
        integers.add(i);
    }

    @Test
    public void shouldGetSorted() {
        Collections.sort(integers);

        Integer[] sorted = {2,3,12};
        assertArrayEquals(sorted, integers.toArray(new Integer[integers.size()]));
    }

    @Test
    public void shoudRetrieveMax(){
        Integer max = Collections.max(integers);

        assertEquals(Integer.valueOf(12), max);
    }

}
