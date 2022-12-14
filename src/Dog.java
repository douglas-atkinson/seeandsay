public class Dog extends Animal {
    public Dog(String audioFilePath, String imageFilePath) {
        super("Dog", audioFilePath, imageFilePath);
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
        return "woof";
    }

    @Override
    public void playAudio() {
        makeSound();
    }
}
