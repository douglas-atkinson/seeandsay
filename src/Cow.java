import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Cow extends Animal {

    public Cow(String audioFilePath, String imageFilePath) {
        super("Cow", audioFilePath, null);

        // Load audio file
        try {
            sap.load(audioFilePath);
        }
        catch(Exception e) {
            e.printStackTrace();
            System.exit(1);
        }

        // Load image
        try {
            Image image = ImageIO.read(new File(imageFilePath));
            setImage(image);
        }
        catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    @Override
    public void makeSound() {
        sap.play();
    }

    @Override
    public String getString() {
        return getName();
    }
}
