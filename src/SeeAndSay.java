import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class SeeAndSay extends JFrame {

    private final int FRAME_WIDTH = 1120;
    private final int FRAME_HEIGHT = 770;
    private GameSpinnerSelection spinner = null;
    private List<String> wedges = null;

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
        spinPanel.setPreferredSize(new Dimension(450, 450));
        spinPanel.setMaximumSize(new Dimension(450, 450));
        spinPanel.setMaximumSize(new Dimension(450, 450));
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
        String item = "Dog " + "\uD83D\uDC36";
        System.out.println(item);
        wedges.add(item);
        item = "Cow " + new String(Character.toChars(0x1F42E));
        wedges.add(item);
        item = "Pig " + new String(Character.toChars(0x1F437));
        wedges.add(item);
        item = "Horse " + new String(Character.toChars(0x1F434));
        wedges.add(item);
        item = "Sheep " + new String(Character.toChars(0x1F411));
        wedges.add(item);
        item = "Cat " + new String(Character.toChars(0x1F63A));
        wedges.add(item);
        item = "Rooster " + new String(Character.toChars(0x1F413));
        wedges.add(item);
        item = "Goat " + new String(Character.toChars(0x1F410));
        wedges.add(item);

        spinner = new GameSpinnerSelection(wedges);
        spinner.hasBorders(true);
        spinner.setBounds(10, 10, 400, 400);
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
        //Animal animal = new Cow();
        //animal.makeSound();
    }
}
