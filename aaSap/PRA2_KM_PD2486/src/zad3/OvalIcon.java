package zad3;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;

import javax.swing.Icon;

public class OvalIcon implements Icon {
    private int width;
    private int height;
    private Color color;

    public OvalIcon(Color color) {

        this.width  = 10;
        this.height = 10;
        this.color  = (color == null) ? Color.BLACK : color;
    }
    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        Color temp = g.getColor();
        g.setColor(color);
        g.fillOval(x, y, getIconWidth(), getIconHeight());
        g.setColor(temp);
    }
    @Override
    public int getIconWidth() {
        return width;
    }
    @Override
    public int getIconHeight() {
        return height;
    }
}
