package com.serli.tp.generics;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ArrayUtilsTest {
    @Test
    public void shouldTransformIntegerArrayToCollection() {
        Collection<Integer> integers = ArrayUtils.arrayToCollection(new Integer[]{12, 23, 2});

        assertEquals(3, integers.size());
        assertTrue(integers.contains(12));
        assertTrue(integers.contains(23));
        assertTrue(integers.contains(2));
    }
}
