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
public class NumPlayers
{
    /**
     * NumPlayers' constructor.
     * @param gameStarter set up the game
     */
    public NumPlayers(GameStarter gameStarter) {
        GameStarter gameStarterLocal = gameStarter;
        // Frame 
        Frame frame = new Frame(1100, 890);
        Rectangle frameSize = frame.getBounds();
        ImageIcon sfondo = new ImageIcon("images/NumPlayers/screen.png");         // background image
        JLabel screen = new JLabel(sfondo, JLabel.CENTER);
        int widthOfFrame = frameSize.width - 400;
        int heightOfFrame = frameSize.height + 150;
        int location = widthOfFrame / 3;
        for (int i = 1; i <= 3; i++) {
            JButton selectionButton = new JButton(new PlayerNumberButton(frame, gameStarterLocal, i + 1));
            ButtonsUtil.setup(selectionButton, new ImageIcon("images/NumPlayers/" + String.valueOf(i + 1) + ".png"), location * i,  heightOfFrame / 2 + 70);
            frame.add(selectionButton);
        }                      
        frame.add(screen);
    }
}