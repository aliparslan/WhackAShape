// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I
// accept the actions of those who do.
// -- Alip Arslan (906347003)
package game;

import bag.SimpleBagInterface;
import student.TestableRandom;
import bag.Node;

/**
 * 
 * A linked-list implementation of a bag.
 * 
 * @author aliparslan
 * @version 2021.03.02
 *
 * @param <T>
 *            The type of object to be used for a linked bag
 */
public class SimpleLinkedBag<T> implements SimpleBagInterface<T> {

    // Fields ............................................
    private Node<T> firstNode;
    private int numberOfEntries;

    // Constructor(s) ....................................

    /**
     * Creates an empty linked bag with no entries
     */
    public SimpleLinkedBag() {
        firstNode = null;
        numberOfEntries = 0;
    }

    // Methods ...........................................


    /**
     * Adds an item to the bag, returns whether it was performed successfully
     */
    @Override
    public boolean add(T item) {
        if (item == null) {
            return false;
        }
        else {
            Node<T> entry = new Node<T>(item);
            entry.setNext(firstNode);
            firstNode = entry;
            numberOfEntries++;
            return true;
        }
    }


    /**
     * Returns the number of entries in the bag
     */
    @Override
    public int getCurrentSize() {
        return numberOfEntries;
    }


    /**
     * Returns whether the bag has no items
     */
    @Override
    public boolean isEmpty() {
        return numberOfEntries == 0;
    }


    /**
     * Returns a random item from the bag
     */
    @Override
    public T pick() {
        if (this.isEmpty()) {
            return null;
        }
        else {
            TestableRandom generator = new TestableRandom();
            int index = generator.nextInt(numberOfEntries);
            Node<T> tempNode = firstNode;
            for (int i = 0; i < index; i++) {
                tempNode = tempNode.getNext();
            }
            return tempNode.getData();
        }
    }


    /**
     * Removes an item from the bag, if it can be found in the bag
     */
    @Override
    public boolean remove(T item) {
        if (this.getReferenceTo(item) == null) {
            return false;
        }

        Node<T> localNode = this.getReferenceTo(item);
        localNode.setData(firstNode.getData());
        firstNode = firstNode.getNext();

        numberOfEntries--;
        return true;

    }


    /**
     * Finds the location in which an item can be found
     * in the bag
     * 
     * @param item
     *            the item to be found
     * @return which index the item was found, null if not found
     */
    private Node<T> getReferenceTo(T item) {
        boolean found = false;
        Node<T> currentNode = firstNode;

        while (!found && currentNode != null) {
            if (currentNode.getData().equals(item)) {
                found = true;
            }
            else {
                currentNode = currentNode.getNext();
            }
        }
        return currentNode; // null if not found
    }

}
