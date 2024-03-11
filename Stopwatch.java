import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
public class Stopwatch extends JFrame implements ActionListener {

    JFrame frame = new JFrame();
    JButton start = new JButton();
    JLabel time = new JLabel();
    int elapsedtime = 0;
    int seconds = 0;
    int minutes = 0;
    boolean started = false;
    String seconds_string = String.format("02d", seconds);
    String minutes_string = String.format("02d", minutes);

    public Stopwatch() {

    }

    public void start() {

    }

    public void stop() {

    }

    public boolean getStarted() {
        return started;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
