/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SolucionAutomatica;

import java.awt.Graphics;
import static java.lang.System.exit;
import javax.swing.JPanel;

public class AjedrezReinasNsol extends JPanel {

    public static int solutions = 0;
    private boolean solencontrada = false;
    public static int size = 11;
    public static int empezarx = 0; //fila
    public static int empezary = 0; //columna

    private static int Ndamas = 0;
    public static Casilla[][] table = new Casilla[size][size];

    public AjedrezReinasNsol() {

        crearcasillas();

        metodebacktracking(empezary, empezarx);

        System.out.println("Numero total de soluciones es : " + solutions);

        AjedrezNsol.show = true;
    }

    public void metodebacktracking(int columna, int fila) {

        columna--;
        while (columna != size - 1) {

            columna++;

            if (esvalido(columna, fila)) {
                meterdama(columna, fila);
                if (Ndamas == size) {
                    solutions++;
                    quitardama(columna, fila);
                } else {

                    metodebacktracking(0, fila + 1);

                    quitardama(columna, fila);

                }
            }

        }
        solencontrada = false;
    }

    public boolean Damaenestafila(int fila) {
        for (int l = 0; l < size; l++) {
            if (table[l][fila].getN() == 1) {
                return true;
            }
        }
        return false;
    }

    public void meterdama(int i, int j) {
        table[i][j].setN(1); //colocar dama
        Ndamas++;
        actualizar();
    }

    public void quitardama(int i, int j) {
        table[i][j].setN(0); //colocar dama
        Ndamas--;
        actualizar();
    }

    public void printeartablero() {
        for (int k = 0; k < size; k++) {
            for (int l = 0; l < size; l++) {
                System.out.println(table[k][l]);
            }
        }

    }

    public void actualizar() {

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {

                if (table[i][j].getN() == 1) {
                    int ii = i;
                    int jj = j;
                    table[i][j].setValida(false);
                    //derecha
                    while (i + 1 != size) {
                        i++;
                        table[i][j].setValida(false);
                    }
                    i = ii;

                    //izquierda
                    while (i - 1 != -1) {

                        i--;
                        table[i][j].setValida(false);
                    }
                    i = ii;

                    //arriba
                    while (j - 1 != -1) {

                        j--;
                        table[i][j].setValida(false);
                    }
                    j = jj;
                    //abajo
                    while (j + 1 != size) {

                        j++;
                        table[i][j].setValida(false);
                    }
                    j = jj;
                    //Diagonal derecha arriba
                    while (i + 1 != size && j - 1 != -1) {

                        i++;
                        j--;
                        table[i][j].setValida(false);
                    }
                    i = ii;
                    j = jj;
                    //Diagonal derecha abajo
                    while (i + 1 != size && j + 1 != size) {

                        i++;
                        j++;
                        table[i][j].setValida(false);
                    }
                    i = ii;
                    j = jj;
                    //Diagonal izquierda arriba
                    while (i - 1 != -1 && j - 1 != -1) {

                        i--;
                        j--;
                        table[i][j].setValida(false);
                    }
                    i = ii;
                    j = jj;
                    //Diagonal izquierda abajo
                    while (i - 1 != -1 && j + 1 != size) {

                        i--;
                        j++;
                        table[i][j].setValida(false);
                    }
                    i = ii;
                    j = jj;
                }
            }
        }

    }

    public boolean esvalido(int i, int j) {

        int ii = i;
        int jj = j;

        if (table[i][j].getN() == 1) {
            return false;
        }
        //derecha
        while (i + 1 != size) {
            i++;
            if (table[i][j].getN() == 1) {
                return false;
            }
        }
        i = ii;

        //izquierda
        while (i - 1 != -1) {

            i--;
            if (table[i][j].getN() == 1) {
                return false;
            }
        }
        i = ii;

        //arriba
        while (j - 1 != -1) {

            j--;
            if (table[i][j].getN() == 1) {
                return false;
            }
        }
        j = jj;
        //abajo
        while (j + 1 != size) {

            j++;
            if (table[i][j].getN() == 1) {
                return false;
            }
        }
        j = jj;
        //Diagonal derecha arriba
        while (i + 1 != size && j - 1 != -1) {

            i++;
            j--;
            if (table[i][j].getN() == 1) {
                return false;
            }
        }
        i = ii;
        j = jj;
        //Diagonal derecha abajo
        while (i + 1 != size && j + 1 != size) {

            i++;
            j++;
            if (table[i][j].getN() == 1) {
                return false;
            }
        }
        i = ii;
        j = jj;
        //Diagonal izquierda arriba
        while (i - 1 != -1 && j - 1 != -1) {

            i--;
            j--;
            if (table[i][j].getN() == 1) {
                return false;
            }
        }
        i = ii;
        j = jj;
        //Diagonal izquierda abajo
        while (i - 1 != -1 && j + 1 != size) {

            i--;
            j++;
            if (table[i][j].getN() == 1) {
                return false;
            }

        }
        return true;

    }

    public static void crearcasillas() {
        for (int i = 0; i < size; i += 1) {
            for (int j = 0; j < size; j += 1) {
                Casilla casilla = new Casilla();
                table[i][j] = casilla;
            }
        }

    }

    public void paint(Graphics g) {

    }

}
