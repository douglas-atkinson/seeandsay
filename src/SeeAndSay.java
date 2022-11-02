import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class SeeAndSay extends JFrame {

    private final int FRAME_WIDTH = 1120;
    private final int FRAME_HEIGHT = 770;
    private final int SPINNER_WIDTH = 600;
    private final int SPINNER_HEIGHT = 600;
    private GameSpinnerSelection spinner = null;
    private List<WedgeInfo> wedges = null;

    private GridBagConstraints gridBagConstraints;

    private JPanel spinPanel;

    public SeeAndSay() {
        wedges = new ArrayList<>();
        buildComponents();
    }

    private void buildComponents() {
        setTitle("See And Say - Knock Off");
        setLayout(new GridBagLayout());
        //setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.insets = new Insets(10, 10, 10, 10);

        try {
            buildSpinner();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            System.exit(1);
        }

        System.out.println(spinner.getRadius());

        setGridBagConstraints(gridBagConstraints, 0, 0);


        spinPanel = new JPanel();
        spinPanel.setPreferredSize(new Dimension((int)(SPINNER_WIDTH * 1.1), (int)(SPINNER_HEIGHT * 1.1)));
        spinPanel.setMaximumSize(new Dimension((int)(SPINNER_WIDTH * 1.1), (int)(SPINNER_HEIGHT * 1.1)));
        spinPanel.setMaximumSize(new Dimension((int)(SPINNER_WIDTH * 1.1), (int)(SPINNER_HEIGHT * 1.1)));
        spinPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        spinPanel.setLayout(null);
        spinPanel.add(spinner);

        add(spinPanel, gridBagConstraints);
        //add(spinPanel);


        setResizable(true);
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setVisible(true);

        spinGameSpinner();
    }

    private void buildSpinner() throws Exception {
        /*

        item = "Sheep " + new String(Character.toChars(0x1F411));
        wedges.add(item);

        item = "Rooster " + new String(Character.toChars(0x1F413));
        wedges.add(item);
        turkey
        */
        wedges.add(new Cow("sounds/cow.mp3", "images/cow.png" ));
        wedges.add(new Cat("sounds/cat.mp3", "images/cat.png"));
        wedges.add(new Dog("sounds/dog.mp3", "images/dog.png"));
        wedges.add(new Horse("sounds/horse.mp3", "images/horse.png"));
        wedges.add(new Pig("sounds/pig.mp3", "images/pig.png"));
        spinner = new GameSpinnerSelection(wedges);
        spinner.hasBorders(true);
        spinner.setBounds(10, 10, SPINNER_WIDTH, SPINNER_HEIGHT);
        spinner.setFont(new Font("TimesRoman", Font.PLAIN, 12));

    }

    private void setGridBagConstraints(GridBagConstraints gbc, int x, int y, int width, int height) {
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.gridwidth = width;
        gbc.gridheight = height;
    }

    private void setGridBagConstraints(GridBagConstraints gbc, int x, int y) {
        setGridBagConstraints(gbc, x, y, 1, 1);
    }

    private void spinGameSpinner() {
        while (true) {
            while (true) {
                try {
                    Thread.sleep(10);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (spinner.isSpinning()) {
                    break;
                }
            }

            while (spinner.isSpinning()) {
                try {
                    Thread.sleep(10);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        SeeAndSay sas = new SeeAndSay();
        Animal animal = new Cow("Moo.wav", "images/cow.jpg");
        //animal.makeSound();
    }
}
