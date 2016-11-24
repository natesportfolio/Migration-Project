package mp.gfx;

import javax.swing.*;
import java.awt.*;
import java.math.BigInteger;

public class AnimatedLine {

    int x, y, x2, y2;
    Graphics2D g;

    public AnimatedLine(int x, int y, int x2, int y2, Graphics2D g) {
        this.x = x;
        this.y = y;
        this.x2 = x2;
        this.y2 = y2;
        this.g = g;

        animate();
    }

    public void animate() {
        final int[] usefulData = {x2 - x, y2 - y, (x2 - x) / gcdIt(x2 - x, y2 - y), (y2 - y) / gcdIt(x2 - x, y2 - y), 0, 0};

        Timer timer = new Timer(10, null);
        timer.addActionListener(e -> {
            if (usefulData[4] == usefulData[0] && usefulData[5] == usefulData[1]) {
                timer.stop();
            } else {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setStroke(new BasicStroke(10));
                g2.setColor(new Color(176, 41, 47));
                g2.drawLine(x + usefulData[4], y + usefulData[5], (x + usefulData[4]) + usefulData[2], (y + usefulData[5]) + usefulData[3]);
                g2.dispose();

                usefulData[4] += usefulData[2];
                usefulData[5] += usefulData[3];
            }
        });

        timer.start();
    }

    public int gcdIt(int i, int j) {
        return (BigInteger.valueOf(i).gcd(BigInteger.valueOf(j))).intValue();
    }

}
