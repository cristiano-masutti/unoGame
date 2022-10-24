package model;


/**
 *  Wild card will change the color of the discarded deck.
 *
 * @author masutc@usi.ch fontani@usi.ch
 * @version 13/05/2002
 */
public class Wild extends BlackCard
{
    /**
     * constructor of wilf card.
     */
    public Wild() {
        super(Special.WILD);
    }
    
    /**
     * Effect of the card.
     */
    @Override
    public void effect(MiddleGame game) {
        //no effect
    }
}
