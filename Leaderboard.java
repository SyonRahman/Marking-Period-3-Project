import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Leaderboard extends JFrame implements ActionListener {
    final private JButton home = new JButton("Home");
    private ArrayList<Integer> leaderboard = new ArrayList<Integer>();
    private ArrayList<Integer> rounds = new ArrayList<Integer>();
    private String name;

    public Leaderboard(ArrayList<Integer> type, String name) {
        leaderboard = type;
        this.name = name;
        createComponents();
    }

    public Leaderboard() {
        createComponents();
    }

    public void createComponents() {
        setVisible(true);
        setResizable(false);
        setTitle("Leaderboard");
        getContentPane().setBackground(Color.BLACK);
        setLayout(null);
        setSize(1000, 1000);
        setLocation(500, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        JLabel title = new JLabel("Leaderboard", SwingConstants.CENTER);
        title.setFont(new Font("Courier New", Font.BOLD, 30));
        title.setBounds(0, 20, getWidth(), 50);
        title.setForeground(Color.WHITE);
        this.add(title);

        home.setFont(new Font("Courier New", Font.BOLD, 20));
        home.setBounds(50, 50, 100, 100);
        home.setForeground(Color.BLACK);
        home.setBackground(Color.WHITE);
        home.addActionListener(this);
        this.add(home);



        setLeaderboard();
    }

    public void setLeaderboard() {
        int y = 80;
        if (leaderboard.size() < 10) {
            for (int i = 0; i < leaderboard.size(); i++) {
                JLabel label = new JLabel();
                label.setText(i + ": " + name + ": " + leaderboard.get(i));
                label.setFont(new Font("Comic Sans", Font.BOLD, 15));
                label.setBounds(20, y, 15, 15);
                label.setForeground(Color.WHITE);
                this.add(label);
                y += 80;
            }
        } else {
            for (int i = 0; i < 10; i++) {
                JLabel label = new JLabel();
                label.setText(i + ": " + name + ": " + leaderboard.get(i));
                label.setFont(new Font("Comic Sans", Font.BOLD, 12));
                label.setBounds(20, y, 15, 15);
                label.setForeground(Color.WHITE);
                this.add(label);
                y += 80;
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == home) {
            new Introduction();
            setVisible(false);
        }
    }
}
