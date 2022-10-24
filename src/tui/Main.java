package tui;

import model.GameStarter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

/**
 * To run the game, instatiate the class and run run() method.
 *
 * @author masutc@usi.ch fontani@usi.ch
 * @version 13/05/2002
 */
public class Main {
    private boolean check;
    private boolean started;
    private final Scanner scanner;
    private String word;
    private GameStarter game;
    private Start start;

    /**
     * Constructor of Main.
     */
    public Main() {
        scanner = new Scanner(System.in);
        check = true;
        word = null;
        started = false;
    }


    /**
     * runs the tui.
     * @param args is an array of string
     */
    public static void main(String[] args) {
        new Main().run();
    }

    /**
     * Runs the game beginning.
     */
    public void run() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("Welcome to Uno-Momento!");
        while (check) {
            if (!started) {
                initialChoose();
                System.out.println(":");
                word = scanner.nextLine();
                System.out.print("\033[H\033[2J");
                System.out.flush();
                initialSelection(word.toUpperCase(Locale.US));
            } else {
                startedChoose();
                System.out.println(":");
                word = scanner.nextLine();
                startedSelection(word);
            }
        }
        System.out.println("Bye!");
        scanner.close();
    }

    /**
     * Prints the basic options you can choose.
     */
    private void initialChoose() {
        System.out.print("What would you like to do? ");
        System.out.print("Type 'r' to read the rules and the instructions,\n 's' to start or 't' to terminate ");
    }

    /**
     * Takes in input the basic chasen option.
     */
    private void initialSelection(String word) {
        if ("R".equals(word)) {
            try {
                FileReader file = new FileReader("tui/UnoRules.txt");
                BufferedReader breader = new BufferedReader(file);
                String string;
                string = breader.readLine();
                while (string != null) {
                    System.out.println(string);
                    string = breader.readLine();
                }
                System.out.println("\n\n\n");
            } catch (IOException exeption) {
                exeption.printStackTrace();
            }
        } else if ("S".equals(word)) {
            System.out.print("\033[H\033[2J");
            System.out.flush();
            game = new GameStarter();
            start = new Start(game);
            start.initGame();
            started = true;
        } else if ("T".equals(word)) {
            System.out.println("Thanks for playing");
            check = false;
        }
    }

    /**
     * Prints the optional choose to continue game.
     */
    private void startedChoose() {
        initialChoose();
        System.out.print("or 'c' to continue");
    }

    /**
     * Takes in input the optional chasen option.
     */
    private void startedSelection(String word) {
        initialSelection(word);
        if ("C".equals(word)) {
            start.continueGame();
        }
    }
}