package gui;

import model.Colors;
import model.MiddleGame;

import java.awt.event.ActionEvent;

/**
 * Class of the four buttons (top right) that select the color before a black card is thrown.
 *
 * @author masutc@usi.ch fontani@usi.ch
 * @version 13/05/2002
 */
public class ColorSetterButton extends GameSection
{    
    private Colors chosenColor;
    
    /**
     * ColorSetterButton constructor.
     * @param frame the actual window where the gui is displayed
     * @param game class of gui, the frame
     * @param middleGame the game is currently going
     * @param color of the card
     */
    public ColorSetterButton(Frame frame, Game game, MiddleGame middleGame, Colors color) {
        super(frame, game, middleGame);
        chosenColor = color;
    }
    
    /**
     * actionPerformed is cheching if the button was pressed and assign the color.
     * @param ev the event of the button been pressed
     */
    public void actionPerformed(final ActionEvent ev) {
        getGame().setChosenColor(chosenColor);
    }
}
