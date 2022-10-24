package model;

/**
 * Default deck.
 *
 * @author masutc@usi.ch fontani@usi.ch.
 * @version 13/05/2022
 */
public class NormalCardsDeck extends PlayingDeck
{
    /**
     * NormalCardsDeck's constructor.
     */
    public NormalCardsDeck() {
        super();
        for (int j = 0; j < 2; j++) {
            for (Colors color : Colors.values()) {
                setNumberCards(color);
                setSpecialCards(color);
            }
        } 
        setBlackCards();
    }
}
