// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I
// accept the actions of those who do.
// -- Alip Arslan (906347003)
package project1;

import game.WhackAShape;

/**
 * This class runs the WhackAShape program.
 * Can take string parameters or if none are given,
 * will generate random shapes to be displayed.
 * 
 * @author aliparslan
 * @version 2021.03.01
 *
 */
public class ProjectRunner {

    /**
     * ProjectRunner constructor
     * Not necessary to fill in
     */
    public ProjectRunner() {
        // intentionally empty
    }


    /**
     * Runs the program with given strings, or with
     * random shapes if parameter is empty.
     * @param args
     *            The shapes desired to be displayed
     */
    public static void main(String[] args) {
        if (args.length > 0) {
            WhackAShape whack = new WhackAShape(args);
        }
        else {
            WhackAShape whack = new WhackAShape();
        }

    }

}
