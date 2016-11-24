package mp;

import mp.gfx.AnimatedLine;
import mp.gfx.JImagePanel;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;

public class MPPanel extends JImagePanel implements MouseListener {

    public void drawAnimatedLine(int x, int y, int x2, int y2) {
        new AnimatedLine(x, y, x2, y2, (Graphics2D) getGraphics().create());
    }

    public void drawDot(int x, int y) {
        Graphics2D g = (Graphics2D) getGraphics().create();
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setColor(new Color(202, 71, 84));
        g.fillOval(x, y, 15, 15);
        g.dispose();
    }

    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e) {
        Graphics2D g = (Graphics2D) getGraphics().create();
        g.fillOval(e.getX(), e.getY(), 15, 15);
        System.out.println("Mouse X: " + e.getX() + " Mouse Y: " + e.getY());
        g.dispose();
    }

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}

    public MPPanel() {
        addMouseListener(this);

        URL url = null;

        try {
            url = new URL("http://www.frui.co.uk/images/maps/world_map_1960.jpg");
        } catch (MalformedURLException ex) {
            ex.printStackTrace();
        }

        setBackgroundImagePosition(Position.STRETCH);

        try {
            setBackgroundImage(ImageIO.read(url));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void clear(int x, int y, int x2, int y2) {
        Graphics2D g = (Graphics2D) getGraphics().create();
        g.clearRect(x, y, x2, y2);
        g.dispose();

        super.repaint(x, y, x2, y2);
    }

}
