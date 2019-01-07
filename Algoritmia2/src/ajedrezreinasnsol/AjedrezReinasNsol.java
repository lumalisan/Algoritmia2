/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ajedrezreinasnsol;

import java.awt.Graphics;
import static java.lang.System.exit;
import javax.swing.JPanel;

public class AjedrezReinasNsol extends JPanel {

    public static int totalsoluciones = 0;
    private boolean solencontrada = false;
    public static int tamaño = 11;
    public static int empezarx = 0; //fila
    public static int empezary = 0; //columna

    private static int Ndamas = 0;
    public static Casilla[][] tablero = new Casilla[tamaño][tamaño];

    public AjedrezReinasNsol() {

        crearcasillas();

        metodebacktracking(empezary, empezarx);

        System.out.println("Numero total de soluciones es : " + totalsoluciones);

        AjedrezNsol.mostrar = true;
    }

    public void metodebacktracking(int columna, int fila) {

        columna--;
        while (columna != tamaño - 1) {

            columna++;

            if (esvalido(columna, fila)) {
                meterdama(columna, fila);
                if (Ndamas == tamaño) {
                    totalsoluciones++;
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
        for (int l = 0; l < tamaño; l++) {
            if (tablero[l][fila].getN() == 1) {
                return true;
            }
        }
        return false;
    }

    public void meterdama(int i, int j) {
        tablero[i][j].setN(1); //colocar dama
        Ndamas++;
        actualizar();
    }

    public void quitardama(int i, int j) {
        tablero[i][j].setN(0); //colocar dama
        Ndamas--;
        actualizar();
    }

    public void printeartablero() {
        for (int k = 0; k < tamaño; k++) {
            for (int l = 0; l < tamaño; l++) {
                System.out.println(tablero[k][l]);
            }
        }

    }

    public void actualizar() {

        for (int i = 0; i < tamaño; i++) {
            for (int j = 0; j < tamaño; j++) {

                if (tablero[i][j].getN() == 1) {
                    int ii = i;
                    int jj = j;
                    tablero[i][j].setValida(false);
                    //derecha
                    while (i + 1 != tamaño) {
                        i++;
                        tablero[i][j].setValida(false);
                    }
                    i = ii;

                    //izquierda
                    while (i - 1 != -1) {

                        i--;
                        tablero[i][j].setValida(false);
                    }
                    i = ii;

                    //arriba
                    while (j - 1 != -1) {

                        j--;
                        tablero[i][j].setValida(false);
                    }
                    j = jj;
                    //abajo
                    while (j + 1 != tamaño) {

                        j++;
                        tablero[i][j].setValida(false);
                    }
                    j = jj;
                    //Diagonal derecha arriba
                    while (i + 1 != tamaño && j - 1 != -1) {

                        i++;
                        j--;
                        tablero[i][j].setValida(false);
                    }
                    i = ii;
                    j = jj;
                    //Diagonal derecha abajo
                    while (i + 1 != tamaño && j + 1 != tamaño) {

                        i++;
                        j++;
                        tablero[i][j].setValida(false);
                    }
                    i = ii;
                    j = jj;
                    //Diagonal izquierda arriba
                    while (i - 1 != -1 && j - 1 != -1) {

                        i--;
                        j--;
                        tablero[i][j].setValida(false);
                    }
                    i = ii;
                    j = jj;
                    //Diagonal izquierda abajo
                    while (i - 1 != -1 && j + 1 != tamaño) {

                        i--;
                        j++;
                        tablero[i][j].setValida(false);
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

        if (tablero[i][j].getN() == 1) {
            return false;
        }
        //derecha
        while (i + 1 != tamaño) {
            i++;
            if (tablero[i][j].getN() == 1) {
                return false;
            }
        }
        i = ii;

        //izquierda
        while (i - 1 != -1) {

            i--;
            if (tablero[i][j].getN() == 1) {
                return false;
            }
        }
        i = ii;

        //arriba
        while (j - 1 != -1) {

            j--;
            if (tablero[i][j].getN() == 1) {
                return false;
            }
        }
        j = jj;
        //abajo
        while (j + 1 != tamaño) {

            j++;
            if (tablero[i][j].getN() == 1) {
                return false;
            }
        }
        j = jj;
        //Diagonal derecha arriba
        while (i + 1 != tamaño && j - 1 != -1) {

            i++;
            j--;
            if (tablero[i][j].getN() == 1) {
                return false;
            }
        }
        i = ii;
        j = jj;
        //Diagonal derecha abajo
        while (i + 1 != tamaño && j + 1 != tamaño) {

            i++;
            j++;
            if (tablero[i][j].getN() == 1) {
                return false;
            }
        }
        i = ii;
        j = jj;
        //Diagonal izquierda arriba
        while (i - 1 != -1 && j - 1 != -1) {

            i--;
            j--;
            if (tablero[i][j].getN() == 1) {
                return false;
            }
        }
        i = ii;
        j = jj;
        //Diagonal izquierda abajo
        while (i - 1 != -1 && j + 1 != tamaño) {

            i--;
            j++;
            if (tablero[i][j].getN() == 1) {
                return false;
            }

        }
        return true;

    }

    public static void crearcasillas() {
        for (int i = 0; i < tamaño; i += 1) {
            for (int j = 0; j < tamaño; j += 1) {
                Casilla casilla = new Casilla();
                tablero[i][j] = casilla;
            }
        }

    }

    public void paint(Graphics g) {

    }

}
