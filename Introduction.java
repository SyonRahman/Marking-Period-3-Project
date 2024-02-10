import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Introduction extends JFrame implements ActionListener, KeyListener {

    private JPanel newpanel;
    private JLabel Name;
    private JTextField NameEnter;
    private JButton NameSet;
    private JLabel Title;
    private String name;

    public Introduction() {
        createComponents();
    }

    private void createComponents() {
        NameSet.addActionListener(this);
        Title.setFont(new Font("Times New Roman", Font.BOLD, 50));
        Title.setForeground(Color.CYAN);
        Name.setFont(new Font("Courier New", Font.BOLD, 40));
        Name.setForeground(Color.MAGENTA);
        setContentPane(newpanel);
        setTitle("Button Game");
        setSize(500, 500);
        setLocation(500, 500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == NameSet) {
            name = NameEnter.getText();
            System.out.println(name);
        }
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
