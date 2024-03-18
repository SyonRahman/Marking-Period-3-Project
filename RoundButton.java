import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
public class RoundButton extends JButton  {

    private Color originalColor;
    private Color borderColor;
    private Color armedColor;
    private Color fillColor;

    public RoundButton(Color fillColor, Color borderColor, Color armedColor) {
        super();
        this.originalColor = fillColor;
        this.armedColor = armedColor;
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
            g.setColor(armedColor);
        } else {
            g.setColor(fillColor);
        }
        g.fillOval(0, 0, getWidth(), getHeight());
        super.paintComponent(g);
    }

    public void changecolor(Color fillcolor, Color armedColor) {
        this.fillColor = fillcolor;
        this.armedColor = armedColor;
        repaint();
    }

    @Override
    public void paintBorder(Graphics g) {
        Graphics2D g22 = (Graphics2D) g;
        g.setColor(borderColor);
        g22.setStroke(new BasicStroke(10));
        g22.drawOval(5, 5, getWidth() - 8, getHeight() - 8);
    }

    public Color getOriginalColor() {
        return originalColor;
    }



}
