import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MainGUIWindow extends JFrame implements ActionListener, KeyListener {

    private JPanel newpanel;
    private JButton redButtonButton;
    private JButton blueButtonButton;
    private JButton greenButtonButton;
    private JButton yellowButtonButton;

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
}
