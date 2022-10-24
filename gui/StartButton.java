package gui;

import model.GameStarter;

import java.awt.event.ActionEvent;


/**
 * StartButton is the button used to start the game on the first frame-window.
 *
 * @author masutc@usi.ch fontani@usi.ch
 * @version 23/05/2002
 */
public class StartButton extends GuiCommand
{
    /**
     * StartButton's constructor.
     * @param frame the game's window
     */
    public StartButton(Frame frame) {
        super(frame);
    }
    
    /**
     * actionPerformed triggered if button has been pressed, if true creates new game.
     * @param ev event of the button been pressed
     */
    public void actionPerformed(final ActionEvent ev) {
        new Mode(new GameStarter());
        frameDispose();
    }
}