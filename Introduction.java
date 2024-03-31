import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;

public class Introduction extends JFrame implements ActionListener, KeyListener {

    private JPanel newpanel;
    private JLabel Name;
    private JTextField NameEnter;
    private JButton NameSet;
    private JLabel Title;
    private JPanel Body;
    private JButton Leaderboard;
    private String name;
    private HashMap<String, Integer> leaderboard = new HashMap<String, Integer>();

    public Introduction() {

    }

    public Introduction(String name, int completed) {
        leaderboard.put(name, completed);
    }

    public void createComponents() {
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
        setResizable(false);
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
        Leaderboard.addActionListener(this);
        Leaderboard.setFont(new Font("Courier New", Font.BOLD, 40));
        Leaderboard.setForeground(Color.WHITE);
        Leaderboard.setBackground(Color.BLACK);
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

    private void createChoicePanel() {
        JPanel choicePanel = new JPanel();
        choicePanel.setLayout(new GridLayout(0, 1));

        JButton memory = new JButton("Memory");
        JButton reflexes = new JButton("Reflexes");

        memory.setBounds(50, 50, 200, 500);
        reflexes.setBounds(250, 50, 200, 500);
        memory.setFont(new Font("Courier New", Font.BOLD, 50));
        reflexes.setFont(new Font("Courier New", Font.BOLD, 50));
        memory.setForeground(Color.RED);
        reflexes.setForeground(Color.YELLOW);
        memory.setBackground(Color.BLUE);
        reflexes.setBackground(Color.GREEN);
        memory.addActionListener(e -> {
            new MemoryGame();
            setVisible(false);
        });
        reflexes.addActionListener(e -> {
            new ClickerGame();
            setVisible(false);
        });

        choicePanel.add(memory);
        choicePanel.add(reflexes);

        JFrame gameChoiceFrame = new JFrame("Choose Game");
        gameChoiceFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameChoiceFrame.getContentPane().add(choicePanel);
        gameChoiceFrame.setSize(1000, 1000);
        gameChoiceFrame.setLocationRelativeTo(null);
        gameChoiceFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == NameSet) {
            name = NameEnter.getText();
            setVisible(false);
            createChoicePanel();
        }
        if (e.getSource() == Leaderboard) {
            setVisible(false);
            new Leaderboard();
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
