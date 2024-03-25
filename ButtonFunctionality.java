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
    private RoundButton redButton = new RoundButton(Color.RED.darker().darker(), Color.RED.brighter());
    private RoundButton blueButton = new RoundButton(Color.BLUE.darker().darker(), Color.BLUE.brighter());
    private RoundButton greenButton = new RoundButton(Color.GREEN.darker().darker(), Color.GREEN.brighter());
    private RoundButton yellowButton = new RoundButton(Color.YELLOW.darker().darker(), Color.YELLOW.brighter());
    private RoundButton startButton = new RoundButton(Color.WHITE, Color.GRAY, Color.BLACK);
    private boolean has_started;
    private int interval;
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

        blueButton.setBounds(625, 125, 200, 200);
        add(blueButton);

        greenButton.setBounds(125, 625, 200, 200);
        add(greenButton);

        yellowButton.setBounds(625, 625, 200, 200);
        add(yellowButton);

        startButton.setBounds(425, 425, 100, 100);
        startButton.setLabel("Start");
        startButton.setFont(new Font("Courier New", Font.BOLD, 20));
        startButton.addActionListener(this);
        add(startButton);


        setResizable(false);
        setVisible(true);
    }

    public void memorygame() {

    }

    public void clickersgame() throws InterruptedException {
        interval = 12000;
        for (int i = 0; i < 100; i++) {
            double buttonchance = Math.random();
            if (buttonchance < 0.25) random_clickers.add(redButton);
            else if (buttonchance < 0.5) random_clickers.add(greenButton);
            else if (buttonchance < 0.75) random_clickers.add(yellowButton);
            else random_clickers.add(blueButton);
        }
        for (int i = 0; i < random_clickers.size(); i++) {
            int finalI = i;
            SwingWorker<Void, Void> clicker = new SwingWorker<Void, Void>() {
                boolean hasCompleted = false;
                @Override
                protected Void doInBackground() throws Exception {
                    random_clickers.get(finalI).changecolor();
                    random_clickers.get(finalI).addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            if (e.getSource() == random_clickers.get(finalI)) {
                                random_clickers.get(finalI).changecolor();
                                buttons_clicked++;
                                hasCompleted = true;
                            } else {
                                JOptionPane.showMessageDialog(new JFrame(), "You Clicked the wrong button! You pressed " + buttons_clicked + " buttons", "You have lost", JOptionPane.WARNING_MESSAGE);
                            }
                        }
                    });
                    Thread.sleep(interval);

                    return null;
                }

                @Override
                protected void done() {
                    super.done();
                }
            };
            clicker.execute();
        }
    }



    public void clickergame() {
        boolean[] clickedcorrectly = new boolean[1];
        int initialDelay = 0;
        int interval = 12000;
        int index = 0;
        Timer timer = new Timer();
        for (int i = 0; i < 100; i++) {
            double buttonchance = Math.random();
            if (buttonchance < 0.25) random_clickers.add(redButton);
            else if (buttonchance < 0.5) random_clickers.add(greenButton);
            else if (buttonchance < 0.75) random_clickers.add(yellowButton);
            else random_clickers.add(blueButton);
        }
        int finalIndex = index;
        TimerTask task = new TimerTask() {
                @Override
                public void run() {
                    if (finalIndex < random_clickers.size()) {
                        random_clickers.get(finalIndex).changecolor();
                        random_clickers.get(finalIndex).addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                if (e.getSource() == random_clickers.get(finalIndex)) {
                                    clickedcorrectly[0] = true;
                                    random_clickers.get(finalIndex).changecolor();
                                    buttons_clicked++;
                                } else {
                                    JOptionPane.showMessageDialog(new JFrame(), "You Clicked the wrong button! You pressed " + buttons_clicked + " buttons", "You have lost", JOptionPane.WARNING_MESSAGE);
                                }
                            }
                        });
                    } else {
                        timer.cancel();
                    }
                }
        };

        timer.schedule(task, 0, 5000);

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
                    try {
                        clickersgame();
                    } catch (InterruptedException ex) {
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
