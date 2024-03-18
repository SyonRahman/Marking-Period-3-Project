import java.lang.reflect.Array;

import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.sound.sampled.*;
import java.io.IOException;


public class ButtonFunctionality extends JFrame implements ActionListener {


    private ArrayList<RoundButton> buttonspressed = new ArrayList<RoundButton>();
    private String gametype;
    private Timer timer;
    private Clip musics;
    private RoundButton redButton = new RoundButton(new Color(138, 22, 22), Color.WHITE, new Color(235, 18, 18));
    private RoundButton blueButton = new RoundButton(new Color(12, 16, 122), Color.WHITE, new Color(31, 38, 245));
    private RoundButton greenButton = new RoundButton(new Color(15, 111, 35), Color.WHITE, new Color(39, 225, 76));
    private RoundButton yellowButton = new RoundButton(new Color(154, 158, 27), Color.WHITE, new Color(227, 235, 17));
    private RoundButton startButton = new RoundButton(Color.WHITE, Color.GRAY, Color.BLACK);
    private boolean has_started;
    private int buttons_clicked, rounds_completed;
    private int delay;



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
        delay = 10000;
        setTitle("Button Presser");
        getContentPane().setBackground(Color.BLACK);
        setSize(1000, 1000);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(null);

        redButton.setBounds(125, 125, 200, 200);
        redButton.addActionListener(this);
        add(redButton);

        blueButton.setBounds(700, 125, 200, 200);
        blueButton.addActionListener(this);
        add(blueButton);

        greenButton.setBounds(125, 700, 200, 200);
        greenButton.addActionListener(this);
        add(greenButton);

        yellowButton.setBounds(700, 700, 200, 200);
        yellowButton.addActionListener(this);
        add(yellowButton);

        startButton.setBounds(450, 450, 100, 100);
        startButton.setLabel("Start");
        startButton.setFont(new Font("Courier New", Font.BOLD, 20));
        startButton.addActionListener(this);
        add(startButton);


        setVisible(true);
    }


    public int setdelay(int delay) {
        delay *= 7/8;
        return delay;
    }

    public void buttonfrequency(int timedelay) {
        try {
            Thread.sleep(timedelay);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void memorygame() {

    }

    public void clickergame() {
        ArrayList<RoundButton> random_clickers = new ArrayList<RoundButton>();
        for (int i = 0; i < 100; i++) {
            double buttonchance = Math.random();
            if (buttonchance < 0.25) random_clickers.add(redButton);
            else if (buttonchance < 0.5) random_clickers.add(greenButton);
            else if (buttonchance < 0.75) random_clickers.add(yellowButton);
            else if (buttonchance < 1) random_clickers.add(blueButton);
        }
        for (int i = 0; i < random_clickers.size(); i++) {
            int finalI = i;
            timer = new Timer(delay, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    ((Timer) e.getSource()).start();
                    if (e.getSource() == timer) {
                        if (has_started) {
                            if (e.getSource() == redButton) buttonspressed.add(redButton);
                            else if (e.getSource() == blueButton) buttonspressed.add(blueButton);
                            else if (e.getSource() == greenButton) buttonspressed.add(greenButton);
                            else if (e.getSource() == yellowButton) buttonspressed.add(yellowButton);
                        }
                        if (random_clickers.get(finalI) == buttonspressed.get(finalI)) {
                            buttons_clicked++;
                            setdelay(delay);
                            ((Timer) e.getSource()).start();
                        } else {
                            has_started = false;
                        }
                    }
                }
            });
        }
    }

    public void lightup(ArrayList<RoundButton> buttons) {
        for (int i = 0; i < buttons.size(); i++) {
            if (buttons.get(i) == redButton) {
                makelight(redButton);
            } else {
                if (buttons.get(i) == blueButton) {
                    makelight(blueButton);
                } else {
                    if (buttons.get(i) == greenButton) {
                        makelight(greenButton);
                    } else {
                        makelight(yellowButton);
                    }
                }
            }
        }
    }

    public RoundButton makelight(RoundButton button) {
        if (button == redButton) {
            return new RoundButton(new Color(235, 18, 18), Color.WHITE, new Color(138, 22, 22));
        }
        if (button == blueButton) {
            return new RoundButton(new Color(31, 38, 245), Color.WHITE, new Color(12, 16, 122));
        }
        if (button == greenButton) {
            return new RoundButton(new Color(39, 225, 76), Color.WHITE, new Color(15, 111, 35));
        }
        if (button == yellowButton) {
            return new RoundButton(new Color(227, 235, 17), Color.WHITE, new Color(154, 158, 27));
        }
        return null;
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == startButton) {
            if (gametype.equals("reflexes")) {
                if (!has_started) {
                    startButton.setLabel("Stop");
                    has_started = true;
                    clickergame();
                    try {
                        startmusic(new File("Default Music.wav"));
                    } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
                        throw new RuntimeException(ex);
                    }
                } else {
                    startButton.setLabel("Start");
                    has_started = false;
                    musics.stop();
                    JOptionPane.showMessageDialog(null, "You have decided to stop. You pressed " + buttons_clicked + " buttons", "You have Stopped!", JOptionPane.WARNING_MESSAGE);
                    setVisible(false);
                }
            }
            if (gametype.equals("memory")) {

            }
        }
    }
}
