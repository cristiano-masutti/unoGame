package gui;

import model.MiddleGame;

import java.awt.event.ActionEvent;

/**
 * UnoCallButton is the button that player press to say "UNO" when he has one card.
 *
 * @author masutc@usi.ch fontani@usi.ch
 * @version 23/05/2002
 */
public class UnoCallButton extends GameSection
{    
    private final String name;

    /**
     * UnoCallButton'sconstructor.
     * @param frame is the game's window
     * @param game the game (gui)
     * @param middleGame the game (model)
     */
    public UnoCallButton(Frame frame, Game game, MiddleGame middleGame) {
        super(frame, game, middleGame);
        name = "UnoCallButton";
    }

    /**
     * actionPerformed is cheching if the button was pressed and calls UNO.
     * @param ev the event of the button been pressed
     */
    public void actionPerformed(final ActionEvent ev) {
        System.out.println(name);
        getMiddleGame().unoCall();
        getGame().printLastCard();
    }
}
