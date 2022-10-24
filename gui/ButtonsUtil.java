package gui;

import javax.swing.ImageIcon;
import javax.swing.JButton;

/** UtilButtons styles GUI's buttons.
 * 
 * @author masutc@usi.ch fontani@usi.ch
 * @version 29/05/2002
 */
public class ButtonsUtil
{
    /**
     * constructor of UtilButtons.
     */
    private ButtonsUtil() {
    }

    /**
     * takes a JButton and cleans gray boarders, resize it as big as the image.
     * @param button JButton
     * @param image of the button
     * @param xposition the X-position
     * @param yposition the Y-position
     */
    public static void setup(JButton button, ImageIcon image, int xposition, int yposition) {   //checkstyle gives error but rh
        button.setIcon(image);
        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
        button.setFocusable(false);
        button.setSize(image.getIconWidth(), image.getIconHeight());
        button.setLocation(xposition, yposition);
    }
}
