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
        JPanel Buttons = new JPanel();
        JButton redButton = new RoundButton();
        redButton = new RoundButton();
        redButton.setBackground(Color.RED);
        Buttons.add(redButton);
        this.setButtons();
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
