// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I
// accept the actions of those who do.
// -- Alip Arslan (906347003)
package game;

import bag.SimpleBagInterface;
import student.TestableRandom;

/**
 * 
 * An array implementation of a bag.
 * 
 * @author aliparslan
 * @version 2021.02.28
 *
 * @param <T>
 *            The type of object to be used for an array-based bag
 */

public class SimpleArrayBag<T> implements SimpleBagInterface<T> {

    // Fields ...............................................
    private T[] bag;
    private static final int MAX = 18;
    private int numberOfEntries;

    // Constructor(s) .......................................

    /**
     * Creates a bag with a size of MAX (18 in this case)
     */
    public SimpleArrayBag() {
        @SuppressWarnings("unchecked")
        T[] tempbag = (T[])new Object[MAX];
        bag = tempbag;
    }

    // Methods ..............................................


    /**
     * Adds an item to the bag
     */
    @Override
    public boolean add(T item) {
        if (numberOfEntries == MAX || item == null) {
            return false;
        }
        else {
            bag[numberOfEntries] = item;
            numberOfEntries++;
            return true;
        }
    }


    /**
     * The number of items in the bag
     */
    @Override
    public int getCurrentSize() {
        return numberOfEntries;
    }


    /**
     * Whether or not the bag is empty
     */
    @Override
    public boolean isEmpty() {
        return numberOfEntries == 0;
    }


    /**
     * Displays a random item from the bag
     */
    @Override
    public T pick() {

        TestableRandom generator = new TestableRandom();

        if (this.isEmpty()) {
            return null;
        }

        else {
            int index = generator.nextInt(numberOfEntries);
            return bag[index];
        }
    }


    /**
     * Removes an item in the bag, if it can be found
     */
    @Override
    public boolean remove(T item) {
        if (this.getIndexOf(item) == -1) {
            return false;
        }
        else {
            int index = this.getIndexOf(item);
            bag[index] = bag[numberOfEntries - 1];
            bag[numberOfEntries - 1] = null;
            numberOfEntries--;
            return true;

        }
    }


    /**
     * Finds the location in which an item can be found
     * in the bag
     * 
     * @param item
     *            the item to be found
     * @return which index the item was found, -1 if not found
     */
    private int getIndexOf(T item) {
        for (int i = 0; i < numberOfEntries; i++) {
            if (bag[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

}
