package gui;

import javax.swing.AbstractAction;

/**
 * Abstract class of commands.
 *
 * @author masutc@usi.ch fontani@usi.ch
 * @version 13/05/2002
 */
public abstract class GuiCommand extends AbstractAction
{
    private final Frame frame;
    
    /**
     * GuiCommand's constructor.
     * @param frame the game's window
     */
    public GuiCommand(Frame frame) {
        super();
        this.frame = frame;
    }
    
    /**
     * getFrame reutns the frame.
     * @return Frame
     */
    public Frame getFrame() {
        return frame;
    }
    
    /**
     * frameDispose closes the window.
     */
    public void frameDispose() {
        frame.dispose();
    }
}
