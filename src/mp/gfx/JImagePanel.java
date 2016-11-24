package mp.gfx;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class JImagePanel extends JPanel {

    private Image img = null;
    private Position position = Position.CENTER;

    public enum Position {
        STRETCH,
        CENTER,
        FIT,
        FILL,
        NONE
    }

    public JImagePanel() {

    }

    public JImagePanel(String img) {
        setBackgroundImage(img);
    }

    public JImagePanel(Image img) {
        setBackgroundImage(img);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        g2.setColor(getBackground());
        g2.fillRect(0, 0, getWidth(), getHeight());

        g2.setComposite(AlphaComposite.Src);
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        if (img != null) {
            if (position.equals(Position.STRETCH)) {
                g2.drawImage(img, 0, 0, getWidth(), getHeight(), null);
            } else if (position.equals(Position.FILL) || position.equals(Position.FIT)) {
                double scaleFactor = getScaleFactor(new Dimension(img.getWidth(null), img.getHeight(null)));
                int scaleWidth = (int) Math.round(img.getWidth(null) * scaleFactor);
                int scaleHeight = (int) Math.round(img.getHeight(null) * scaleFactor);

                g2.drawImage(scaleImage(img, scaleWidth, scaleHeight, getBackground()), (getWidth() - scaleWidth) / 2, (getHeight() - scaleHeight) / 2, scaleWidth, scaleHeight, null);
            } else if (position.equals(Position.CENTER)) {
                g2.drawImage(img, (getWidth() - img.getWidth(null)) / 2, (getHeight() - img.getHeight(null)) / 2, null);
            }
        }
    }

    public void setBackgroundImage(String img) {
        setBackgroundImage(new ImageIcon(img).getImage());
    }

    public void setBackgroundImage(Image img) {
        this.img = img;

        Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));

        setPreferredSize(size);
        setMinimumSize(size);
        setMaximumSize(size);
        setSize(size);

        revalidate();
        repaint();
    }

    public static double getScaleFactor(Dimension dim) {
        return getScaleFactor(dim.width, dim.height);
    }

    public static double getScaleFactor(int masterSize, int targetSize) {
        return (double) targetSize / (double) masterSize;
    }

    public double getScaleFactor(Dimension original, Dimension targetSize) {
        double scale = 1d;

        if (original != null && targetSize != null)  {
            double scaleWidth = getScaleFactor(original.width, targetSize.width);
            double scaleHeight = getScaleFactor(original.height, targetSize.height);

            if (position.equals(Position.FIT)) {
                scale = Math.min(scaleHeight, scaleWidth);
            } else if (position.equals(Position.FILL)) {
                scale = Math.max(scaleHeight, scaleWidth);
            }
        }

        return scale;
    }

    public BufferedImage scaleImage(Image img, int width, int height, Color background) {
        BufferedImage newImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = newImage.createGraphics();

        try {
            g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
            g.setBackground(background);
            g.clearRect(0, 0, width, height);
            g.drawImage(img, 0, 0, width, height, null);
        } finally {
            g.dispose();
        }

        return newImage;
    }

    public void setBackgroundImagePosition(String pos) {
        if ("Stretch".equals(pos)) setBackgroundImagePosition(Position.STRETCH);
        else if ("Center".equals(pos)) setBackgroundImagePosition(Position.CENTER);
        else if ("Fit".equals(pos)) setBackgroundImagePosition(Position.FIT);
        else if ("Fill".equals(pos)) setBackgroundImagePosition(Position.FILL);
        else if ("None".equals(pos)) setBackgroundImagePosition(Position.NONE);
    }

    public void setBackgroundImagePosition(Position pos) {
        position = pos;
        revalidate();
        repaint();
    }
}
