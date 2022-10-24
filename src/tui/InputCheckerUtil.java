package tui;

/**
 * Checks if the input is int.
 *
 * @author @author masutc@usi.ch fontani@usi.ch.
 * @version 13/05/2002
 */
public class InputCheckerUtil
{
    /**
     * The constructor.
     */
    private InputCheckerUtil() {
    }
    
    /** 
    * Check if the imput from the terminal is a number written as a type String.
    * @param number a number written as a type String
    * @return true if number is int
    */ 
    public static boolean intChecker(String number) {
        try {
            Integer.parseInt(number);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }
}