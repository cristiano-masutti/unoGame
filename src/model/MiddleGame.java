package model;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * MiddleGame covers the dynamics of the game.
 *
 * @author masutc@usi.ch fontani@usi.ch.
 * @version 13/05/2022
 */
public class MiddleGame extends Playing
{
    private int turn;
    private int cardsStrike;
    private boolean sense;
    private boolean thrown;
    private States state;
    private EndGame end;

    /**
     * MiddleGame constructor.
     * @param playingDeck the drawing deck
     * @param discardedDeck the deck where players throw the cards
     */
    public MiddleGame(PlayingDeck playingDeck, Discarded discardedDeck) {
        super();
        this.playingDeck = playingDeck;
        this.discardedDeck = discardedDeck;
        turn = 0;
        cardsStrike = 0;
        sense = true;
        state = States.NORMAL;
        end = new EndGame();
    }

    /**
     * setPlayers.
     * @param players is the arrayList of players
     */
    public void setPlayers(Player[] players) {
        this.players = Arrays.copyOf(players, players.length);
        end.setPlayers(players);
        thrown = true;
    }

    /**
     * thrower operates on throwing dynamics, check the card below (discarded deck).
     * @param thrownCard the card that the player throw
     * @return Messages succeed
     */
    public Messages thrower(PlayableCards thrownCard) {
        getLastCard().clearColor();
        discardedDeck.addCard(thrownCard);
        checkContinuation();
        state = thrownCard.getState();
        return Messages.SUCCESS;
    }

    //PLAYERS ACTIONS
    /**
     * throwCard work with thrower and check if it's valid or invalid.
     * @param card number
     * @return Messages vaild/invalid
     */
    public Messages throwCard(int card) {
        if (thrown) {
            if (players[turn].canPlay(getLastCard(), card)) {
                thrown = false;
                return thrower(players[turn].toThrow(card));
            }
            return Messages.INVALIDCARD;
        }
        return Messages.ALREADYTHROWN;
    }

    /** throw the card.
     * @param card number
     * @return Messages if valid/invalid
     */
    public Messages throwColoredCard(int card) {
        if (card >= 0 && card < players[turn].getHandSize() && players[turn].getCard(card).getColor() != null) {
            return throwCard(card);
        }            
        return Messages.INVALIDCARD;
    }

    /**
     * throwBlackCard is the method that menage the throwing of the black cards.
     * @param card number of the card
     * @param chosenColor the color after the black card is thrown
     * @return Messages
     */
    public Messages throwBlackCard(int card, Colors chosenColor) {
        Messages result = throwCard(card);
        getLastCard().setColor(chosenColor);
        return result;
    }

    /** draw a card.
     * @return Messages
     */
    public Messages playerDraw() {
        if (thrown) {
            if (!players[turn].hasPlayable(getLastCard())) {
                drawCard(turn);
                return Messages.SUCCESS;
            }
            return Messages.CANTHROW;
        }
        return Messages.ALREADYTHROWN;
    }

    /** Call uno when player remains with one card.
     */
    public void unoCall() {
        players[turn].unoCall();
    }

    //TERMINATE TURN
    /** set the end of the turn.
     */
    public void endTurn() {
        if (state == States.NORMAL) {
            endNormal();
        } else {
            endSpecial(); 
        }
        changePlayer();
        thrown = true;
    }

    /**
     * goes to next player when turn is finished.
     */
    public void changePlayer() {
        turn = getNextPlayer();
    }

    /**
     * ends a normal turn.
     */
    public void endNormal() {
        getLastCard().effect(this);
        endStrike();
    }

    /**
     * ends a special turn (after +2, +4).
     */
    public void endSpecial() {
        if (players[getNextPlayer()].hasSpecialPlayable(getLastCard())) {
            cardsStrike += 1;
        } else {
            endNormal();
        }
    }

    /**
     * chekc the state of the turn.
     */
    public void checkContinuation() {
        if (state == States.SPECIAL && getLastCard().getState() == States.NORMAL) {
            turn = turn + players.length - 1;
            endStrike();
            changePlayer();
        }
    }

    /**
     * check how many cards a player must draw.
     */
    public void endStrike() {
        for (int i = 0; i < cardsStrike; i++) {
            discardedDeck.getCard(i + 1).effect(this);
        }
        cardsStrike = 0;
    }

    /**
     * check if a player needs to draw or end the turn.
     */
    public void checkHand() {
        if (!thrown) {
            if (players[turn].getHandSize() == 1 && !players[turn].isUnoCalled()) {
                for (int i = 0; i < 2; i++) {
                    drawCard(turn);
                }
            }
            endTurn();
        }
    }

    /**
     * sets the state in the turn.
     * @param state the state of the cards
     */
    public void setState(States state) {
        this.state = state;        
    }

    /** draw a card.
     * @param player ; number of the player in the arrayList
     */
    public void drawCard(int player) {
        if (playingDeck.getDeckSize() == 0) {
            playingDeck.takeDeck(discardedDeck.prepareShuffle(cardsStrike));
        }
        players[player].draw(playingDeck.getCard());
    }

    /** reverse the sense and ends the turn.
     */
    public void reverseSense() {
        sense = !sense;
    }

    /**
     * special card that clear the hand of the player and draw the same ammount of cards.
     */
    public void clearHand() {
        int size = players[turn].getHandSize();
        for (int i = size - 1; i >= 0; i--) {
            discardedDeck.addCard(players[turn].toThrow(i));
        }
        discardedDeck.swapLastCard(size);
        for (int i = 0; i < size; i++) {
            drawCard(turn);
        }
    }

    /** check if the game is ended by seeing if a player has 0 cards.
     * @param message when game is done
     * @return a boolean
     */
    public Messages checkEnd(Messages message) {
        if (players[turn].getHandSize() == 0) {
            return Messages.TERMINATED;
        }
        return message;
    }

    //Getters 
    /**
     * return the state of the sense.
     * @return true when the sense is player 1,2,3,4 false if the sense 4,3,2,1
     */
    public boolean isSenseNormal() {
        return sense;
    }

    /**
     * return number of the index of player that is playeing.
     * @return int of index current player
     */
    public int getCurrentPlayer() {
        return turn;
    }

    /**
     * getState returns the state.
     *@return States of the game
     */
    public States getState() {
        return state;
    }

    /** return the number of the next player.
     * @return int position of next player
     */
    public int getNextPlayer() {
        if (sense) {
            return (turn + 1) % players.length;
        } else {
            return (turn + players.length - 1) % players.length;
        }
    }

    /** return players' hands.
     * @return ArrayList PlayableCards player's cards
     */
    public ArrayList<PlayableCards> getPlayerHand() {
        return players[turn].getHand();
    }

    /**
     * game end dynamics.
     * @return EndGame
     */
    public EndGame getEnd() {
        return end;
    }
}