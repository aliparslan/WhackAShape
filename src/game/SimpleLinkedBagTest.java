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
 * Tests the SimpleLinkedBag class's methods and 
 * all of its possible conditions.
 * 
 * @author aliparslan
 * @version 2021.03.02
 *
 */

public class SimpleLinkedBagTest extends TestCase {

    // Fields .....................................

    private SimpleLinkedBag<String> bag;

    // Constructor ................................

    /**
     * Empty constructor
     */
    public SimpleLinkedBagTest() {
        // Intentionally left empty
    }

    // Methods ....................................


    /**
     * The code to be run before each test is performed
     */
    public void setUp() {
        bag = new SimpleLinkedBag<String>();
    }


    /**
     * Tests add when the object is null or a string
     */
    public void testAdd() {
        assertFalse(bag.add(null));

        assertTrue(bag.add("A"));
        assertEquals(1, bag.getCurrentSize());
    }


    /**
     * Tests the current size when it is empty and
     * after items are added to it
     */
    public void testGetCurrentSize() {
        assertEquals(0, bag.getCurrentSize());

        bag.add("A");
        assertEquals(1, bag.getCurrentSize());

        bag.add("A");
        bag.add("A");
        bag.add("A");
        bag.add("A");
        bag.add("A");
        bag.add("A");
        assertEquals(7, bag.getCurrentSize());
    }


    /**
     * Tests whether the bag is empty
     */
    public void testIsEmpty() {
        assertTrue(bag.isEmpty());

        bag.add("A");
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

        assertEquals("E", bag.pick());
        assertEquals("B", bag.pick());
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

        assertFalse(bag.remove("B"));
        // using above because getIndexOf cannot be invoked
        // since B has been removed, it should not be possible again.
    }

}
