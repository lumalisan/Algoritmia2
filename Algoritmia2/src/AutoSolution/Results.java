/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AutoSolution;

import static AutoSolution.QueenChess.size;
import static AutoSolution.QueenChess.solutions;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Izar
 */
public class Results extends JPanel {
        
    @Override
    public void paint(Graphics g) {
        
            Dimension d = this.getSize();
                                     
            g.setColor(Color.BLACK);
            Font f = new Font("Comic Sans MS", Font.BOLD, 90);
            g.setFont(f);
            g.drawString(solutions + "", 0, d.height/2 + 40);
           
            repaint();
            
    }

    
}
