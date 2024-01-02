import java.awt.*;
import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MyPaint extends JFrame {
    private int startX, startY, endX, endY;

    public MyPaint() {
        setTitle("Simple Paint App");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // マウスリスナーを追加
        addMouseListener(new MyMouseListener());
        addMouseMotionListener(new MyMouseListener());

        // フレームを表示
        setVisible(true);
    }

    private class MyMouseListener extends MouseAdapter {
        @Override
        public void mousePressed(MouseEvent e) {
            startX = e.getX();
            startY = e.getY();
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            endX = e.getX();
            endY = e.getY();
            repaint(); // 描画の更新を要求
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawLine(startX, startY, endX, endY);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MyPaint::new);
    }
}