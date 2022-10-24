package tui;

import model.Messages;
import model.MiddleGame;


/**
 * Used to manage table interactions.
 *
 * @author masutc@usi.ch fontani@usi.ch.
 * @version 13/05/2022
 */

public abstract class Actions
{
    private String name;
    
    /**
     * Contructor.
     * @param name name of action
     */
    public Actions(String name) {
        this.name = name;
    }
    
    /**
     * Get action name.
     * @return name the name of the action
     */
    public String getName() {
        return name;
    }
    
    /**
     * Will contain the requirements to use the defined action.
     * @return the string with all requirements
     */
    public abstract String requirements();
    
    /**
     * Executes the command.
     * @param input takes the String as input
     * @param middleGame that is the actual game
     * @return the message with the result of the action
     */
    public abstract Messages execute(String[] input, MiddleGame middleGame);
}
