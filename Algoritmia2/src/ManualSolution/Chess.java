package ManualSolution;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import static ManualSolution.QueenChess.size;
import static ManualSolution.QueenChess.y;
import static ManualSolution.QueenChess.x;
import static ManualSolution.QueenChess.createCells;

/**
 *
 * @author Izar Castorina, Juanjo Torres, Lisandro Rocha
 */
public class Chess extends JPanel {
    
    public static void main(String[] args) {
        
        JFrame select_f = new JFrame("Elige la posición de inicio");
        JPanel select_p = new JPanel();
        select_p.setLayout(new BoxLayout(select_p,BoxLayout.Y_AXIS));
        select_f.setSize(280, 220);
        JLabel posx_lab = new JLabel("Coordenada X");
        posx_lab.setHorizontalAlignment(0);
        JLabel posy_lab = new JLabel("Coordenada Y");
        posy_lab.setHorizontalAlignment(0);
        JLabel dim_lab = new JLabel("Tamaño del tablero");
        dim_lab.setHorizontalAlignment(0);
        JTextField posx_tf = new JTextField();
        posx_tf.setAlignmentX(0);
        JTextField posy_tf = new JTextField();
        posy_tf.setAlignmentX(0);
        JTextField dim_tf = new JTextField();
        dim_tf.setAlignmentX(0);
        JSeparator sep = new JSeparator(JSeparator.HORIZONTAL);
        sep.setAlignmentX(0); sep.setMaximumSize(new Dimension(150,5));
        JButton start = new JButton("Inicio");
        start.setAlignmentX(0);
        
        select_p.add(Box.createVerticalStrut(10));
        select_p.add(posx_lab); select_p.add(posx_tf);
        select_p.add(Box.createVerticalStrut(5));
        select_p.add(posy_lab); select_p.add(posy_tf);
        select_p.add(Box.createVerticalStrut(5));
        select_p.add(dim_lab); select_p.add(dim_tf);
        select_p.add(Box.createVerticalStrut(3));
        select_p.add(sep);
        select_p.add(Box.createVerticalStrut(3));
        select_p.add(start);
        select_p.add(Box.createVerticalStrut(3));
        
        select_f.setContentPane(select_p);
        select_f.setLocationRelativeTo(null);
        select_f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        select_f.setResizable(false);
        select_f.setVisible(true);
        
        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("lol");
            }
        });
        
        cont();
        
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
        g.setColor(Color.GREEN);
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
        createCells();
        JFrame frame = new JFrame();
        frame.setSize((int) size * 50 + 18, size * 50 + 47);
        frame.getContentPane().add(new Chess());
        frame.setLocationRelativeTo(null);
        frame.setBackground(Color.LIGHT_GRAY);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        Chess ex = new Chess();
        ex.Start();
    }

    public void Start() {
        QueenChess ex = new QueenChess();
        ex.setVisible(true);
    }

}
