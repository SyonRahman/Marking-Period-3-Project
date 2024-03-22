import java.awt.event.MouseListener;
import java.lang.reflect.Array;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.sound.sampled.*;
import java.io.IOException;
import java.util.TimerTask;


public class ButtonFunctionality extends JFrame implements ActionListener {


    private ArrayList<RoundButton> buttonspressed = new ArrayList<RoundButton>();
    private final String gametype;
    private Clip musics;
    private ArrayList<RoundButton> random_clickers = new ArrayList<RoundButton>();
    private RoundButton redButton = new RoundButton(Color.RED.darker(), Color.RED.brighter());
    private RoundButton blueButton = new RoundButton(Color.BLUE.darker(), Color.BLUE.brighter());
    private RoundButton greenButton = new RoundButton(Color.GREEN.darker(), Color.GREEN.brighter());
    private RoundButton yellowButton = new RoundButton(Color.YELLOW.darker(), Color.YELLOW.brighter());
    private RoundButton startButton = new RoundButton(Color.WHITE, Color.GRAY, Color.BLACK);
    private boolean has_started;
    private int buttons_clicked, rounds_completed;


    public ButtonFunctionality(String type) {
        gametype = type;
        createComponenets();
    }

    public void startmusic(File music) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        AudioInputStream musicstream = AudioSystem.getAudioInputStream(music);
        musics = AudioSystem.getClip();
        musics.open(musicstream);
        musics.loop(Clip.LOOP_CONTINUOUSLY);
    }

    public void createComponenets() {
        setTitle("Button Presser");
        getContentPane().setBackground(Color.BLACK);
        setSize(1000, 1000);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(null);

        redButton.setBounds(125, 125, 200, 200);
        add(redButton);

        blueButton.setBounds(700, 125, 200, 200);
        add(blueButton);

        greenButton.setBounds(125, 700, 200, 200);
        add(greenButton);

        yellowButton.setBounds(700, 700, 200, 200);
        add(yellowButton);

        startButton.setBounds(450, 450, 100, 100);
        startButton.setLabel("Start");
        startButton.setFont(new Font("Courier New", Font.BOLD, 20));
        startButton.addActionListener(this);
        add(startButton);


        setVisible(true);
    }

    public void memorygame() {

    }



    public void clickergame() {
        int initialDelay = 0;
        int interval = 12000;
        Timer timer = new Timer();
        for (int i = 0; i < 100; i++) {
            double buttonchance = Math.random();
            if (buttonchance < 0.25) random_clickers.add(redButton);
            else if (buttonchance < 0.5) random_clickers.add(greenButton);
            else if (buttonchance < 0.75) random_clickers.add(yellowButton);
            else random_clickers.add(blueButton);
        }
        for (int i = 0; i < random_clickers.size(); i++) {
            int finalI = i;

            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    random_clickers.get(finalI).changecolor();
                    if (buttonspressed != null && random_clickers.get(finalI).equals(buttonspressed.get(finalI))) {
                        buttons_clicked++;
                        buttonspressed.get(finalI).changecolor();
                    } else {
                        
                    }
                }
            }, initialDelay);

            initialDelay += interval; // Increment the delay for next task
            interval *= 9/10; // Decrease the interval for subsequent tasks
        }
    }

    public void resetButtoncolor(RoundButton button) {

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == startButton) {
            if (gametype.equals("reflexes")) {
                if (!has_started) {
                    redButton.addActionListener(this);
                    blueButton.addActionListener(this);
                    greenButton.addActionListener(this);
                    yellowButton.addActionListener(this);
                    startButton.setLabel("Stop");
                    has_started = true;
                    try {
                        startmusic(new File("Default Music.wav"));
                    } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
                        throw new RuntimeException(ex);
                    }
                    clickergame();
                } else {
                    startButton.setLabel("Start");
                    has_started = false;
                    musics.stop();
                    JOptionPane.showMessageDialog(new JFrame(), "You have decided to stop. You pressed " + buttons_clicked + " buttons", "You have Stopped!", JOptionPane.WARNING_MESSAGE);
                    setVisible(false);
                }
            }
            if (gametype.equals("memory")) {

            }
        }
    }

}
