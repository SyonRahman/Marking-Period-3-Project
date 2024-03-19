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
    private String gametype;
    private Clip musics;
    private ArrayList<RoundButton> random_clickers = new ArrayList<RoundButton>();
    private ArrayList<Timer> timers = new ArrayList<Timer>();
    private RoundButton redButton = new RoundButton(new Color(138, 22, 22), Color.WHITE, new Color(235, 18, 18));
    private RoundButton blueButton = new RoundButton(new Color(12, 16, 122), Color.WHITE, new Color(31, 38, 245));
    private RoundButton greenButton = new RoundButton(new Color(15, 111, 35), Color.WHITE, new Color(39, 225, 76));
    private RoundButton yellowButton = new RoundButton(new Color(154, 158, 27), Color.WHITE, new Color(227, 235, 17));
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
        yellowButton.setBackground(Color.GREEN);
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


    public void memorygame() {

    }

    public void clickergame() {
        random_clickers.clear();
        for (int i = 0; i < 100; i++) {
            double buttonchance = Math.random();
            if (buttonchance < 0.25) random_clickers.add(redButton);
            else if (buttonchance < 0.5) random_clickers.add(greenButton);
            else if (buttonchance < 0.75) random_clickers.add(yellowButton);
            else random_clickers.add(blueButton);
        }
        for (int i = 0; i < random_clickers.size(); i++) {
            int finalI = i;
            int initialDelay = 10000;

            Timer timer = new Timer();
            timers.add(timer);
            TimerTask task = new TimerTask() {
                @Override
                public void run() {
                    makelight(random_clickers.get(finalI));

                    if (has_started) {
                        if (random_clickers.get(finalI).equals(buttonspressed.get(finalI))) {
                            buttons_clicked++;
                            int updatedDelay = setdelay(initialDelay);
                            cancel();
                            scheduleNextTask(finalI, updatedDelay);
                        } else {
                            has_started = false;
                            cancel();
                        }
                    }
                }
            };
            timer.schedule(task, initialDelay);
        }
    }

    public void scheduleNextTask(int index, int delay) {
        Timer timer = new Timer();
        timers.add(timer);

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                makelight(random_clickers.get(index));

                if (has_started) {
                    if (random_clickers.get(index).equals(buttonspressed.get(index))) {
                        buttons_clicked++;
                        int updatedDelay = setdelay(delay);
                        cancel();
                        scheduleNextTask(index, updatedDelay);
                    } else {
                        has_started = false;
                        cancel();
                    }
                }
            }
        };
        timer.schedule(task, delay);
    }

    public RoundButton makelight(RoundButton button) {
        if (button == redButton) {
            redButton.repaint(new Color(235, 18, 18), new Color(138, 22, 22));
        }
        if (button == blueButton) {
           blueButton.repaint(new Color(31, 38, 255), new Color(12, 16, 122));
        }
        if (button == greenButton) {
            greenButton.repaint(new Color(39, 225, 76), new Color(15, 111, 35));
        }
        if (button == yellowButton) {
            yellowButton.repaint(new Color(225, 235, 76), new Color(154, 158, 35));
        }
        return null;
    }

    public void resetButtoncolor(RoundButton button) {

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
                    JOptionPane.showMessageDialog(new JFrame(), "You have decided to stop. You pressed " + buttons_clicked + " buttons", "You have Stopped!", JOptionPane.WARNING_MESSAGE);
                    setVisible(false);
                }
            }
            if (gametype.equals("memory")) {

            }
        }
    }
}
