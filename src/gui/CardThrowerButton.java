package gui;

import model.Colors;
import model.MiddleGame;

import java.awt.event.ActionEvent;

/**
 * Every card is a button, CardThrowerButton menage certain card's dynamics.
 *
 * @author masutc@usi.ch fontani@usi.ch
 * @version 13/05/2002
 */
public class CardThrowerButton extends GameSection
{
    private final int cardIndex;

    /**
     * CardThrowerButton constructor.
     * @param frame the window of the game
     * @param game is the game
     * @param middleGame is the game that is going
     * @param cardIndex is the index (position) of the card in the hand
     */
    public CardThrowerButton(Frame frame, Game game, MiddleGame middleGame, int cardIndex) {
        super(frame, game, middleGame);
        this.cardIndex = cardIndex;
    }

    /**
     * actionPerformed check if the button is pressed.
     * @param ev is the event when card is clicked
     */
    public void actionPerformed(final ActionEvent ev) {
        Colors possibleColor = getGame().getChosenColor();
        if (possibleColor == null) {
            getMiddleGame().throwColoredCard(cardIndex);
        } else {
            getMiddleGame().throwBlackCard(cardIndex, possibleColor);
        }
        getGame().printHand();
        getGame().printLastCard();
    }
}
