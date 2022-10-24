package model;


/**
 * Write a description of class SkipDraw here.
 *
 * @author masutc@usi.ch fontani@usi.ch
 * @version 20/05/2002
 */
public class SkipDraw extends SpecialCards
{
    /**
     * SkipDraw's constructor.
     * @param color of the card
     */
    public SkipDraw(Colors color) {
        super(color, Special.SKIPDRAW);
    }
    
    @Override
    public States getState() {
        return States.SPECIAL;
    }
    
    @Override
    public void setColor(Colors color) {
        //no effect
    }
    
    /**
     * Effect of the card.
     */
    @Override
    public void effect(MiddleGame game) {
        //no Effect
    }
    
    @Override
    public void clearColor() {
        //no effect
    }
}
