public class Rooster extends Animal {

    public Rooster(String audioFilePath, String imageFilePath) {
        super("Rooster", audioFilePath, imageFilePath);
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
        return "crow";
    }

    @Override
    public void playAudio() {
        makeSound();
    }
}
