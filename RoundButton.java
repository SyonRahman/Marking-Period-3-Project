import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
public class RoundButton extends JButton {


    private Color lightcolor;
    private Color darkcolor;
    private Color borderColor;
    private boolean litUp;


    public RoundButton(Color fillColor, Color borderColor, Color armedColor) {
        super();
        darkcolor = fillColor;
        lightcolor = armedColor;
        this.borderColor = borderColor;
        setContentAreaFilled(false);
    }

    public RoundButton(Color fillColor, Color armedColor) {
        super();
        darkcolor = fillColor;
        lightcolor = armedColor;
        borderColor = Color.WHITE;
        setContentAreaFilled(false);
        setPreferredSize(new Dimension(200, 200));
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (litUp) {
            g.setColor(lightcolor);
        } else {
            g.setColor(darkcolor);
        }
        g.fillOval(0, 0, getWidth(), getHeight());
        super.paintComponent(g);
    }

    public void changecolor() {
        litUp = !litUp;
        repaint();
    }

    @Override
    public void paintBorder(Graphics g) {
        Graphics2D g22 = (Graphics2D) g;
        g.setColor(borderColor);
        g22.setStroke(new BasicStroke(10));
        g22.drawOval(5, 5, getWidth() - 10, getHeight() - 10);
    }
}
