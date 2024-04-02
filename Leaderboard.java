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
    private ArrayList<String> memorynames = new ArrayList<String>();
    private ArrayList<String> clickernames = new ArrayList<String>();
    private String name;

    public Leaderboard(ArrayList<MemoryGame> memoryleaderboard, ArrayList<ClickerGame> clickerleaderboard, ArrayList<String> memorynames, ArrayList<String> clickernames) {
        this.memoryleaderboard = memoryleaderboard;
        this.clickerleaderboard = clickerleaderboard;
        this.memorynames = memorynames;
        this.clickernames = clickernames;
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


        JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, clickerPanel, memoryPanel);
        split.setDividerLocation(500);
        split.setBounds(0, 60, getWidth(), getHeight() - 60);
        add(split);

        setResizable(false);
        setVisible(true);



        createLeaderboard();
    }

    public void setmemoryLeaderboard() {
        memoryPanel.removeAll();
        memoryPanel.setLayout(new BoxLayout(memoryPanel, BoxLayout.Y_AXIS));
        JLabel memory = new JLabel("Memory Game", SwingConstants.CENTER);
        memory.setFont(new Font("Courier New", Font.BOLD, 25));
        memory.setForeground(Color.RED);
        memory.setAlignmentX(Component.CENTER_ALIGNMENT);
        memoryPanel.setBackground(Color.BLUE);
        memoryPanel.add(memory, BorderLayout.NORTH);
        int y = 80;
        if (memoryleaderboard.size() < 10) {
            for (int i = 0; i < memoryleaderboard.size(); i++) {
                JLabel label = new JLabel();
                label.setText((i+1) + "."+ " Name: " + memorynames.get(i) + " Rounds Completed: " + memoryleaderboard.get(i).getRounds_completed());
                label.setFont(new Font("Courier New", Font.BOLD, 20));
                label.setForeground(Color.BLACK.brighter());
                label.setBounds(750, y, 25, 25);
                label.setAlignmentX(Component.CENTER_ALIGNMENT);
                memoryPanel.add(label);
                y += 50;
            }
        } else {
            for (int i = 0; i < 10; i++) {
                JLabel label = new JLabel();
                label.setText((i+1) + "." + " Name: " + memorynames.get(i) + " Rounds Completed: " + memoryleaderboard.get(i).getRounds_completed());
                label.setFont(new Font("Courier New", Font.BOLD, 20));
                label.setForeground(Color.BLACK.brighter());
                label.setBounds(750, y, 25, 25);
                label.setAlignmentX(Component.CENTER_ALIGNMENT);
                memoryPanel.add(label);
                y += 50;
            }
        }
        memoryPanel.revalidate();
        memoryPanel.repaint();
    }

    public void setclickerLeaderboard() {
        clickerPanel.removeAll();
        clickerPanel.setLayout(new BoxLayout(clickerPanel, BoxLayout.Y_AXIS));
        JLabel clicker = new JLabel("Clicker Game", SwingConstants.CENTER);
        clicker.setFont(new Font("Courier New", Font.BOLD, 25));
        clicker.setForeground(Color.YELLOW);
        clicker.setAlignmentX(Component.CENTER_ALIGNMENT);
        clickerPanel.setBackground(Color.GREEN);
        clickerPanel.add(clicker, BorderLayout.NORTH);
        int y = 80;
        if (clickerleaderboard.size() < 10) {
            for (int i = 0; i < clickerleaderboard.size(); i++) {
                JLabel label = new JLabel();
                label.setText((i+1) + "." + " Name: " + clickernames.get(i) + " Buttons Clicked: " + clickerleaderboard.get(i).getButtons_clicked());
                label.setFont(new Font("Courier New", Font.BOLD, 20));
                label.setForeground(Color.BLACK.brighter());
                label.setBounds(250, y, 25, 25);
                label.setAlignmentX(Component.CENTER_ALIGNMENT);
                clickerPanel.add(label);
                y += 50;
            }
        } else {
            for (int i = 0; i < 10; i++) {
                JLabel label = new JLabel();
                label.setText((i+1) + "." + " Name: " + clickernames.get(i) + " Buttons Clicked: " + clickerleaderboard.get(i).getButtons_clicked());
                label.setFont(new Font("Courier New", Font.BOLD, 20));
                label.setForeground(Color.BLACK.brighter());
                label.setBounds(250, y, 100, 25);
                label.setAlignmentX(Component.CENTER_ALIGNMENT);
                clickerPanel.add(label);
                y += 50;
            }
        }
        clickerPanel.revalidate();
        clickerPanel.repaint();
    }

    public void createLeaderboard() {
        sortMemoryLeaderboard();
        sortClickerLeaderboard();
        setmemoryLeaderboard();
        setclickerLeaderboard();
    }

    public void sortMemoryLeaderboard() {
        for (int i = memoryleaderboard.size() - 1; i >= 0; i--) {
            if (memoryleaderboard.get(i).getRounds_completed() == 0) {
                memoryleaderboard.remove(i);
                memorynames.remove(i);
            }
        }
        for (int i = 0; i < memoryleaderboard.size() - 1; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < memoryleaderboard.size(); j++) {
                if (memoryleaderboard.get(j).getRounds_completed() > memoryleaderboard.get(maxIndex).getRounds_completed()) {
                    maxIndex = j;
                }
            }
            MemoryGame temp = memoryleaderboard.get(maxIndex);
            memoryleaderboard.set(maxIndex, memoryleaderboard.get(i));
            memoryleaderboard.set(i, temp);
            String temps = memorynames.get(maxIndex);
            memorynames.set(maxIndex, memorynames.get(i));
            memorynames.set(i, temps);
        }
    }

    public void sortClickerLeaderboard() {
        for (int i = clickerleaderboard.size() - 1; i >= 0; i--) {
            if (clickerleaderboard.get(i).getButtons_clicked() == 0) {
                clickerleaderboard.remove(i);
                clickernames.remove(i);
            }
        }

        for (int i = 1; i < clickerleaderboard.size(); i++) {
            ClickerGame temp = clickerleaderboard.get(i);
            String tempName = clickernames.get(i);
            int j = i - 1;

            while (j >= 0 && clickerleaderboard.get(j).getButtons_clicked() < temp.getButtons_clicked()) {
                clickerleaderboard.set(j + 1, clickerleaderboard.get(j));
                clickernames.set(j + 1, clickernames.get(j));
                j--;
            }
            clickerleaderboard.set(j + 1, temp);
            clickernames.set(j + 1, tempName);
        }
    }

    public void updateLeaderboard(ArrayList<MemoryGame> memoryleaderboard, ArrayList<ClickerGame> clickerleaderboard, ArrayList<String> memorynames, ArrayList<String> clickernames) {
        this.memoryleaderboard = memoryleaderboard;
        this.clickerleaderboard = clickerleaderboard;
        this.memorynames = memorynames;
        this.clickernames = clickernames;
        createLeaderboard();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == home) {
            dispose();
        }
    }
}
