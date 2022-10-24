package tui;

import model.GameStarter;
import model.Messages;

import java.util.Locale;
import java.util.Scanner;

/**
 * Setup the game.
 *
 * @author masutc@usi.ch fontani@usi.ch.
 * @version 13/05/2022
 */
public class Start
{
    private GameStarter gameStarter;
    private Scanner scanner;
    private String input;
    private Game game;
    private Messages result;

    /**
     * Constructor.
     * @param gameStarter import the starting dynamics
     */
    public Start(GameStarter gameStarter) {
        this.gameStarter = gameStarter;
        result = null;
        input = null;
    }

    /**
     * Starts a new game.
     */
    public void initGame() {
        scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US);
        initDeck();
        initArray();
        initPlayers();
        gameStarter.initialDraw();
        scanner.close();
        System.out.print("\033[H\033[2J");
        System.out.flush();
        game = new Game(gameStarter.startGame());
        game.play();
    }

    private void initDeck() {
        while (result != Messages.SUCCESS) {
            System.out.println("Select the deck you want: ");
            System.out.println("Press [1] for the default one ");
            System.out.println("Press [2] for the one with only special cards ");
            System.out.println("Press [3] for the one with custom cars");
            if (takeInput()) {
                result = gameStarter.selectDeck(Integer.parseInt(input));
            }
            MesasageToStringUtil.print(result);
        }
        result = null;
    }

    /**
     * Initialise players array.
     */
    private void initArray() {
        while (result != Messages.SUCCESS) {
            System.out.println("Select the number of player, from 2 to 4:");
            if (takeInput()) {
                result = gameStarter.newPlayers(Integer.parseInt(input));
            }
            MesasageToStringUtil.print(result);
        }
    }

    /**
     * takeInput takes the imput from the terminal.
     * 
     * @return true if the input is vaild
     */
    private boolean takeInput() {
        input = scanner.next();
        System.out.print("\033[H\033[2J");
        System.out.flush();
        if (InputCheckerUtil.intChecker(input)) {
            return true;
        }
        result = Messages.INVALIDARGUMENTS;
        return false;
    }

    /**
     * Initialise players in players array.
     */
    private void initPlayers() {
        for (int player = 0; player < Integer.parseInt(input); player++) {
            System.out.println("Enter the name for player number: " + (player + 1)); 
            String name = scanner.next();
            gameStarter.initPlayers(name, player);
        }
    }

    /**
     * Continues an already started game.
     */
    public void continueGame() {
        initDeck();
        gameStarter.initExistingPlayers();
        gameStarter.initialDraw();
        game.play();
    }
}
