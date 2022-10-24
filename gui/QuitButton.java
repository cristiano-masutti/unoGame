package gui;

import java.awt.event.ActionEvent;

/**
 *  QuitButton is the button used to quit and close the screen in the Star class/starting screen.
 *
 * @author masutc@usi.ch fontani@usi.ch
 * @version 13/05/2002
 */
public class QuitButton extends GuiCommand
{
    /**
     * constructor QuitButton.
     * @param frame game's window
     */
    public QuitButton(Frame frame) {
        super(frame);
    }

    /**
     * actionPerformed check if the button is pressed, if it does get pressed closes the window.
     * @param ev is the event when card is clicked
     */
    public void actionPerformed(final ActionEvent ev) {
        frameDispose();
    }
}
