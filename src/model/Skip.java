package model;

/**
 * Write a description of class Skip here.
 *
 * @author masutc@usi.ch fontani@usi.ch
 * @version 13/05/2002
 */
public class Skip extends SpecialCards
{
    /**
     * The constructor.
     * @param color a color
     */
    public Skip(Colors color) {
        super(color, Special.SKIP);
    }

    /** Apply effect.
     */
    @Override
    public void effect(MiddleGame game) {
        game.changePlayer();
    }

    @Override
    public void setColor(Colors color) {
        //no effect
    }

    @Override
    public void clearColor() {
        //no effect
    }
}
