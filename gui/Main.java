package gui;

import java.awt.EventQueue;

/**
 * The main function that will run the gui, creates Start class (initial screen).
 *
 * @author fontani@usi.ch masutc@usi.ch
 * @version 14/05/2002
 */

public class Main {

    /**
     * cotructor of Main.
     */
    public Main() {
        main();
    }

    /**
     * main method that creates the game.
     * @param args arrayList of String
     */
    public static void main(String[] args) {
        new Main();
    }

    /**
     * main method that runs the game and start the starting screen.
     */
    public void main() {      
        // Main function that runs the GUI
        EventQueue.invokeLater(new Runnable() {
                public void run() {
                    System.out.println("Creating the GUI...");
                    new Start(); 
                }
            });
    }
}
