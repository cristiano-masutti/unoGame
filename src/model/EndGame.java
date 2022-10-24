package model;

import java.util.Arrays;

/**
 * Write a description of class End here.
 *
 * @author masutc@usi.ch fontani@usi.ch.
 * @version 13/05/2022
 */
public class EndGame extends Table
{
    /**
     * setPlayers sets the list of the rank.
     * @param players array of players
     */
    public void setPlayers(Player[] players) {
        this.players = Arrays.copyOf(players, players.length);
    }
    
    /** 
     * return the final rank of the players.
     * @return Player[]
    */    
    public Player[] getFinalRank() {
        countPoints();
        Player[] ranking = getPlayers();
        for (int i = 1; i < ranking.length; i++) {
            int jndex = i;
            while (ranking[jndex].getPoints() < ranking[jndex - 1].getPoints()) {
                Player tmp = ranking[jndex];
                ranking[jndex] = ranking[jndex - 1];
                ranking[jndex - 1] = tmp;
            }
        }
        return ranking;
    }
    
    /** count the points.
    */    
    public void countPoints() { 
        for (Player player : getPlayers()) {
            player.countPoints();
        }
    }
}
