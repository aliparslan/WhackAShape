// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I
// accept the actions of those who do.
// -- Alip Arslan (906347003)
package game;

import student.TestCase;

import student.TestableRandom;

/**
 * 
 * Tests the SimpleArrayBag class's methods and 
 * all of its possible conditions.
 * 
 * @author aliparslan
 * @version 2021.03.02
 *
 */

public class SimpleArrayBagTest extends TestCase {

    // Fields .....................................
    private SimpleArrayBag<String> bag;

    // Constructor ................................

    /**
     * Empty constructor
     */
    public SimpleArrayBagTest() {
        // intentionally left empty
    }

    // Methods ....................................


    /**
     * The code to be run before each test is performed
     */
    public void setUp() {
        bag = new SimpleArrayBag<String>();
    }


    /**
     * Tests add when the object is null or a string
     */
    public void testAdd() {
        assertFalse(bag.add(null));

        bag.add("A");
        assertEquals(1, bag.getCurrentSize());

        for (int i = 0; i < 17; i++) {
            // Fills up bag to have 18 items
            bag.add("B");
        }
        assertFalse(bag.add("Hello"));
    }


    /**
     * Tests the current size when it is empty and
     * after items are added to it
     */
    public void testGetCurrentSize() {
        assertEquals(0, bag.getCurrentSize());

        bag.add("Hello");
        assertEquals(1, bag.getCurrentSize());

        for (int i = 0; i < 17; i++) {
            // Fills up bag to have 18 items
            bag.add("B");
        }
        assertEquals(18, bag.getCurrentSize());
    }


    /**
     * Tests whether the bag is empty
     */
    public void testIsEmpty() {
        assertTrue(bag.isEmpty());

        bag.add("Hello");
        assertFalse(bag.isEmpty());
    }


    /**
     * Tests pick when the item is null or
     * from a set of strings
     */
    public void testPick() {
        assertNull(bag.pick());

        bag.add("A");
        bag.add("B");
        bag.add("C");
        bag.add("D");
        bag.add("E");

        TestableRandom.setNextInts(0, 3);
        // About to test picking the 0th and 3rd indices

        assertEquals("A", bag.pick());
        assertEquals("D", bag.pick());
    }


    /**
     * Tests remove when it is not possible, and
     * when the item is in the bag
     */
    public void testRemove() {
        bag.add("A");
        assertFalse(bag.remove("Z"));

        bag.add("B");
        bag.add("C");
        assertTrue(bag.remove("B"));
        assertEquals(2, bag.getCurrentSize());

        assertFalse(bag.remove("B"));
        // using above because getIndexOf cannot be invoked
        // since B has been removed, it should not be possible again.
    }
}
