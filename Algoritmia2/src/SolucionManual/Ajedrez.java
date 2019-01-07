package SolucionManual;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import static SolucionManual.AjedrezReinas.crearcasillas;
import static SolucionManual.AjedrezReinas.empezarx;
import static SolucionManual.AjedrezReinas.empezary;
import static SolucionManual.AjedrezReinas.tamaño;

public class Ajedrez extends JPanel {

    @Override
    public void paint(Graphics g) {
        ImageIcon imagen = new ImageIcon(new ImageIcon(getClass().getResource("chess.png")).getImage());
        g.fillRect(0, 0, tamaño * 50, tamaño * 50);

        for (int i = 0; i <= (tamaño * 50); i += 100) {
            for (int j = 0; j <= (tamaño * 50); j += 100) {
                g.clearRect(i, j, 50, 50);
            }
        }

        for (int i = 50; i <= (tamaño - 1) * 50; i += 100) {
            for (int j = 50; j <= (tamaño - 1) * 50; j += 100) {
                g.clearRect(i, j, 50, 50);
            }
        }
        g.setColor(Color.green);
        g.fillRect(empezary * 50, empezarx * 50, 50, 50);
        int x = 0, y = 0;

        for (int i = 0; i <= (tamaño - 1) * 50; i += 50) {
            for (int j = 0; j <= (tamaño - 1) * 50; j += 50) {
                if (AjedrezReinas.tablero[x][y].getN() == 1) {
                    g.drawImage(imagen.getImage(), i, j, 50, 50, null);
                }
                y++;
            }
            y = 0;
            x++;
        }
        x = 0;

        repaint();
    }

    public static void main(String[] args) {
        crearcasillas();
        JFrame frame = new JFrame();
        frame.setSize((int) tamaño * 50 + 18, tamaño * 50 + 47);
        frame.getContentPane().add(new Ajedrez());
        frame.setLocationRelativeTo(null);
        frame.setBackground(Color.LIGHT_GRAY);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        Ajedrez e = new Ajedrez();
        e.Start();
    }

    public void Start() {
        AjedrezReinas Aj = new AjedrezReinas();
        Aj.setVisible(true);

    }

}
