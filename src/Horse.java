public class Horse extends Animal {
    public Horse(String audioFilePath, String imageFilePath) {
        super("Horse", audioFilePath, imageFilePath);
    }

    @Override
    public void makeSound() {
        smp3p.play();
    }

    @Override
    public String getString() {
        return getName();
    }

    @Override
    public String getActionString() {
        return "neigh";
    }

    @Override
    public void playAudio() {
        makeSound();
    }
}
