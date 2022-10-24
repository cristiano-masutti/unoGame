package gui;

import model.MiddleGame;

/**
 * Abstract class GameSection.
 *
 * @author masutc@usi.ch fontani@usi.ch
 * @version 13/05/2002
 */
public abstract class GameSection extends GuiCommand
{
    private final MiddleGame middleGame;
    private final Game game;
    
    /**
     * GameSection constructor.
     * @param frame the window of the game
     * @param game the class dedicated for the game (GUI)
     * @param middleGame the class dedicated for the game (model)
     */
    public GameSection(Frame frame, Game game, MiddleGame middleGame) {
        super(frame);
        this.middleGame = middleGame;
        this.game = game;
    }
    
    /**
     * return middlegame (from model).
     * @return MiddleGame 
     */
    public MiddleGame getMiddleGame() {
        return middleGame;
    }
    
    /**
     * return the Game (GUI).
     * @return Game
     */
    public Game getGame() {
        return game;
    }
}