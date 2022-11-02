public class Cow extends Animal {

    public Cow(String audioFilePath, String imageFilePath) {
        super("Cow", audioFilePath, imageFilePath);
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
