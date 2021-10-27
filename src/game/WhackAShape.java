// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I
// accept the actions of those who do.
// -- Alip Arslan (906347003)
package game;

import student.TestableRandom;
import java.awt.Color;
import cs2.*;
import java.lang.IllegalArgumentException;
import bag.SimpleBagInterface;

/**
 * 
 * Creates a window for the shapes to be displayed
 * and interacted with.
 * 
 * @author aliparslan
 * @version 2021.03.02
 * 
 */
public class WhackAShape {

    // Fields ...................................

    private SimpleBagInterface<Shape> bag;
    private Window window;
    private TestableRandom randomGenerator;

    // Constructor(s) ...........................

    /**
     * Creates a window with a quit button and sets up
     * a selection of shapes to be drawn from and displayed.
     */
    public WhackAShape() {
        bag = new SimpleArrayBag<Shape>();
        window = new Window();

        Button quitButton = new Button("Quit");
        quitButton.onClick(this, "clickedQuit");
        window.addButton(quitButton, WindowSide.EAST);

        String[] shapes = { "red circle", "blue circle", "red square",
            "blue square" };

        randomGenerator = new TestableRandom();
        int bagSize = randomGenerator.nextInt(9) + 6;

        for (int i = 0; i < bagSize; i++) {
            bag.add(this.buildShape(shapes[randomGenerator.nextInt(
                shapes.length)]));
        }

        window.addShape(bag.pick());
    }


    /**
     * Takes an array of shapes to draw from and display on the window.
     * 
     * @param arg
     *            the array to be read for shapes
     */
    public WhackAShape(String[] inputs) {
        bag = new SimpleArrayBag<Shape>();
        window = new Window();

        Button quitButton = new Button("Quit");
        quitButton.onClick(this, "clickedQuit");
        window.addButton(quitButton, WindowSide.EAST);

        for (int i = 0; i < inputs.length; i++) {
            try {
                Shape temp = this.buildShape(inputs[i]);
                bag.add(temp);

            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }

        window.addShape(bag.pick());
    }

    // Methods ..................................


    /**
     * Returns the current bag
     * 
     * @return the bag field
     */
    public SimpleBagInterface<Shape> getBag() {
        return bag;
    }


    /**
     * Returns the current window
     * 
     * @return the window field
     */
    public Window getWindow() {
        return window;
    }


    /**
     * Quits the program if the button is clicked
     * 
     * @param button
     *            the button being clicked to quit the program
     */
    public void clickedQuit(Button button) {
        System.exit(0);
    }


    /**
     * Makes the shape disappear and replaces it with another
     * until the bag is empty
     * 
     * If the bag is empty, it displays a message
     * 
     * @param shape
     *            the shape being clicked
     */
    public void clickedShape(Shape shape) {

        window.removeShape(shape);
        bag.remove(shape);

        Shape nextShape = bag.pick();
        if (nextShape == null) {
            TextShape win = new TextShape(window.getGraphPanelWidth() / 2,
                window.getGraphPanelHeight() / 2, "You win!");
            window.addShape(win);
        }
        else {
            window.addShape(nextShape);
        }

    }


    /**
     * Creates a shape with a random coordinate and size
     * 
     * The shape can be red or blue, square or circle
     * 
     * @param input
     *            the type of shape to be created
     * @return the shape specified by the input
     */
    private Shape buildShape(String input) {
        randomGenerator = new TestableRandom();

        int size = randomGenerator.nextInt(101) + 100;

        int xIndex = randomGenerator.nextInt(window.getGraphPanelWidth());
        int yIndex = randomGenerator.nextInt(window.getGraphPanelHeight());

        if (xIndex + size > window.getGraphPanelWidth()) {
            xIndex -= size;
        }
        if (yIndex + size > window.getGraphPanelHeight()) {
            yIndex -= size;
        }
        int xCoord = window.getGraphPanelWidth() - xIndex - size;
        int yCoord = window.getGraphPanelHeight() - yIndex - size;

        Shape currentShape;

        if (input.contains("red") && input.contains("circle")) {
            currentShape = new CircleShape(xCoord, yCoord, size, Color.red);
        }
        else if (input.contains("red") && input.contains("square")) {
            currentShape = new SquareShape(xCoord, yCoord, size, Color.red);
        }
        else if (input.contains("blue") && input.contains("circle")) {
            currentShape = new CircleShape(xCoord, yCoord, size, Color.blue);
        }
        else if (input.contains("blue") && input.contains("square")) {
            currentShape = new SquareShape(xCoord, yCoord, size, Color.blue);
        }
        else {
            throw new IllegalArgumentException();
        }

        currentShape.onClick(this, "clickedShape");
        return currentShape;

    }

}
