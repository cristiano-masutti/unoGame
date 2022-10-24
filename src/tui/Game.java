package tui;

import model.Messages;
import model.MiddleGame;
import model.PlayableCards;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

/**
 * Central game.
 *
 * @author masutc@usi.ch fontani@usi.ch.
 * @version 13/05/2022
 */
class Game {
    private MiddleGame middleGame;
    private End end;
    private Scanner scanner;
    private Messages result;
    private int game;
    private Actions[] actions;
    private String decision;
    
    /**
     * Constructor.
     */
    public Game(MiddleGame middleGame) {
        this.middleGame = middleGame;
        this.end = new End(middleGame.getEnd());
        game = 0;
        result = null;
        actions = new Actions[] {
            new PlayCard(),
            new DrawCard(),
        };
        decision = null;
    }
    
    
    /**
     * Main playing function.
     */
    public void play() {
        scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US);
        boolean check = true;
        game++;
        while (check) {
            choiceHelper();
            printChose();
            result = getInput();
            MesasageToStringUtil.print(result);
            check = result != Messages.TERMINATED;
            System.out.print("\033[H\033[2J");
            System.out.flush();
        }
        scanner.close();
        System.out.print("\033[H\033[2J");
        System.out.flush();
        end.rank();
    }
    
    /**
     * Takes in input the decision of the user.
     */
    private Messages getInput() {
        decision = scanner.nextLine();
        return analyzer();
    }
    
    
    /**
     * Prints the current hand and the already thrown card.
     */
    private void choiceHelper() {
        PlayableCards lastCard = middleGame.getLastCard();
        System.out.println();
        System.out.println("|\t\t\t Match number: " + game + "\t\t\t|");
        System.out.println("|\t\t\t                   \t\t\t|");
        System.out.println("|\t\t\t [" + lastCard.valueToString() + " " + lastCard.colorToString() + " ] \t\t\t\t|");
        System.out.println("|\t\t\t                   \t\t\t|");
        System.out.println("|\t\t\t                   \t\t\t|");
        System.out.println("Player: " + middleGame.getPlayerName(middleGame.getCurrentPlayer()) + "\t\t\t");
        handPrinter(middleGame.getPlayerHand());
        System.out.println();
    }
    
    private void handPrinter(ArrayList<PlayableCards> hand) {
        int index = 1;
        int len = 0;
        String printedHand = "";
        for (PlayableCards card: hand) {
            printedHand = printedHand + " [" + index + "] " + card.valueToString() + " ";
            if (card.getColor() != null) {
                printedHand = printedHand + card.colorToString() + " ";
            }
            index += 1;
            len++;
            if (len == 5) {
                printedHand = printedHand + "|\n";
                len = 0;
            }
        }
        System.out.println("| " + printedHand + " |");
    }
    
    /**
     * Prints options users can choose.
     */
    private void printChose() {
        for (int i = 0; i < actions.length; i++) {
            System.out.println("To " + actions[i].getName() + " press [" + i + "] followed by " + actions[i].requirements());
        }
    }
    
    /**
     * Analyze user input.
     */
    private Messages analyzer() {
        String[] splittedDecision = decision.trim().split("\\s+");
        if (InputCheckerUtil.intChecker(splittedDecision[0])
            && Integer.parseInt(splittedDecision[0])  < actions.length 
            && Integer.parseInt(splittedDecision[0])  > -1) {
            return actions[Integer.parseInt(splittedDecision[0])].execute(splittedDecision, middleGame);
        }
        return Messages.INVALIDARGUMENTS;
    }
}
