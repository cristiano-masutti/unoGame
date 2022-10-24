package gui;

import java.awt.BorderLayout;
import javax.swing.JFrame;

/**
 * The frame is the window where the UI is going to be displayed.
 *
 * @author fontani@usi.ch masutc@usi.ch
 * @version 17/05/2002
 */
public class Frame extends JFrame   
{
    /**
     * frame's constructor, frame is the actual window of the game.
     * @param width the width of the window's frame
     * @param height the height of the window's frame
     */
    public Frame(int width, int height) {
        super();
        this.setTitle("Project Uno-Momento");                        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);     // exit when frame get closed
        this.setResizable(false);                                 
        this.setSize(width,height);
        this.setLocationRelativeTo(null);                        // window appears in the middle of the screen 
        this.setVisible(true);  
        this.setLayout(new BorderLayout());  
    }
}
