package tui;

import model.Colors;
import model.Messages;
import model.MiddleGame;

import java.util.Locale;

/**
 * Write a description of class PlayCard here.
 *
 * @author masutc@usi.ch fontani@usi.ch.
 * @version 13/05/2022
 */
public class PlayCard extends Actions
{    
    /**
     * Constructor.
     */
    public PlayCard() {
        super("play a card");
    }

    /**
     * Prints requirements for playing a card.
     * @return the string with the requirements.
     */
    @Override
    public String requirements() {
        return "the index of selected card. \n\t\t\t If you throw a black card, select the color \n\t\t\t among 'b', 'y', 'r' and 'g'  \n\t\t\t Eventually 'uno' to make the uno call.\n";
    }

    /**
     * Makes player throw a card, and eventually calls uno.
     * @return result the result of operation.
     */
    @Override 
    public Messages execute(String[] input, MiddleGame middleGame) {
        Messages result = null;
        if (lenghtChecker(input, 2, 4)) {
            result = Messages.INCORRECTNUMBEROFARGUMENTS;
        } else if (!InputCheckerUtil.intChecker(input[1])) {
            result = Messages.INVALIDARGUMENTS;
        } else {
            result = checkThrow(middleGame, input); 
            checkUno(middleGame, input);
            result = middleGame.checkEnd(result);
            middleGame.checkHand();
        }
        return result;
    }
    
    /**
     * checkThrow check if player has thrown a card.
     * @param middleGame is the game
     * @param input is a String that player enters
     * @return Messages
     */
    public Messages checkThrow(MiddleGame middleGame, String[] input) {
        if (input.length == 2  || input[2].equals("uno")) {
            return middleGame.throwColoredCard(Integer.parseInt(input[1]) - 1);
        } else {
            Colors possibleColor = colorsConverter(input[2]);
            if (possibleColor != null) {
                return middleGame.throwBlackCard(Integer.parseInt(input[1]) - 1, possibleColor);
            }  
        }
        return null;
    }
    
    /**
     * checkUno check if player has called "UNO".
     * @param middleGame the game (model)
     * @param input a String that player enters
     */
    public void checkUno(MiddleGame middleGame, String[] input) {
        if (input.length == 3 && input[2].equals("uno") || input.length == 4 && input[3].equals("uno")) {
            middleGame.unoCall();
        }
    }

    /**
     * Checks length of input.
     * @param input array that is checked
     * @param min minimum length
     * @param max maximum length
     * @return boolean
     */ 
    private boolean lenghtChecker(String[] input, int min, int max) {
        return input.length < min || input.length > max;
    }

    /**
     * Converts Colors to String.
     * @param color the possible color to be converted
     * @return the correspondig color, or null
     */
    public Colors colorsConverter(String color) {
        color.toLowerCase(Locale.US);
        if ("r".equals(color)) {
            return Colors.RED;
        } else if ("b".equals(color)) {
            return Colors.BLUE;
        } else if ("y".equals(color)) {
            return Colors.YELLOW;
        } else if ("g".equals(color)) {
            return Colors.GREEN;
        }
        return null;
    }
}
