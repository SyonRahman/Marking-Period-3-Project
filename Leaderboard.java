import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Leaderboard extends JFrame implements ActionListener {
    final private JButton home = new JButton("Home");
    JPanel clickerPanel = new JPanel(new BorderLayout());
    JPanel memoryPanel = new JPanel(new BorderLayout());
    private ArrayList<MemoryGame> memoryleaderboard = new ArrayList<MemoryGame>();
    private ArrayList<ClickerGame> clickerleaderboard = new ArrayList<ClickerGame>();
    private ArrayList<Integer> rounds = new ArrayList<Integer>();
    private String name;

    public Leaderboard(ArrayList<MemoryGame> memoryleaderboard, ArrayList<ClickerGame> clickerleaderboard, String name) {
        this.name = name;
        this.memoryleaderboard = memoryleaderboard;
        this.clickerleaderboard = clickerleaderboard;
        createComponents();
    }

    public Leaderboard() {
        createComponents();
    }

    public void createComponents() {
        setTitle("Leaderboard");
        getContentPane().setBackground(Color.BLACK);
        setLayout(null);
        setSize(1000, 1000);
        setLocation(500, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        JLabel title = new JLabel("Leaderboard", SwingConstants.CENTER);
        title.setFont(new Font("Courier New", Font.BOLD, 30));
        title.setBounds(0, 10, getWidth(), 50);
        title.setForeground(Color.WHITE);
        this.add(title);

        home.setFont(new Font("Courier New", Font.BOLD, 15));
        home.setBounds(0, 0, 75, 60);
        home.setForeground(Color.BLACK);
        home.setBackground(Color.WHITE.brighter());
        home.addActionListener(this);
        this.add(home);

        JLabel clicker = new JLabel("Clicker Game", SwingConstants.CENTER);
        clicker.setFont(new Font("Courier New", Font.BOLD, 20));
        clicker.setForeground(Color.RED);
        JLabel memory = new JLabel("Memory Game", SwingConstants.CENTER);
        memory.setFont(new Font("Courier New", Font.BOLD, 20));
        memory.setForeground(Color.YELLOW);
        clickerPanel.setBackground(Color.BLUE);
        memoryPanel.setBackground(Color.GREEN);

        clickerPanel.add(clicker, BorderLayout.NORTH);
        memoryPanel.add(memory, BorderLayout.NORTH);
        JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, clickerPanel, memoryPanel);
        split.setDividerLocation(500);
        split.setBounds(0, 60, getWidth(), getHeight() - 60);
        add(split);

        setResizable(false);
        setVisible(true);



        sortLeaderboard();
        setmemoryLeaderboard();
        setclickerLeaderboard();
    }

    public void setmemoryLeaderboard() {
        int y = 80;
        if (memoryleaderboard.size() < 10) {
            for (int i = 0; i < memoryleaderboard.size(); i++) {
                JLabel label = new JLabel();
                label.setText("Name: " + name + " Rounds Completed: " + memoryleaderboard.get(i).getRounds_completed());
                label.setFont(new Font("Courier New", Font.BOLD, 15));
                label.setForeground(Color.BLACK);
                label.setBounds(750, y, 25, 25);
                memoryPanel.add(label);
                y += 25;
            }
        } else {
            for (int i = 0; i < 10; i++) {
                JLabel label = new JLabel();
                label.setText("Name: " + name + " Rounds Completed: " + memoryleaderboard.get(i).getRounds_completed());
                label.setFont(new Font("Courier New", Font.BOLD, 15));
                label.setForeground(Color.BLACK);
                label.setBounds(750, y, 25, 25);
                memoryPanel.add(label);
                y += 25;
            }
        }
    }

    public void setclickerLeaderboard() {
        int y = 80;
        if (clickerleaderboard.size() < 10) {
            for (int i = 0; i < clickerleaderboard.size(); i++) {
                JLabel label = new JLabel();
                label.setText("Name: " + name + " Buttons Clicked: " + clickerleaderboard.get(i).getButtons_clicked());
                label.setFont(new Font("Courier New", Font.BOLD, 15));
                label.setForeground(Color.BLACK);
                label.setBounds(250, y, 25, 25);
                clickerPanel.add(label);
                y += 25;
            }
        } else {
            for (int i = 0; i < 10; i++) {
                JLabel label = new JLabel();
                label.setText("Name: " + name + " Buttons Clicked: " + clickerleaderboard.get(i).getButtons_clicked());
                label.setFont(new Font("Courier New", Font.BOLD, 15));
                label.setForeground(Color.BLACK);
                label.setBounds(250, y, 25, 25);
                clickerPanel.add(label);
                y += 25;
            }
        }
    }

    public void sortLeaderboard() {
        for (int i = 0; i < memoryleaderboard.size() - 1; i++) {
            int maxIndex = i;
            for (int j = i + 1; i < memoryleaderboard.size(); i++) {
                if (memoryleaderboard.get(j).getRounds_completed() > memoryleaderboard.get(maxIndex).getRounds_completed()) {
                    maxIndex = j;
                }
            }
            MemoryGame temp = memoryleaderboard.get(maxIndex);
            memoryleaderboard.set(maxIndex, memoryleaderboard.get(i));
            memoryleaderboard.set(i, temp);
        }

        for (int i = 0; i < clickerleaderboard.size() - 1; i++) {
            int maxIndex = i;
            for (int j = i + 1; i < clickerleaderboard.size(); i++) {
                if (clickerleaderboard.get(j).getButtons_clicked() > clickerleaderboard.get(maxIndex).getButtons_clicked()) {
                    maxIndex = j;
                }
            }
            ClickerGame temp = clickerleaderboard.get(maxIndex);
            clickerleaderboard.set(maxIndex, clickerleaderboard.get(i));
            clickerleaderboard.set(i, temp);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == home) {
            new Introduction().createComponents();
            setVisible(false);
        }
    }
}
