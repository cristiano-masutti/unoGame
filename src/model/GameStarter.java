package model;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Setup the start-game.
 *
 * @author masutc@usi.ch fontani@usi.ch.
 * @version 13/05/2022
 */
public class GameStarter extends Playing
{
    private MiddleGame game;

    // DECK SECTION
    /**
     * selectDeck selects the deck specified for the mode's game.
     * @param deck is the deck's mode
     * @return Messages
     */
    public Messages selectDeck(int deck) {
        switch (deck) {
            case 1:
                this.playingDeck = new NormalCardsDeck();
                break;
            case 2:
                this.playingDeck = new SpecialCardsDeck();
                break;
            case 3:
                this.playingDeck = new CustomCardsDeck();
                break;
            default:
                return Messages.INVALIDARGUMENTS;  
        }
        playingDeck.shuffleDeck();
        discardedCreation();
        game = new MiddleGame(this.playingDeck, this.discardedDeck);
        return Messages.SUCCESS;
    }

    private void discardedCreation() {
        discardedDeck = new Discarded();
        PlayableCards firstCard = playingDeck.getCard();
        while (!firstCard.canBeFirst()) {
            playingDeck.addCard(firstCard);
            firstCard = playingDeck.getCard();
        }
        discardedDeck.addCard(firstCard);
    }

    //PLAYERS SECTION
    //NEW PLAYERS
    /** set the name of the player check if number of playersNumber is between 2 and 4.
     * @param playersNumber number of the player
     * @return Messages 
     */
    public Messages newPlayers(int playersNumber) {
        players = new Player[playersNumber];
        if (playersNumber > 1 && playersNumber < 5) {
            return Messages.SUCCESS;
        }
        return Messages.INVALIDARGUMENTS;
    }

    /** initialize Players.
     * @param name of the player
     * @param index of the player in the array of players
     */
    public void initPlayers(String name, int index) {
        players[index] = new Player(name);
    }

    //EXISTING PLAYERS
    /** prepares the array of the player for next game.
     */
    public void initExistingPlayers() {
        List<Player> tmpPlayers = Arrays.asList(players);
        Collections.shuffle(tmpPlayers);
        tmpPlayers.toArray(players);
        for (Player player : players) {
            player.resetHand();
        }
    }

    //INITIAL DRAW
    /** set the initial draw.
     */
    public void initialDraw() {
        for (Player player : players) {
            while (player.getHandSize() < 2) {
                player.draw(playingDeck.getCard());
            }
        }
        game.setPlayers(players);
    }

    //START GAME
    /**
     *  starts the game.
     *  @return MiddleGame for GUI
     */
    public MiddleGame startGame() {
        return game;
    }
}