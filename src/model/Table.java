package model;

/**
 * Table menage players methods.
 *
 * @author masutc@usi.ch fontani@usi.ch.
 * @version 13/05/2022
 */
public class Table
{
    protected Player[] players;

    /** getPlayers return tmp.
     *  @return tmp
     */
    public Player[] getPlayers() {
        Player[] tmp = players;
        return tmp;
    }

    /**
     * getPlayer return player.
     * @param index of player 
     * @return Player
     */
    public Player getPlayer(int index) {
        return players[index];
    }

    /**
     * getPlayersNumber return the index of the player from the array.
     * @return int player's number
     */
    public int getPlayersNumber() {
        return players.length;
    }

    /**
     * getPlayerName return player's name.
     * @param index of the player
     * @return String the player's name
     */
    public String getPlayerName(int index) {
        if (index >= 0 && index < players.length) {
            return players[index].getName();
        }
        return null;
    }
}
