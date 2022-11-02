public class Turkey extends Animal {

    public Turkey(String audioFilePath, String imageFilePath) {
        super("Turkey", audioFilePath, imageFilePath);
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
