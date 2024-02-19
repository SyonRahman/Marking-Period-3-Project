import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ButtonFunctionality extends JFrame implements ActionListener, MouseListener {

    private JFrame ButtonsClick = new JFrame();
    private JPanel Buttons = new JPanel();


    public ButtonFunctionality() {
        createComponenets();
    }

    public void createComponenets() {
        this.setButtons();
        setContentPane(Buttons);
        setTitle("Button Presser");
        setSize(1000, 1000);
        setLocation(500, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void setButtons() {
        ButtonsClick.add(Buttons);

        RoundButton redButton = new RoundButton(Color.RED, Color.GRAY);
        redButton.setLayout(null);
        redButton.setBounds(125, 125, 100, 100);
        Buttons.add(redButton);

        RoundButton blueButton = new RoundButton(Color.BLUE, Color.GRAY);
        blueButton.setLayout(null);
        blueButton.setBounds(800, 125, 100, 100);
        Buttons.add(blueButton);

        RoundButton greenButton = new RoundButton(Color.GREEN, Color.GRAY);
        greenButton.setLayout(null);
        greenButton.setBounds(125, 800, 100, 100);
        Buttons.add(greenButton);

        RoundButton yellowButton = new RoundButton(Color.YELLOW, Color.GRAY);
        yellowButton.setLayout(null);
        yellowButton.setBounds(800, 800, 100, 100);
        Buttons.add(yellowButton);

        this.add(redButton);
        this.add(yellowButton);
        this.add(greenButton);
        this.add(blueButton);
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
