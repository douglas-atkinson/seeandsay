import java.awt.*;

public abstract class Animal implements WedgeInfo {

    protected SimpleAudioPlayer sap;
    protected String name;
    protected String audioFilePath;
    protected Image image;

    public Animal(String name, String audioFilePath, Image image) {
        sap = new SimpleAudioPlayer();
        this.name = name;
        this.audioFilePath = audioFilePath;
        this.image = image;
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
