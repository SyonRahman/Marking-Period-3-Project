import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
public class RoundButton extends JButton  {
    private Color borderColor;
    private Color fillColor;
    private int xpos;
    private int ypos;

    public RoundButton(Color fillColor, Color borderColor, int xpos, int ypos) {
        super();
        this.borderColor = borderColor;
        this.fillColor = fillColor;
        this.xpos = xpos;
        this.ypos = ypos;
        // Make the button transparent
        setContentAreaFilled(false);
        // Set preferred size to make it a circle
        setPreferredSize(new Dimension(100, 100));
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

    Shape shape;
    public boolean contains(int x, int y) {
        if (shape == null || !shape.getBounds().equals(getBounds())) {
            shape = new Ellipse2D.Float(0, 0, getWidth(), getHeight());
        }
        return shape.contains(x, y);
    }


}
