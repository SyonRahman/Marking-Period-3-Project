import java.lang.reflect.Array;
import java.util.Timer;
import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ButtonFunctionality extends JFrame implements ActionListener, MouseListener {


    private ArrayList<RoundButton> buttonspressed = new ArrayList<RoundButton>();
    private String gametype;
    private RoundButton redButton = new RoundButton(new Color(138, 22, 22), Color.WHITE, new Color(235, 18, 18));
    private RoundButton blueButton = new RoundButton(new Color(12, 16, 122), Color.WHITE, new Color(31, 38, 245));
    private RoundButton greenButton = new RoundButton(new Color(15, 111, 35), Color.WHITE, new Color(39, 225, 76));
    private RoundButton yellowButton = new RoundButton(new Color(154, 158, 27), Color.WHITE, new Color(227, 235, 17));
    private RoundButton startButton = new RoundButton(Color.WHITE, Color.GRAY, Color.BLACK);
    private int buttons_clicked;
    private int rounds_compeleted;

    Stopwatch stopwatch = new Stopwatch();


    public ButtonFunctionality(String type) {
        createComponenets();
        if (type.equals("memory")) {
            memorygame();
        } else {
            clickergame();
        }
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
        add(yellowButton);

        startButton.setBounds(450, 450, 100, 100);
        startButton.setLabel("Start");
        startButton.setFont(new Font("Courier New", Font.BOLD, 20));
        startButton.addActionListener(this);
        add(startButton);


        setVisible(true);
    }

    public void buttonfrequency(int timedelay) {
        try {
            Thread.sleep(timedelay);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void buttonsequence()  {
        ArrayList<RoundButton> buttonsequence = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            double buttonchance = Math.random();
            if (buttonchance < 0.25) {
                buttonsequence.add(redButton);
                redButton.changecolor(Color.BLACK);
                redButton.changecolor(Color.RED);
                redButton.changecolor(redButton.getOriginalColor());
            }
            else {
                if (buttonchance < 0.5) {
                    buttonsequence.add(blueButton);
                    blueButton.changecolor(Color.BLACK);
                    blueButton.changecolor(Color.BLUE);
                    blueButton.changecolor(blueButton.getOriginalColor());
                }
                else {
                    if (buttonchance < 0.75) {
                        buttonsequence.add(greenButton);
                        greenButton.changecolor(Color.BLACK);
                        greenButton.changecolor(Color.GREEN);
                        greenButton.changecolor(greenButton.getOriginalColor());
                    }
                    else {
                        if (buttonchance < 1) {
                            buttonsequence.add(yellowButton);
                            yellowButton.changecolor(Color.BLACK);
                            yellowButton.changecolor(Color.YELLOW);
                            yellowButton.changecolor(yellowButton.getOriginalColor());
                        }
                    }
                }
            }
        }
    }

    public void memorygame() {

    }

    public void clickergame() {

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == startButton) {
            startButton.setLabel("Stop");
            if (e.getSource() == redButton) {
                buttonspressed.add(redButton);
            }
            if (e.getSource() == blueButton) {
                buttonspressed.add(blueButton);
            }
            if (e.getSource() == greenButton) {
                buttonspressed.add(greenButton);
            }
            if (e.getSource() == yellowButton) {
                buttonspressed.add(yellowButton);
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
