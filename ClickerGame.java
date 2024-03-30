import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class ClickerGame extends JFrame implements ActionListener {
    private ArrayList<RoundButton> buttonspressed = new ArrayList<RoundButton>();
    private Clip musics;
    private ArrayList<RoundButton> random_clickers = new ArrayList<RoundButton>();
    private ArrayList<RoundButton> memory_buttons = new ArrayList<RoundButton>();
    private RoundButton redButton = new RoundButton(Color.RED.darker().darker(), Color.RED.brighter());
    private RoundButton blueButton = new RoundButton(Color.BLUE.darker().darker(), Color.BLUE.brighter());
    private RoundButton greenButton = new RoundButton(Color.GREEN.darker().darker(), Color.GREEN.brighter());
    private RoundButton yellowButton = new RoundButton(Color.YELLOW.darker().darker(), Color.YELLOW.brighter());
    private RoundButton startButton = new RoundButton(Color.WHITE, Color.GRAY, Color.BLACK);
    private boolean has_started;
    private String name;
    private int buttons_clicked;

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

    public void clickersgame() throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            random_clickers.add(setRandomButtons());
        }
        newclicker(0, 10000);
    }

    public void newclicker(int index, int interval) {
        if (index >= random_clickers.size()) {
            return;
        }

        SwingWorker<Void, Void> clicker = new SwingWorker<>() {
            boolean hasCompleted = false;

            @Override
            protected Void doInBackground() throws Exception {
                random_clickers.get(index).changecolor();
                random_clickers.get(index).addActionListener(e -> {
                    if (e.getSource() == random_clickers.get(index)) {
                        random_clickers.get(index).changecolor();
                        buttons_clicked++;
                        hasCompleted = true;
                        newclicker(index + 1, interval * 9 / 10);
                    } else {
                        int ended = JOptionPane.showConfirmDialog(null, "You have clicked the wrong button! You pressed " +
                                buttons_clicked + " buttons", "You have lost", JOptionPane.OK_CANCEL_OPTION);
                    }
                });
                Thread.sleep(interval);

                if (!hasCompleted) {
                    int notpressed = JOptionPane.showConfirmDialog(null, "You have not pressed the button in time! You pressed " +
                            buttons_clicked + " buttons", "You have lost", JOptionPane.OK_CANCEL_OPTION);
                    if (notpressed == JOptionPane.OK_OPTION || notpressed == JOptionPane.CANCEL_OPTION || notpressed == JOptionPane.CLOSED_OPTION) {
                        setVisible(false);
                    }
                }

                return null;
            }

            protected void done() {
                super.done();
            }
        };
        clicker.execute();
    }

    public RoundButton setRandomButtons() {
        if (Math.random() < 0.25) return redButton;
        else if (Math.random() < 0.5) return greenButton;
        else if (Math.random() < 0.75) return yellowButton;
        else return blueButton;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == startButton) {
                if (!has_started) {
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
                    int stop = JOptionPane.showConfirmDialog(null, "You have decided to stop. You pressed " + buttons_clicked + " buttons", "You have Stopped!", JOptionPane.OK_CANCEL_OPTION);
                    if (stop == JOptionPane.OK_OPTION || stop == JOptionPane.CANCEL_OPTION || stop == JOptionPane.CLOSED_OPTION) {
                        setVisible(false);
                    }
                }
        }
    }
}
