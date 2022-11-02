public class Cat extends Animal{
    public Cat(String audioFilePath, String imageFilePath) {
        super("Cat", audioFilePath, imageFilePath);
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
