package gui;

import java.awt.Rectangle;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 * Start is the staring screen.
 *
 * @author masutc@usi.ch fontani@usi.ch
 * @version 13/05/2002
 */
public class Start
{
    /**
     * Start class'constructor.
     */
    public Start() {
        // Frame
        Frame frame = new Frame(1100, 890);

        Rectangle rectangle = frame.getBounds();
        int frameHeight = rectangle.height + 150;
        int frameWidth = rectangle.width - 200;
        int loc = frameWidth / 3;

        // background image

        JButton startButton = new JButton(new StartButton(frame));        // buttonStart
        ButtonsUtil.setup(startButton, new ImageIcon("images/Start/play.png"),loc ,frameHeight / 2);
        frame.add(startButton);
        JButton quitButton = new JButton(new QuitButton(frame));        // buttonQuit
        ButtonsUtil.setup(quitButton, new ImageIcon("images/Start/quit.png"),frameWidth - loc,frameHeight / 2);
        frame.add(quitButton);
        ImageIcon sfondo = new ImageIcon("images/frame.png");
        JLabel screen = new JLabel(sfondo, JLabel.CENTER);
        frame.add(screen); // (checkstyle error) to place image to screen must be added for last
    }
}
