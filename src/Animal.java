import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public abstract class Animal implements WedgeInfo {

    protected SimpleMP3Player smp3p;
    protected String name;
    protected String audioFilePath;
    protected Image image;

    public Animal(String name, String audioFilePath, String imageFilePath) {
        smp3p = new SimpleMP3Player();
        this.name = name;
        this.audioFilePath = audioFilePath;
        this.image = null;

        // Load audio file
        try {
            smp3p.load(audioFilePath);
        }
        catch(Exception e) {
            e.printStackTrace();
            System.exit(1);
        }

        // Load image
        try {
            image = ImageIO.read(new File(imageFilePath));
            setImage(image);
        }
        catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public abstract void makeSound();

    public String getName() {
        return name;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    @Override
    public Image getImage() {
        return image;
    }

}
