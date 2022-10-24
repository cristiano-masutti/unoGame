package tui;

import model.Messages;

/**
 * Prints an error depending on the given error.
 *
 * @author masutc@usi.ch fontani@usi.ch.
 * @version 13/05/2022
 */
public final class MesasageToStringUtil {
    /**
     * The constructor.
     */
    private MesasageToStringUtil() {
    }
    
    /** 
     * Prints an error depending on the given error.
     * @param message input message
     */ 
    public static void print(Messages message) {
        if (Messages.INVALIDARGUMENTS == message) {
            System.out.println("Invalid arguments");
        } else if (Messages.INCORRECTNUMBEROFARGUMENTS == message) {
            System.out.println("Incorrect number of arguments");
        } else if (Messages.INVALIDCARD == message) {
            System.out.println("Invalid card");
        } else if (Messages.CANTHROW == message) {
            System.out.println("You have can throw a card");
        }
    }
}
