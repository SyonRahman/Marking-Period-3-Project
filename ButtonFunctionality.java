import java.lang.reflect.Array;
import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ButtonFunctionality extends JFrame implements ActionListener, MouseListener {


    private ArrayList<RoundButton> buttonspressed = new ArrayList<RoundButton>();
    private RoundButton redButton = new RoundButton(Color.RED, Color.WHITE);
    private RoundButton blueButton = new RoundButton(Color.BLUE, Color.WHITE);
    private RoundButton greenButton = new RoundButton(Color.GREEN, Color.WHITE);
    private RoundButton yellowButton = new RoundButton(Color.YELLOW, Color.WHITE);


    public ButtonFunctionality() {
        createComponenets();
        buttonsequence();
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
        this.buttonfrequency(1000);
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


    @Override
    public void actionPerformed(ActionEvent e) {
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
