public class Sheep extends Animal {
    public Sheep(String audioFilePath, String imageFilePath) {
        super("Sheep", audioFilePath, imageFilePath);
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
