package ManualSolution;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import static ManualSolution.QueenChess.size;
import static ManualSolution.QueenChess.y;
import static ManualSolution.QueenChess.x;
import static ManualSolution.QueenChess.createCells;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Izar Castorina, Juanjo Torres, Lisandro Rocha
 */
public class Chess extends JPanel {
    
    public static void main(String[] args) {
        
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            
            System.out.print("Insertar tamaño del tablero: ");
            int tam = Integer.parseInt(br.readLine());
            System.out.print("Insertar coordenada X de inicio: ");
            int xpos = Integer.parseInt(br.readLine());
            System.out.print("Insertar coordenada Y de inicio: ");
            int ypos = Integer.parseInt(br.readLine());
            
            QueenChess.x = xpos;
            QueenChess.y = ypos;
            QueenChess.size = tam;
            
            cont();
            
        } catch (IOException ex) {
            System.out.println("Error en la lectura por teclado");
            System.exit(1);
        } catch (NumberFormatException e) {
            System.out.println("Error en la introducción de los números");
            System.exit(1);
        }
    }
    
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
        g.setColor(Color.YELLOW);
        g.fillRect(y * 50, x * 50, 50, 50);
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
    
    public static void cont() {
        System.out.println("DEBUG SIZE: " + QueenChess.size);
        createCells();
        JFrame frame = new JFrame();
        frame.setSize((int) size * 50, (size * 50) + 21);
        frame.getContentPane().add(new Chess());
        frame.setLocationRelativeTo(null);
        frame.setBackground(Color.LIGHT_GRAY);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setAlwaysOnTop(true);
        QueenChess ex = new QueenChess();
        ex.setVisible(true);
    }

}
