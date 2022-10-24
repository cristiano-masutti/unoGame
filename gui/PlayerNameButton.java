package gui;

import model.GameStarter;

import java.awt.event.ActionEvent;
import java.util.Arrays;
import javax.swing.JTextField;

/**
 * The three buttons that ccreates 2, 3 or 4 players in the NumPlayers screen.
 *
 * @author masutc@usi.ch fontani@usi.ch
 * @version 29/05/2002
 */
public class PlayerNameButton extends StartSection
{
    private final JTextField[] names;

    /**
     * PlayerNameButton's constructor.
     * @param frame game's window
     * @param gameStarter sets the start of the game
     * @param names of players
     */
    public PlayerNameButton(Frame frame, GameStarter gameStarter, JTextField[] names) {
        super(frame, gameStarter);
        this.names = Arrays.copyOf(names, names.length);
    }

    /**
     * actionPerformed check if the button is pressed.
     * @param ev is the event when card is clicked
     */
    public void actionPerformed(final ActionEvent ev) {
        if (checkEmpty()) {
            for (int i = 0; i < getGameStarter().getPlayersNumber(); i++) {
                getGameStarter().initPlayers(names[i].getText(), i);
            }
            getGameStarter().initialDraw();
            frameDispose();
            new Game(getGameStarter().startGame());
        }
    }

    /** Will prevent an empty name passed in the textfields.
     *  @return boolean true if it's a valid name
     */
    public boolean checkEmpty() {
        for (JTextField field : names) {
            if ("".equals(field.getText())) {
                return false;
            }
        }
        return true;
    }
}