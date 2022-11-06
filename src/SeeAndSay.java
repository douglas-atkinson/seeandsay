import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class SeeAndSay extends JFrame implements ActionListener {

    private final int FRAME_WIDTH = 1120;
    private final int FRAME_HEIGHT = 980;
    private final int SPINNER_WIDTH = 600;
    private final int SPINNER_HEIGHT = 600;
    private GameSpinnerSelection spinner = null;
    private List<WedgeInfo> wedges = null;

    private GridBagConstraints gridBagConstraints;

    private JPanel spinPanel;
    private JPanel spinnerUpdatePanel;
    private JPanel spinnerFinalPanel;

    private JButton playAgain;

    private JLabel spinnerUpdateMessage;
    private JLabel spinnerUpdateImage;
    private JLabel spinnerFinalMessage;
    private JLabel spinnerFinalImage;

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

        // spinner in this panel
        spinPanel = new JPanel();
        spinPanel.setPreferredSize(new Dimension((int)(SPINNER_WIDTH * 1.1), (int)(SPINNER_HEIGHT * 1.1)));
        spinPanel.setMaximumSize(new Dimension((int)(SPINNER_WIDTH * 1.1), (int)(SPINNER_HEIGHT * 1.1)));
        spinPanel.setMaximumSize(new Dimension((int)(SPINNER_WIDTH * 1.1), (int)(SPINNER_HEIGHT * 1.1)));
        spinPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        spinPanel.setLayout(null);
        spinPanel.add(spinner);

        setGridBagConstraints(gridBagConstraints, 0, 0, 1, 2);
        add(spinPanel, gridBagConstraints);

        // panel for spinner update
        spinnerUpdatePanel = new JPanel();
        spinnerUpdateMessage = new JLabel("");
        spinnerUpdateImage = new JLabel("");
        System.out.println("Frame Width: " + FRAME_WIDTH);
        System.out.println("Spinner Width: " + SPINNER_WIDTH);
        System.out.println("Spin Panel Width: " + (int)(SPINNER_WIDTH * 1.4));
        System.out.println("Spin Update Width: " + (int)(FRAME_WIDTH - SPINNER_WIDTH * 1.4));
        spinnerUpdatePanel.setPreferredSize(new Dimension((int)(FRAME_WIDTH - SPINNER_WIDTH * 1.4), (int)(FRAME_HEIGHT / 20.0)));
        spinnerUpdatePanel.setMaximumSize(new Dimension((int)(FRAME_WIDTH - SPINNER_WIDTH * 1.4), (int)(FRAME_HEIGHT / 20.0)));
        spinnerUpdatePanel.setMinimumSize(new Dimension((int)(FRAME_WIDTH - SPINNER_WIDTH * 1.4), (int)(FRAME_HEIGHT / 20.0)));
        spinnerUpdatePanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        spinnerUpdatePanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        spinnerUpdateMessage.setFont(new Font("TimesRoman", Font.BOLD, 36));
        spinnerUpdatePanel.add(spinnerUpdateMessage);
        spinnerUpdatePanel.add(spinnerUpdateImage);

        setGridBagConstraints(gridBagConstraints, 1, 0);
        add(spinnerUpdatePanel, gridBagConstraints);

        playAgain = new JButton("Play Sound Again");
        playAgain.addActionListener(this);
        setGridBagConstraints(gridBagConstraints, 1, 1);
        add(playAgain, gridBagConstraints);

        // panel to display final spinner wedge
        spinnerFinalPanel = new JPanel();
        spinnerFinalMessage = new JLabel("");
        spinnerFinalImage = new JLabel("");
        spinnerFinalPanel.setPreferredSize(new Dimension((int)(FRAME_WIDTH * 0.9), (int)(FRAME_HEIGHT / 8.0)));
        spinnerFinalPanel.setMaximumSize(new Dimension((int)(FRAME_WIDTH * 0.9), (int)(FRAME_HEIGHT / 8.0)));
        spinnerFinalPanel.setMinimumSize(new Dimension((int)(FRAME_WIDTH * 0.9), (int)(FRAME_HEIGHT / 8.0)));
        spinnerFinalPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        spinnerFinalPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        spinnerFinalMessage.setFont(new Font("TimesRoman", Font.BOLD, 72));
        spinnerFinalPanel.add(spinnerFinalMessage);
        spinnerFinalPanel.add(spinnerFinalImage);

        setGridBagConstraints(gridBagConstraints, 0, 2, 2, 1);
        add(spinnerFinalPanel, gridBagConstraints);

        setResizable(true);
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setVisible(true);

        spinGameSpinner();
    }

    private void buildSpinner() throws Exception {

        wedges.add(new Cow("sounds/the_cow_says.mp3", "images/cow.png" ));
        wedges.add(new Cat("sounds/the_cat_says.mp3", "images/cat.png"));
        wedges.add(new Dog("sounds/the_dog_says.mp3", "images/dog.png"));
        wedges.add(new Horse("sounds/the_horse_says.mp3", "images/horse.png"));
        wedges.add(new Pig("sounds/the_pig_says.mp3", "images/pig.png"));
        wedges.add(new Sheep("sounds/the_sheep_says.mp3", "images/sheep.png"));
        wedges.add(new Rooster("sounds/the_rooster_says.mp3", "images/rooster.png"));
        wedges.add(new Turkey("sounds/the_turkey_says.mp3", "images/turkey.png"));
        spinner = new GameSpinnerSelection(wedges);
        spinner.hasBorders(true);
        spinner.setBounds(10, 10, SPINNER_WIDTH, SPINNER_HEIGHT);
        spinner.setFont(new Font("TimesRoman", Font.PLAIN, 12));
        spinner.setSpinDeceleration(-125);

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

    private Image resizeImageMaintainAspectRatio(Image image, int largestDimension) {
        int imageWidth = image.getWidth(null);
        int imageHeight = image.getHeight(null);
        double ratio = 0.0;
        if (imageWidth > imageHeight) {
            ratio = (double)imageHeight / imageWidth;
            imageWidth = largestDimension;
            imageHeight = (int)(largestDimension * ratio);
        }
        else {
            ratio = (double)imageWidth / imageHeight;
            imageHeight = largestDimension;
            imageWidth = (int)(largestDimension * ratio);
        }
        return resizeImage((BufferedImage)image, imageWidth, imageHeight, BufferedImage.SCALE_SMOOTH);
    }

    private Image resizeImage(BufferedImage bi, int width, int height, int scalingAlgorithm) {
        Image image = null;

        if (bi != null) {
            image = bi.getScaledInstance(width, height, scalingAlgorithm);
        }

        return image;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        spinner.getSelectedWedge().playAudio();
    }

    private void spinGameSpinner() {
        while (true) {
            // wait for action
            while (true) {
                spinnerUpdateMessage.setText(spinner.getSelectedWedge().getString());
                spinnerUpdateImage.setIcon(
                        new ImageIcon(
                                resizeImageMaintainAspectRatio(spinner.getSelectedWedge().getImage(), spinnerUpdatePanel.getHeight())
                        )
                );
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
            // while spinning
            while (spinner.isSpinning()) {
                spinnerUpdateMessage.setText(spinner.getSelectedWedge().getString());
                spinnerUpdateImage.setIcon(
                        new ImageIcon(
                                resizeImageMaintainAspectRatio(spinner.getSelectedWedge().getImage(), spinnerUpdatePanel.getHeight())
                        )
                );
                try {
                    Thread.sleep(10);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            spinnerFinalMessage.setText("The " + spinner.getSelectedWedge().getString() + " says " + spinner.getSelectedWedge().getActionString());
            spinnerFinalImage.setIcon(
                    new ImageIcon(
                        resizeImageMaintainAspectRatio(spinner.getSelectedWedge().getImage(), spinnerFinalPanel.getHeight())
                    )
            );
            spinner.getSelectedWedge().playAudio();
        }
    }

    public static void main(String[] args) {
        SeeAndSay sas = new SeeAndSay();
        //Animal animal = new Cow("Moo.wav", "images/cow.jpg");
        //animal.makeSound();
    }


}
