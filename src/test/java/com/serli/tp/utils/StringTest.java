package com.serli.tp.utils;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class StringTest {

    public static final String FIRST_NAMES = "Pierre , Paul, Jacques, Paul, Alfred, PIERRE";

    @Test
    public void shouldSplitIntoList() {
        String[] splitFirstNames = FIRST_NAMES.split(",");

        List<String> firstNamesList = new ArrayList<>();
        for (String firstName : splitFirstNames) {
            String upperCaseFirstName = firstName.toUpperCase().trim();
            if (!firstNamesList.contains(upperCaseFirstName)) {
                firstNamesList.add(upperCaseFirstName);
            }
        }

        assertEquals(4, firstNamesList.size());
        assertTrue(firstNamesList.contains("PIERRE"));
        assertTrue(firstNamesList.contains("PAUL"));
        assertTrue(firstNamesList.contains("JACQUES"));
        assertTrue(firstNamesList.contains("ALFRED"));
    }

    @Test
    public void shouldGetJacquesWithSubString() {
        String jacques = FIRST_NAMES.substring(15, 22);
        assertEquals("Jacques", jacques);
    }

    @Test
    public void shouldReplace() {
        String replaceAll = FIRST_NAMES.replaceAll("( )?,( )?", ":");
        assertEquals("Pierre:Paul:Jacques:Paul:Alfred:PIERRE", replaceAll);
    }
}
