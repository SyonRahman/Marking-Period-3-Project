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
    private JPanel Body;
    private String name;

    public Introduction() {
        createComponents();
    }

    private void createComponents() {
        this.setPanels();
        this.setButtons();
        this.setTextField();
        this.setLabels();
        setContentPane(newpanel);
        setTitle("Button Game");
        setSize(500, 500);
        setLocation(500, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void setPanels() {
        setContentPane(newpanel);
        newpanel.setBackground(Color.GREEN);
        Body.setBackground(Color.GREEN);
    }

    private void setButtons() {
        NameSet.addActionListener(this);
        NameSet.setFont(new Font("Courier New", Font.BOLD, 30));
        NameSet.setForeground(Color.RED);
        NameSet.setBackground(Color.YELLOW);
    }

    private void setLabels() {
        Title.setFont(new Font("Times New Roman", Font.BOLD, 50));
        Title.setForeground(Color.CYAN);
        Name.setFont(new Font("Courier New", Font.BOLD, 40));
        Name.setForeground(Color.MAGENTA);
    }

    private void setTextField() {
        NameEnter.setFont(new Font("Courier New", Font.BOLD, 50));
        NameEnter.setBackground(Color.pink);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == NameSet) {
            name = NameEnter.getText();
            setVisible(false);
            new MainGUIWindow();
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

    public String getName() {
        return name;
    }
}
