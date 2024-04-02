import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class MemoryGame extends JFrame implements ActionListener {
    private ArrayList<RoundButton> buttonspressed = new java.util.ArrayList<RoundButton>();
    private Clip musics;
    private boolean sequenceexecuted;
    private ArrayList<RoundButton> memory_buttons = new ArrayList<RoundButton>();
    private RoundButton redButton = new RoundButton(Color.RED.darker().darker(), Color.RED.brighter());
    private RoundButton blueButton = new RoundButton(Color.BLUE.darker().darker(), Color.BLUE.brighter());
    private RoundButton greenButton = new RoundButton(Color.GREEN.darker().darker(), Color.GREEN.brighter());
    private RoundButton yellowButton = new RoundButton(Color.YELLOW.darker().darker(), Color.YELLOW.brighter());
    private RoundButton startButton = new RoundButton(Color.WHITE, Color.GRAY, Color.BLACK);
    private boolean has_started;
    private int rounds_completed;

    public MemoryGame() {
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

        action();
    }

    public void action() {
        MouseAdapter buttonListener = new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                if (sequenceexecuted) {
                    return;
                }
                RoundButton button = (RoundButton) e.getSource();
                buttonspressed.add(button);
                if (!buttonspressed.equals(partofList(memory_buttons, 0, buttonspressed.size()))) {
                    int memoryended = JOptionPane.showConfirmDialog(null, "You have clicked the wrong buttons! You completed " +
                            rounds_completed + " rounds", "You have lost", JOptionPane.OK_CANCEL_OPTION);
                    musics.stop();
                    if (memoryended == JOptionPane.OK_OPTION || memoryended == JOptionPane.CANCEL_OPTION || memoryended == JOptionPane.CLOSED_OPTION) {
                        dispose();
                    }
                } else if (buttonspressed.size() == memory_buttons.size()) {
                    rounds_completed++;
                    memorygame();
                }
            }
        };
        redButton.addMouseListener(buttonListener);
        blueButton.addMouseListener(buttonListener);
        greenButton.addMouseListener(buttonListener);
        yellowButton.addMouseListener(buttonListener);
    }

    public ArrayList<RoundButton> partofList(ArrayList<RoundButton> buttons, int start, int end) {
        ArrayList<RoundButton> partofList = new ArrayList<RoundButton>();
        for (int i = start; i < end; i++) {
            partofList.add(buttons.get(i));
        }
        return partofList;
    }

    public void memorygame() {
        memory_buttons.add(setRandomButtons());
        buttonspressed.clear();
        SwingWorker<Void, Void> memories = new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {
                sequenceexecuted = true;
                redButton.setEnabled(false);
                blueButton.setEnabled(false);
                greenButton.setEnabled(false);
                yellowButton.setEnabled(false);
                for (RoundButton button : memory_buttons) {
                    button.changecolor();
                    Thread.sleep(3000);
                    button.changecolor();
                }
                redButton.setEnabled(true);
                blueButton.setEnabled(true);
                greenButton.setEnabled(true);
                yellowButton.setEnabled(true);
                sequenceexecuted = false;

                return null;
            }

            @Override
            protected void done() {
                super.done();
            }
        };
        memories.execute();
    }

    public RoundButton setRandomButtons() {
        if (Math.random() < 0.25) return redButton;
        else if (Math.random() < 0.5) return blueButton;
        else if (Math.random() < 0.75) return greenButton;
        else return yellowButton;
    }

    public int getRounds_completed() {
        return rounds_completed;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == startButton) {
            if (!has_started) {
                startButton.setLabel("Stop");
                has_started = true;
                try {
                    startmusic(new File("Memory Music.wav"));
                } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
                    throw new RuntimeException(ex);
                }
                memorygame();
            } else {
                startButton.setLabel("Start");
                has_started = false;
                musics.stop();
                int stop = JOptionPane.showConfirmDialog(null, "You have decided to stop. You completed " + rounds_completed + " rounds", "You have Stopped!", JOptionPane.OK_CANCEL_OPTION);
                if (stop == JOptionPane.OK_OPTION || stop == JOptionPane.CANCEL_OPTION || stop == JOptionPane.CLOSED_OPTION) {
                    dispose();
                }
            }
        }
    }


}
