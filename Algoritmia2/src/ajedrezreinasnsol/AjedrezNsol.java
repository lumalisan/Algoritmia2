package ajedrezreinasnsol;

import static ajedrezreinasnsol.AjedrezReinasNsol.crearcasillas;
import static ajedrezreinasnsol.AjedrezReinasNsol.tamaño;
import static ajedrezreinasnsol.AjedrezReinasNsol.totalsoluciones;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class AjedrezNsol extends JPanel {

    public static boolean mostrar = false;

    @Override
    public void paint(Graphics g) {
        ImageIcon imagen = new ImageIcon(new ImageIcon(getClass().getResource("dama.png")).getImage());
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

        int x = 0, y = 0;

        for (int i = 0; i <= (tamaño - 1) * 50; i += 50) {
            for (int j = 0; j <= (tamaño - 1) * 50; j += 50) {
                if (AjedrezReinasNsol.tablero[x][y].getN() == 1) {
                    g.drawImage(imagen.getImage(), i, j, 50, 50, null);
                }
                y++;
            }
            y = 0;
            x++;
        }
        x = 0;
        if (mostrar == true) {
            g.setColor(Color.BLUE);
            Font f2 = new Font("Arial", 22, 22);
            g.setFont(f2);
            g.drawString("Numero de soluciones", (tamaño / 2 * 50 - 85), (tamaño / 2 * 50) - 20);
            g.setColor(Color.RED);
            Font f = new Font("Arial", 100, 100);
            g.setFont(f);
            g.drawString(totalsoluciones + "", (tamaño / 2 * 50 - 85), (tamaño / 2 * 50) + 60);
        }
        repaint();
    }

    public static void main(String[] args) {
        crearcasillas();
        JFrame frame = new JFrame();
        frame.setSize((int) tamaño * 50 + 18, tamaño * 50 + 47);
        frame.getContentPane().add(new AjedrezNsol());
        frame.setLocationRelativeTo(null);
        frame.setBackground(Color.LIGHT_GRAY);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        AjedrezNsol e = new AjedrezNsol();
        e.Start();
    }

    public void Start() {
        AjedrezReinasNsol Aj = new AjedrezReinasNsol();
        Aj.setVisible(true);

    }

}
