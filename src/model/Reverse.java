package model;


/**
 * Write a description of class Reverse here.
 *
 * @author masutc@usi.ch fontani@usi.ch.
 * @version 13/05/2002
 */
public class Reverse extends SpecialCards
{
    /**
     * The constructor.
     * @param color a color
     */
    public Reverse(Colors color) {
        super(color, Special.REVERSE);
    }
    
    @Override
    public void clearColor() {
        //no effect
    }
    
    /** 
     * Apply effect.
     */
    @Override
    public void effect(MiddleGame middleGame) {
        middleGame.reverseSense();
    }
    
    @Override
    public void setColor(Colors color) {
        //no effect
    }
}
