package gui;

import model.GameStarter;

import java.awt.Rectangle;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 * NumPlayers is the screen where the number of players is decided.
 *
 * @author masutc@usi.ch fontani@usi.ch
 * @version 13/05/2002
 */
public class Mode
{
    /** 
     * Constructor of class Mode; this class will create the mode of the game.
     * @param gameStarter set-up the game
     */
    public Mode(GameStarter gameStarter) {
        GameStarter gameStarterLocal = gameStarter;
        Frame frame = new Frame(1100, 890);
        Rectangle rectangle = frame.getBounds();
        int frameHeight = rectangle.height + 50;
        int frameWidth = rectangle.width - 400;
        int loc = frameWidth / 3;
        ImageIcon sfondo = new ImageIcon("images/frame.png");           // backgorung image
        JLabel screen = new JLabel(sfondo, JLabel.CENTER);
        for (int i = 1; i <= 3; i++) {
            JButton selectionButton = new JButton(new ModeSelectionButton(frame, gameStarterLocal, i));
            ButtonsUtil.setup(selectionButton, new ImageIcon("images/Mode/" + String.valueOf(i) + ".png"), loc * i, frameHeight / 2);
            frame.add(selectionButton);
        }
        frame.add(screen);
    }

}