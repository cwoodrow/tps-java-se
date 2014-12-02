package com.serli.tp.java.oo.vehicules;

import org.junit.Before;
import org.junit.Test;

import static com.serli.tp.helper.VehiculeAssert.assertDescribe;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BoatTest {
    public static final String NAME = "L'intrépide";
    private Boat testedObject;

    @Before
    public void before() {
        testedObject = new Boat(Propulsion.SAIL, NAME);
    }

    @Test
    public void shouldStartAnchored() {
        assertTrue(testedObject.isAnchored());
    }

    @Test
    public void shouldDescribe() {
        assertDescribe(testedObject, Vehicule.STOPPED_STATE);
    }

    @Test
    public void shouldBeNavigatingOnStart() {
        testedObject.weighAnchor();
        testedObject.start();

        assertDescribe(testedObject, Boat.NAVIGATING);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void shouldNotStartWhenAnchored() {
        assertTrue(testedObject.isAnchored());
        testedObject.start();
    }

    @Test
    public void shouldBeAnchored() {
        testedObject.weighAnchor();
        assertDescribe(testedObject, Boat.STOPPED_STATE);
        assertFalse(testedObject.isAnchored());
    }

    @Test
    public void shouldNotBeAnchored() {
        testedObject.weighAnchor();
        testedObject.throwAnchor();
        assertDescribe(testedObject, Boat.STOPPED_STATE);
        assertFalse(testedObject.isAnchored());
    }
}
