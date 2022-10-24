package gui;

import model.MiddleGame;

import java.awt.event.ActionEvent;

/**
 *  EndTurnButton is the button that ends the turn when a player has thrown a card.
 *
 * @author masutc@usi.ch fontani@usi.ch
 * @version 23/05/2002
 */
public class EndTurnButton extends GameSection
{    

    /**
     * EndTurnButton constructor.
     * @param frame the actual window of the GUI
     * @param callingGame is the game (model)
     * @param middleGame (model) the actual game 
     */
    public EndTurnButton(Frame frame, Game callingGame, MiddleGame middleGame) {
        super(frame, callingGame, middleGame);
    }

    /**
     * actionPerformed check if the button was pressed ends the turn.
     * @param ev the event of the button been pressed
     */
    public void actionPerformed(final ActionEvent ev) {
        getGame().hideHand();
        getMiddleGame().checkHand();
        System.out.println("");
        getGame().setTurn(getMiddleGame().getCurrentPlayer());
        getGame().setChosenColor(null);
        getGame().printHand();
    }
}
