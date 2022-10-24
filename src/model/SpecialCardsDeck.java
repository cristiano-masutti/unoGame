package model;


/**
 * Spacial mode deck.
 *
 * @author masutc@usi.ch fontani@usi.ch.
 * @version 13/05/2022
 */
public class SpecialCardsDeck extends PlayingDeck
{
    /**
     * SpecialCardsDeck constructor.
     */
    public SpecialCardsDeck() {
        super();
        for (int j = 0; j < 3; j++) {
            for (Colors color : Colors.values()) {
                setSpecialCards(color);
                setBlackCards();
            }
        }
    }
}
