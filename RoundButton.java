import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
public class RoundButton extends JButton  {
    private Color borderColor;
    private Color fillColor;

    public RoundButton(Color fillColor, Color borderColor) {
        super();
        this.borderColor = borderColor;
        this.fillColor = fillColor;
        // Make the button transparent
        setContentAreaFilled(false);
        // Set preferred size to make it a circle
        setPreferredSize(new Dimension(200, 200));
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (getModel().isArmed()) {
            g.setColor(Color.magenta);
        } else {
            g.setColor(fillColor);
        }
        g.fillOval(0, 0, getSize().width - 1, getSize().height - 1);
        super.paintComponent(g);
    }

    @Override
    public void paintBorder(Graphics g) {
        Graphics2D g22 = (Graphics2D) g;
        g.setColor(borderColor);
        g22.setStroke(new BasicStroke(5));
        g.drawOval(0, 0, getSize().width - 1, getSize().height - 1);
    }



}
