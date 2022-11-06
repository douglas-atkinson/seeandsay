import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class SimpleMP3Player {

    private Player player;
    private FileInputStream fileInputStream;
    private BufferedInputStream bufferedInputStream;
    private String audioFilePath;

    public SimpleMP3Player() {}

    public SimpleMP3Player(String audioFilePath) {
        this.audioFilePath = audioFilePath;
        /*
        try {
            fileInputStream = new FileInputStream(new File(audioFilePath));
            bufferedInputStream = new BufferedInputStream(fileInputStream);
            //player = new Player(bufferedInputStream);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        */
    }

    public void load(String audioFilePath) {
        this.audioFilePath = audioFilePath;
        /*
        try {
            //fileInputStream = new FileInputStream(new File(audioFilePath));
            //bufferedInputStream = new BufferedInputStream(fileInputStream);
            //player = new Player(bufferedInputStream);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        */
    }

    public void play() {
        try {
            fileInputStream = new FileInputStream(new File(audioFilePath));
            bufferedInputStream = new BufferedInputStream(fileInputStream);
            player = new Player(bufferedInputStream);
            player.play();
            player.close();
        }
        catch (JavaLayerException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }



    public static void main(String[] args) {
        try {
            FileInputStream fileInputStream = new FileInputStream(new File("sounds/neigh.mp3"));
            BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
            Player player = new Player(bufferedInputStream);
            player.play();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        catch (JavaLayerException e) {
            e.printStackTrace();
        }

    }
}