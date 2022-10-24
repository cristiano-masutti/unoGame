package gui;

import model.MiddleGame;

import java.awt.event.ActionEvent;

/**
 * DrawCardButton sets functionalities of of the discarded-deck where players draw.
 *
 * @author masutc@usi.ch fontani@usi.ch
 * @version 13/05/2002
 */
public class DrawCardButton extends GameSection
{    
    private final String name;
    
    /**
     * DrawCardButton the constructor of the drawing deck.
     * @param frame the actual window where the gui is displayed
     * @param game class of gui, the frame
     * @param middleGame is the game is currently been played
     */
    public DrawCardButton(Frame frame, Game game, MiddleGame middleGame) {
        super(frame, game, middleGame);
        name = "DrawCardButton";
    }
    
    /**
     * actionPerformed triggered if button has been pressed, draw a card and adds it to player's hand.
     * @param ev event of the button been pressed
     */
    public void actionPerformed(final ActionEvent ev) {
        getMiddleGame().playerDraw();
        getGame().printHand();
        getGame().printLastCard();
        System.out.println(name);
    }
}
