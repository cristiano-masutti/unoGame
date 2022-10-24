package gui;

import model.Colors;
import model.MiddleGame;
import model.PlayableCards;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Write a description of class GUI here.
 *
 * @author masutc@usi.ch fontani@usi.ch
 * @version 13/05/2002
 */
public class Game {
    private final Frame frame;
    private final MiddleGame middleGame;
    private Colors chosenColor;
    private static JButton drawCardButton;
    private static JButton unoButton;
    private static JButton endTurnButton;
    private static JButton discardedButton;
    private final JPanel[] panelPlayers = new JPanel[4];
    private int turn;

    /**
     * Game constructor.
     * @param middleGame game dynamics (model)
     */
    public Game(MiddleGame middleGame) {
        // Frame 
        frame = new Frame(1200, 1000);
        this.middleGame = middleGame;
        // background image
        ImageIcon sfondo = new ImageIcon("images/screen.png");
        final JLabel screen = new JLabel(sfondo, JLabel.CENTER); 

        initPanels();
        createButtons();
        // adds the background image to the frame
        frame.add(screen);
    }

    /** 
     * print the last card of the discarded deck.
     */
    public void printLastCard() {
        discardedButton.setIcon(printCard(middleGame.getLastCard()));
    }

    /** 
     * print the hand of the player.
     */
    public void printHand() {
        panelPlayers[this.turn].removeAll(); 
        int cardIndex = 0;
        panelPlayers[turn].revalidate();  // used as repaint for the JPanel
        for (PlayableCards card : middleGame.getPlayer(turn).getHand()) {
            JButton cardButton = new JButton(new CardThrowerButton(frame,this, middleGame, cardIndex));
            ButtonsUtil.setup(cardButton, printCard(card), 0,0);
            panelPlayers[turn].add(cardButton);
            cardIndex++;
        }
    }

    /** printCard return the image of the discarded deck.
     *  @param card that is playable
     *  @return ImageIcon the image of the card
     */
    private ImageIcon printCard(PlayableCards card) {
        return new ImageIcon("images/cards/" + card.valueToString() + "" + card.colorToString() + ".png"); 
    }

    /**
     * setChosenCOlor set the color player chose after throwing a black card.
     * @param color the color (red, yellow, blue, green)
     */
    public void setChosenColor(Colors color) {
        this.chosenColor = color;
    }

    /**
     * return the chosen color.
     * @return Colors one of red, yellow, blue, green
     */
    public Colors getChosenColor() {
        return chosenColor;
    }

    /**
     * method created for hiding the other players hands.
     */
    public void hideHand() {
        panelPlayers[turn].removeAll(); 
        panelPlayers[turn].revalidate();  // used as repaint for the JPanel
        for (int i = 0; i < middleGame.getPlayer(turn).getHandSize(); i++) {
            JButton cardButton = new JButton();
            ButtonsUtil.setup(cardButton, new ImageIcon("images/cards/Back.png"), 0,0);
            panelPlayers[turn].add(cardButton);
        }
    }

    /**
     * sets the turn of the player.
     * @param turn number of the turn
     */
    public void setTurn(int turn) {
        this.turn = turn;
    }

    /**
     * creates the players.
     */
    public void initPanels() {
        for (int i = 0; i < 4; i++) {
            panelPlayers[i] = new JPanel();
            if (i < 2) {
                panelPlayers[i].setLayout(new GridLayout(1, 0, 0, 1));
                panelPlayers[i].setPreferredSize(new Dimension(150, 155));
            } else {
                panelPlayers[i].setLayout(new GridLayout(0, 1, 0, 1));
                panelPlayers[i].setPreferredSize(new Dimension(150, 155));
            }
        } 
        // sets color of the panel and position
        for (int i = 0; i < 4; i++) {
            switch (i) {
                case 0:
                    panelPlayers[i].setBackground(Color.red);
                    frame.add(panelPlayers[i], BorderLayout.SOUTH);
                    break;
                case 1:
                    panelPlayers[i].setBackground(Color.green);
                    frame.add(panelPlayers[i], BorderLayout.NORTH);
                    break;
                case 2:
                    panelPlayers[i].setBackground(Color.yellow);
                    frame.add(panelPlayers[i], BorderLayout.EAST);
                    break;
                default:
                    panelPlayers[i].setBackground(Color.blue);
                    frame.add(panelPlayers[i], BorderLayout.WEST);
                    break;
            }
        }  
    }

    /**
     * creates the all the buttons that are on the table.
     */
    public void createButtons() {
        int current = 200;
        int gap = 70;
        for (Colors color : Colors.values()) {
            JButton colorButton = new JButton(new ColorSetterButton(frame, this, middleGame, color));
            ButtonsUtil.setup(colorButton, new ImageIcon("images/Gui/set" + color + ".png"), 960, current);
            frame.add(colorButton);                      
            current += gap;
        }
        // Drawing deck button
        drawCardButton = new JButton(new DrawCardButton(frame, this, middleGame));
        ButtonsUtil.setup(drawCardButton, new ImageIcon("images/Gui/deck.png"), 330,400);
        frame.add(drawCardButton);                      
        // end turn button 
        endTurnButton = new JButton(new EndTurnButton(frame, this, middleGame));
        ButtonsUtil.setup(endTurnButton, new ImageIcon("images/Gui/endturn.png"), 320,550);
        frame.add(endTurnButton);                      
        // UNO button 
        unoButton = new JButton(new UnoCallButton(frame, this, middleGame));
        ButtonsUtil.setup(unoButton, new ImageIcon("images/Gui/uno.png") , 750, 400);
        frame.add(unoButton);                      
        // discarded
        discardedButton = new JButton();
        ButtonsUtil.setup(discardedButton, new ImageIcon("images/cards/1GREEN.png"), 555, 420);
        frame.add(discardedButton);                      
        turn = 0;
        printLastCard();
        printHand();
        for (int i = 1; i < middleGame.getPlayersNumber(); i++) {
            turn++;
            hideHand();
        }
        turn = 0;
    }
}