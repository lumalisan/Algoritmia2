package AutoSolution;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import static AutoSolution.QueenChess.size;
import static AutoSolution.QueenChess.createCells;
import java.awt.Dimension;

/**
 *
 * @author Izar Castorina, Juanjo Torres, Lisandro Rocha
 */
public class Chess extends JPanel {

    public static boolean show = false;

    @Override
    public void paint(Graphics g) {
        
        ImageIcon imagen = new ImageIcon("chess.png");
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
                if (QueenChess.table[x][y].getNum() == 1) {
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
        createCells();
        JFrame frame = new JFrame();
        frame.setSize((int) size * 50, (size * 50) + 21);
        frame.getContentPane().add(new Chess());
        frame.setLocationRelativeTo(null);
        frame.setBackground(Color.LIGHT_GRAY);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setAlwaysOnTop(true);
        QueenChess Aj = new QueenChess();
        Aj.setVisible(true);
        
        if (show == true) {
            System.out.println("Showing results...");
            JFrame results = new JFrame("Results");
            results.setContentPane(new Results());
             
            results.setVisible(true);
            results.setSize(new Dimension(300,260));
            results.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            results.setLocationRelativeTo(null);
            results.setAlwaysOnTop(true);
        }
    }

}
