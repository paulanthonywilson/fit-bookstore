package com.merecomplexities.dummyproxy;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 */
public class TestDummyProxy {

    private PartialSquirrelImplementation partialSquirrelImplementation;


    @Before
    public void setUp() throws Exception {
        partialSquirrelImplementation = new PartialSquirrelImplementation();
    }

    @Test
    public void shouldImplementTheInterface() throws Exception {
        Squirrel squirrel = DummyProxy.dummy(Squirrel.class, this);
        assertNotNull(squirrel);
    }

    @Test
    public void shouldCallTheInterfaceMethodOnThePartialImplementation() throws Exception {
        testeeProxy().climbTree();
        assertEquals("Tree climbed", true, partialSquirrelImplementation.treeClimbed);
    }

    @Test
    public void shouldDistinguishBetweenOverloadedMethods() throws Exception {
        testeeProxy().hideNuts();
        assertEquals(1, partialSquirrelImplementation.nutsHidden);
        testeeProxy().hideNuts(2);
        assertEquals(3, partialSquirrelImplementation.nutsHidden);
    }

    @Test
    public void shouldReturnTheValue() throws Exception {
        partialSquirrelImplementation.nutsHidden = 5;
        assertEquals(5, testeeProxy().getHiddentNutsCount());
    }

    @Test
    public void shouldPropogateTheThrownRuntimeException() throws Exception {
        try {
            testeeProxy().jumpToTheBlueTree();
            fail("Expecting UnsupportedOperationException");
        }
        catch (UnsupportedOperationException e) {

        }
    }


    @Test
    public void defaultShouldThrowUnsupportedOperationExceptionIfMethodNotImplemented() throws Exception {
        try {
            testeeProxy().jumpToTheRedTree();
            fail("Expecting UnsupportedOperationException");
        }
        catch (UnsupportedOperationException e) {

        }
    }


    @Test
    public void shouldReturnNullIfMethodNotImplementedAndReturningNullOptionIsUsed() throws Exception {
        Squirrel testee = DummyProxy.dummyReturningNullOnUnrecognised(Squirrel.class, this);
        assertNull(testee.jumpToTheRedTree());
    }

    @Test
    public void sholdPropogateTheThrownCheckedException() throws Exception {
        try {
            testeeProxy().doSquirrelDance();
            fail("Expecting TooTiredtoDanceException");
        }
        catch (TooTiredToDanceException e) {

        }
    }



    private Squirrel testeeProxy() {
        return DummyProxy.dummy(Squirrel.class, partialSquirrelImplementation);
    }


    public static interface Squirrel {
        void climbTree();

        void hideNuts();

        void hideNuts(int count);

        int getHiddentNutsCount();

        void jumpToTheBlueTree();

        void doSquirrelDance() throws TooTiredToDanceException;

        Object jumpToTheRedTree();

    }

    public static class TooTiredToDanceException extends Exception {
    }

    public static class PartialSquirrelImplementation {
        private boolean treeClimbed;
        private int nutsHidden;

        public void jumpToTheBlueTree() throws UnsupportedOperationException {
            throw new UnsupportedOperationException("jumpToTheBlueTree");
        }

        public void doSquirrelDance() throws TooTiredToDanceException {
            throw new TooTiredToDanceException();
        }

        public void climbTree() {
            treeClimbed = true;
        }

        public void hideNuts(int count) {
            nutsHidden += count;
        }

        public void hideNuts() {
            nutsHidden++;
        }

        public int getHiddentNutsCount() {
            return nutsHidden;
        }
    }


}
