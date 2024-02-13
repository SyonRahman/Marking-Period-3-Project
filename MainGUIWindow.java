import javax.swing.*;
import java.awt.event.*;

public class MainGUIWindow extends JFrame implements ActionListener, KeyListener, MouseListener {

    private JPanel newpanel;
    private JButton redButton;
    private JButton blueButton;
    private JButton greenButton;
    private JButton yellowButton;

    public MainGUIWindow() {
        createComponents();
    }

    private void createComponents() {
        setContentPane(newpanel);
        setTitle("Button Game");
        setSize(500, 500);
        setLocation(500, 500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void buttonsequence() {

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    private void createUIComponents() {

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
