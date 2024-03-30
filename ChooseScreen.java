import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChooseScreen extends JFrame implements ActionListener {


    private JButton memory = new JButton("Memory");
    private JButton reflexes = new JButton("Reflexes");
    private String name;

    public ChooseScreen(String name) {
        this.name = name;
        createComponenets();
    }
    public void createComponenets() {
        this.setLayout(new GridLayout(0, 1));
        memory.setBounds(50, 50, 100, 50);
        reflexes.setBounds(250, 50, 100, 50);
        memory.setFont(new Font("Courier New", Font.BOLD, 50));
        reflexes.setFont(new Font("Courier New", Font.BOLD, 50));
        memory.setForeground(Color.RED);
        reflexes.setForeground(Color.YELLOW);
        memory.setBackground(Color.BLUE);
        reflexes.setBackground(Color.GREEN);
        memory.addActionListener(this);
        reflexes.addActionListener(this);



        setTitle("Choosing Screen");
        setSize(1000, 1000);
        setLocation(500, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.add(memory);
        this.add(reflexes);
        setResizable(false);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == memory) {
            new MemoryGame();
            setVisible(false);
        } else {
            if (e.getSource() == reflexes) {
                new ClickerGame();
                setVisible(false);
            }
        }
    }
}
