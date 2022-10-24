package gui;

import model.GameStarter;

/**
 *  Class that sets up the game when it's starting.
 *
 * @author masutc@usi.ch fontani@usi.ch
 * @version 13/05/2002
 */
public abstract class StartSection extends GuiCommand
{
    private final GameStarter gameStarter;

    /**
     * StartSection'sconstructor.
     * @param frame game's window
     * @param gameStarter sets up the game
     */
    public StartSection(Frame frame, GameStarter gameStarter) {
        super(frame);
        this.gameStarter = gameStarter;
    }

    /**
     * getGameStarter getter method that return gameStarter.
     * @return GameStarter when called
     */
    public GameStarter getGameStarter() {
        return gameStarter;
    }
}
