import java.awt.*;

public interface WedgeInfo {
    String getString();
    Image getImage();
    default void playAudio() { return; }
    default String getActionString() { return ""; }
}
