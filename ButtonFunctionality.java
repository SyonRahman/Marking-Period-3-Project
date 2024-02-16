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
        RoundButton redButton = new RoundButton(Color.RED, Color.GRAY, 250, 250);
        redButton.setLayout(null);
        redButton.setLocation(500, 500);
        Buttons.add(redButton);
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
