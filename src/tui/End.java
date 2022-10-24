package tui;

import model.EndGame;
import model.Player;

import java.util.Locale;
import java.util.Scanner;


/**
 * Prints the final rank.
 *
 * @author masutc@usi.ch fontani@usi.ch.
 * @version 13/05/2022
 */
class End
{
    private EndGame end;
    
    /**
     * Contructor of End.
     */
    public End(EndGame end) {
        this.end = end;
    }
    
    /**
     * Prints the final rank of the match.
     */
    public void rank() {
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US);
        String decision = null;
        while (decision == null) {
            System.out.println("The final rank is : ");
            Player[] players = end.getFinalRank();
            int index = 1;
            for (Player player : players) {
                System.out.println(index++ + "° : " + player.getName() + ", points :" + player.getPoints());
            }
            decision = scanner.nextLine();
        }
    }
}

