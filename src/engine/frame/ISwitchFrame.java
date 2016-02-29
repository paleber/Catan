package engine.frame;

import java.awt.*;

/** Frame with switchable ContentPane. */
public interface ISwitchFrame {

    /** Set the size of the content.
     * @param width content-width
     * @param height content-height */
    void setContentSize(int width, int height);

    /** Show a content.
     * @param content content to show
     * @param title */
    void showContent(Container content, String title);

    /** Hide the content and show a load screen. */
    void hideContent();

    /** Shutdown the Frame. */
    void shutdown();

}
