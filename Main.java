import javax.swing.*;
public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("New Frame");
        frame.setSize(300, 300);
        JLabel label = new JLabel("Title");
        label.setSize(1000, 1000);
        frame.add(label);
        frame.setVisible(true);

    }

}
