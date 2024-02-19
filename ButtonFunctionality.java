import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ButtonFunctionality extends JFrame implements ActionListener, MouseListener {


    public ButtonFunctionality() {
        createComponenets();
    }

    public void createComponenets() {
        setTitle("Button Presser");
        setSize(1000, 1000);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(null);

        RoundButton redButton = new RoundButton(Color.RED, Color.GRAY);
        redButton.setBounds(125, 125, 200, 200);
        redButton.addActionListener(this);
        add(redButton);

        RoundButton blueButton = new RoundButton(Color.BLUE, Color.GRAY);
        blueButton.setBounds(700, 125, 200, 200);
        blueButton.addActionListener(this);
        add(blueButton);

        RoundButton greenButton = new RoundButton(Color.GREEN, Color.GRAY);
        greenButton.setBounds(125, 700, 200, 200);
        greenButton.addActionListener(this);
        add(greenButton);

        RoundButton yellowButton = new RoundButton(Color.YELLOW, Color.GRAY);
        yellowButton.setBounds(700, 700, 200, 200);
        yellowButton.addActionListener(this);
        add(yellowButton);

        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

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
