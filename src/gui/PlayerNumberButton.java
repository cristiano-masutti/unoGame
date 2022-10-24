package gui;

import model.GameStarter;

import java.awt.event.ActionEvent;

/**
 * Class that menage the buttons for choosing the game's mode.
 *
 * @author masutc@usi.ch fontani@usi.ch
 * @version 23/05/2002
 */
public class PlayerNumberButton extends StartSection
{
    private final int playersNumber;

    /**
     * PlayerNumberButton's constructor.
     * @param frame is the window's game
     * @param gameStarter setsup the game in the beginning
     * @param playersNumber the nu,ber of the player
     */
    public PlayerNumberButton(Frame frame, GameStarter gameStarter, int playersNumber) {
        super(frame, gameStarter);
        this.playersNumber = playersNumber;
    }

    /**
     * actionPerformed is cheching if the button was pressed and assign the color.
     * @param ev the event of the button been pressed
     */
    public void actionPerformed(final ActionEvent ev) {
        getGameStarter().newPlayers(playersNumber);
        new NamePlayers(getGameStarter());
        frameDispose();
    }
}
