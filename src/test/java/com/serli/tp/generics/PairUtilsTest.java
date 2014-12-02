package com.serli.tp.generics;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PairUtilsTest {
    @Test
    public void shouldBeTheSameContent(){
        Pair<String> stringPair1 = new Pair<>("one", "two");
        Pair<String> stringPair2 = new Pair<String>("one", "two");

        assertTrue(PairUtils.sameContent(stringPair1, stringPair2));
    }

    @Test
    public void shouldNotBeTheSameContent(){
        Pair<String> stringPair1 = new Pair<String>("one", "two");
        Pair<String> stringPair2 = new Pair<String>("one", "three");

        assertFalse(PairUtils.sameContent(stringPair1, stringPair2));
    }

}
