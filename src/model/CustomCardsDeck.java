package model;

/**
 * custom deck, mode of the game with selected cards.
 *
 * @author masutc@usi.ch fontani@usi.ch.
 * @version 13/05/2022
 * 
*/
public class CustomCardsDeck extends PlayingDeck
{ 
    /**
     * Constructor of CustomCardsDeck.
     */
    public CustomCardsDeck() {
        super();
        for (int j = 0; j < 2; j++) {
            for (Colors color : Colors.values()) {
                setNumberCards(color);
                setSpecialCards(color);
                deck.add(new ClearHand());
                deck.add(new SkipDraw(color));
                setBlackCards();
            }
        }
        shuffleDeck();
    }
}