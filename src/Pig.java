public class Pig extends Animal {
    public Pig(String audioFilePath, String imageFilePath) {
        super("Pig", audioFilePath, imageFilePath);
    }

    @Override
    public void makeSound() {
        smp3p.play();
    }

    @Override
    public String getString() {
        return getName();
    }
}
