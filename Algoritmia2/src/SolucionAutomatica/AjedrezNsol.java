package SolucionAutomatica;

import static SolucionAutomatica.AjedrezReinasNsol.crearcasillas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import static SolucionAutomatica.AjedrezReinasNsol.size;
import static SolucionAutomatica.AjedrezReinasNsol.solutions;

public class AjedrezNsol extends JPanel {

    public static boolean show = false;

    @Override
    public void paint(Graphics g) {
        
        ImageIcon imagen = new ImageIcon(new ImageIcon(getClass().getResource("chess.png")).getImage());
        g.fillRect(0, 0, size * 50, size * 50);

        for (int i = 0; i <= (size * 50); i += 100) {
            for (int j = 0; j <= (size * 50); j += 100) {
                g.clearRect(i, j, 50, 50);
            }
        }

        for (int i = 50; i <= (size - 1) * 50; i += 100) {
            for (int j = 50; j <= (size - 1) * 50; j += 100) {
                g.clearRect(i, j, 50, 50);
            }
        }

        int x = 0, y = 0;

        for (int i = 0; i <= (size - 1) * 50; i += 50) {
            for (int j = 0; j <= (size - 1) * 50; j += 50) {
                if (AjedrezReinasNsol.table[x][y].getN() == 1) {
                    g.drawImage(imagen.getImage(), i, j, 50, 50, null);
                }
                y++;
            }
            y = 0;
            x++;
        }
        x = 0;
        if (show == true) {
            g.setColor(Color.RED);
            Font f2 = new Font("Papyrus", Font.PLAIN, 30);
            g.setFont(f2);
            g.drawString("Number of Solutions", (size / 2 * 50 - 85), (size / 2 * 50) - 20);
            g.setColor(Color.RED);
            Font f = new Font("Comic Sans MS", Font.BOLD, 90);
            g.setFont(f);
            g.drawString(solutions + "", (size / 2 * 50 - 85), (size / 2 * 50) + 60);
        }
        repaint();
    }

    public static void main(String[] args) {
        crearcasillas();
        JFrame frame = new JFrame();
        frame.setSize((int) size * 50 + 18, size * 50 + 47);
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
