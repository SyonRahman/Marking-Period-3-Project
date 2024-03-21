import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
public class RoundButton extends JButton  {


    private Color lightcolor;
    private Color darkcolor;
    private Color borderColor;


    public RoundButton(Color fillColor, Color borderColor, Color armedColor) {
        super();
        darkcolor = fillColor;
        lightcolor = armedColor;
        this.borderColor = borderColor;
        // Make the button transparent
        setContentAreaFilled(false);
        // Set preferred size to make it a circle
        setPreferredSize(new Dimension(200, 200));
    }

    public RoundButton(Color fillColor, Color armedColor) {
        super();
        darkcolor = fillColor;
        lightcolor = armedColor;
        this.borderColor = Color.WHITE;
        setContentAreaFilled(false);
        setPreferredSize(new Dimension(200, 200));
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (getModel().isArmed()) {
            g.setColor(lightcolor);
        } else {
            g.setColor(darkcolor);
        }
        g.fillOval(0, 0, getWidth(), getHeight());
        super.paintComponent(g);
    }

    public void changecolor() {
        Color temp = darkcolor;
        darkcolor = lightcolor;
        lightcolor = temp;
        repaint();
    }

    @Override
    public void paintBorder(Graphics g) {
        Graphics2D g22 = (Graphics2D) g;
        g.setColor(borderColor);
        g22.setStroke(new BasicStroke(10));
        g22.drawOval(5, 5, getWidth() - 10, getHeight() - 10);
    }

    public Color getLightcolor() {
        return lightcolor;
    }

    public Color getDarkcolor() {
        return darkcolor;
    }



}
