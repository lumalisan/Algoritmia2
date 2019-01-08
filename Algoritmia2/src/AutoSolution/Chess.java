package AutoSolution;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import static AutoSolution.QueenChess.size;
import static AutoSolution.QueenChess.createCells;
import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author Izar Castorina, Juanjo Torres, Lisandro Rocha
 */
public class Chess extends JPanel {

    public static boolean show = false;
    static int pos = 0;

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

        Thread t = new Thread() {
            @Override
            public void run() {
                try {
                    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

                    System.out.print("Insertar tamaño del tablero: ");
                    int tam = Integer.parseInt(br.readLine());

                    QueenChess.size = tam;

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
                        results.setSize(new Dimension(300, 260));
                        results.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        results.setLocationRelativeTo(null);
                        results.setAlwaysOnTop(true);

                        

                        System.out.println("DEBUG ARRAYL SIZE: " + QueenChess.solutions_matrix.size());
                        QueenChess.table = QueenChess.solutions_matrix.get(pos);

                        results.addKeyListener(new KeyListener() {

                            public void keyPressed(KeyEvent e) {

                                int code = e.getKeyCode();
                                if (pos < QueenChess.solutions_matrix.size()-1 && code == KeyEvent.VK_ENTER) {
                                    pos++;
                                    QueenChess.table = QueenChess.solutions_matrix.get(pos);
                                }
                                if (code == KeyEvent.VK_R)
                                    pos = 0;
                                    QueenChess.table = QueenChess.solutions_matrix.get(pos);

                            }

                            @Override
                            public void keyTyped(KeyEvent e) {
                            }

                            @Override
                            public void keyReleased(KeyEvent e) {
                            }

                        });

                        System.out.println("IMPRIMIENDO TABLAS ALMACENADAS EN ARRAYLIST");
                        for (int i = 0; i < QueenChess.solutions_matrix.size(); i++) {
                            for (int j = 0; j < QueenChess.table.length; j++) {
                                for (int k = 0; k < QueenChess.table.length; k++) {
                                    System.out.print(QueenChess.solutions_matrix.get(i)[j][k].toString() + "\n");
                                }
                            }
                            System.out.println("");
                        }

                    }

                } catch (IOException ex) {
                    System.out.println("Error en la lectura por teclado");
                    System.exit(1);
                } catch (NumberFormatException e) {
                    System.out.println("Error en la introducción de los números");
                    System.exit(1);
                }
            }

        };
        t.start();

    }
}
