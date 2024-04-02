import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Introduction extends JFrame implements ActionListener {

    private JPanel newpanel;
    private JLabel Name;
    private JTextField NameEnter;
    private JButton NameSet;
    private JLabel Title;
    private JPanel Body;
    private JButton Leaderboard;
    private Leaderboard leaderboard;
    private String name;
    private ArrayList<String> names = new ArrayList<String>();
    private ArrayList<ClickerGame> clickerGames = new ArrayList<ClickerGame>();
    private ArrayList<MemoryGame> memoryGames = new ArrayList<MemoryGame>();

    public Introduction() {

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

        JButton memory = new JButton("MemoryGame");
        JButton reflexes = new JButton("ClickerGame");

        memory.setBounds(50, 50, 200, 500);
        reflexes.setBounds(250, 50, 200, 500);
        memory.setFont(new Font("Courier New", Font.BOLD, 50));
        reflexes.setFont(new Font("Courier New", Font.BOLD, 50));
        memory.setForeground(Color.RED);
        reflexes.setForeground(Color.YELLOW);
        memory.setBackground(Color.BLUE);
        reflexes.setBackground(Color.GREEN);


        choicePanel.add(memory);
        choicePanel.add(reflexes);

        JFrame gameChoiceFrame = new JFrame("Choose Game");
        gameChoiceFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameChoiceFrame.getContentPane().add(choicePanel);
        gameChoiceFrame.setSize(1000, 1000);
        gameChoiceFrame.setLocationRelativeTo(null);
        gameChoiceFrame.setVisible(true);

        memory.addActionListener(e -> {
            MemoryGame memorygame = new MemoryGame();
            memoryGames.add(memorygame);
            gameChoiceFrame.setVisible(false);
            setVisible(true);
            toBack();
        });
        reflexes.addActionListener(e -> {
            ClickerGame clickergame = new ClickerGame();
            clickerGames.add(clickergame);
            gameChoiceFrame.setVisible(false);
            setVisible(true);
            toBack();
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == NameSet) {
            name = NameEnter.getText();
            names.add(name);
            createChoicePanel();
            setVisible(false);
        }
        if (e.getSource() == Leaderboard) {
            if (leaderboard == null) {
                leaderboard = new Leaderboard(memoryGames, clickerGames, names);
            } else {
                leaderboard.updateLeaderboard(memoryGames, clickerGames, names);
                leaderboard.setVisible(true);
            }
            toBack();
        }
    }
}
