import java.awt.*;
import javax.swing.*;

public class DDALine extends JPanel {

    public void ddaLine(Graphics g, int x1, int y1, int x2, int y2) {
        int dx = x2 - x1;
        int dy = y2 - y1;

        int steps = Math.max(Math.abs(dx), Math.abs(dy));

        float xInc = dx / (float) steps;
        float yInc = dy / (float) steps;

        float x = x1;
        float y = y1;

        for (int i = 0; i <= steps; i++) {
            g.fillRect(Math.round(x), Math.round(y), 2, 2);
            x += xInc;
            y += yInc;
        }
    }

    @Override
    public void paint(Graphics g) {
        ddaLine(g, 50, 50, 250, 200);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("DDA Line Drawing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.add(new DDALine());
        frame.setVisible(true);
    }
}
