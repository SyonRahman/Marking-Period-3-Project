import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ButtonFunctionality extends JFrame implements ActionListener, MouseListener {
    private JPanel Buttons;
    private JButton redButton;
    private JButton blueButton;
    private JButton greenButton;
    private JButton yellowButton;

    public ButtonFunctionality() {
        createComponenets();
    }

    public void createComponenets() {
        setContentPane(Buttons);
        setTitle("Button Presser");
        setSize(500, 500);
        setLocation(500, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        ImageIcon lightredbutton = new ImageIcon("LightRedButton.png");
    }

    private void setButtons() {
        redButton.setBounds(125, 125, 50, 50);
        blueButton.setBounds(375, 125, 50, 50);
        greenButton.setBounds(125, 375, 50, 50);
        yellowButton.setBounds(375, 375, 50, 50);
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
