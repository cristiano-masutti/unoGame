package gui;

import model.GameStarter;

import java.awt.event.ActionEvent;

/**
 * ModeSelectionButton are the buttons that will create the mode of the game.
 *
 * @author masutc@usi.ch fontani@usi.ch
 * @version 23/05/2002
 */
public class ModeSelectionButton extends StartSection
{
    private final int selectedDeck;
    private final String name;
    
    /**
     * ModeSelectionButton constructor.
     * @param frame the game's window
     * @param gameStarter set's up the game (model)
     * @param selectedDeck is the deck for the mode picked
     */
    public ModeSelectionButton(Frame frame, GameStarter gameStarter, int selectedDeck) {
        super(frame, gameStarter);
        this.selectedDeck = selectedDeck;
        name = "ModeSelection";
    }
    
    /**
     * actionPerformed gets triggered when the button is pressed.
     * @param ev is the event
     */
    public void actionPerformed(final ActionEvent ev) {
        getGameStarter().selectDeck(selectedDeck);
        System.out.print(name + "");
        new NumPlayers(getGameStarter());
        frameDispose();
    }
}
