package gui;

import model.GameStarter;

import java.util.Arrays;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * NamePlayers is the screen where the name of players is decided.
 *
 * @author masutc@usi.ch fontani@usi.ch
 * @version 13/05/2002
 */
public class NamePlayers
{
    private final JTextField[] names;

    /**
     * NamePlayers's constructor.
     * @param gameStarter sets up the beginning of the game
     */
    public NamePlayers(GameStarter gameStarter) {
        int players = gameStarter.getPlayersNumber();
        // Frame  (1100, 890);
        Frame frame = new Frame(1100, 890);

        JLabel userLabel = new JLabel("Enter name of players");
        userLabel.setBounds(355, 455, 150, 35);
        frame.add(userLabel);

        // creates as many textfields as the previous
        // button of number of players was pressed
        int pixel = 55;
        int current = 490;
        this.names = new JTextField[players];
        for (int i = 0; i < players; i++) {
            names[i] = new JTextField(20);
            names[i].setBounds(350, current, 365, 40);
            frame.add(names[i]);
            current += pixel;
            System.out.println("Enter the name of player " + (i + 1));
        }
        JButton startButton = new JButton(new PlayerNameButton(frame, gameStarter, names));        // buttonStart  
        ButtonsUtil.setup(startButton, new ImageIcon("images/Start/play.png"),435, 700);
        frame.add(startButton);    
        
        // background image
        ImageIcon sfondo = new ImageIcon("images/frame.png");
        JLabel screen = new JLabel(sfondo, JLabel.CENTER);
        frame.add(screen);
    }

    /**
     * returns the namesof the players inserted.
     * @return JTextField[] array of name's players JTextFields
     */
    public JTextField[] getNames() {
        return Arrays.copyOf(names, names.length);
    }

}
