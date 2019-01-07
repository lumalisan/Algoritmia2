package SolucionManual;

import java.awt.Graphics;
import static java.lang.System.exit;
import javax.swing.JPanel;

/**
 *
 * @author Izar Castorina, Juanjo Torres, Lisandro Rocha
 */
public class QueenChess extends JPanel {

    public static int tamaño = 10;
    public static int empezarx = 0; //fila
    public static int empezary = 0; //columna

    private static int Ndamas = 0;
    public static Cell[][] tablero = new Cell[tamaño][tamaño];

    public QueenChess() {
        if (tamaño > 3) {

            crearcasillas();

            if (empezarx != 0) {
                meterdama(empezary, empezarx);
                backtracking(0, 0);
            } else {
                backtracking(empezary, empezarx);
            }

            if (Ndamas != tamaño) {
                System.out.println("No hay solucion a este problema");
                exit(0);
            }

        } else {
            System.out.println("tamaño demasiado pequeño para buscar una solucion");
            exit(0);
        }

    }

    public final void backtracking(int columna, int fila) {

        columna--;
        while (columna != tamaño - 1) {

            columna++;

            if (esvalido(columna, fila)) {
                meterdama(columna, fila);
                if (Ndamas == tamaño) {
                    if (tablero[empezary][empezarx].getN() == 0) {
                        System.out.println("No hay solucion a este problema");
                        exit(0);
                    }
                    printeartablero();

                    while (true) {

                    }
                } else {
                    if (Damaenestafila(fila + 1)) {
                        backtracking(0, fila + 2);
                    } else {
                        backtracking(0, fila + 1);
                    }
                    quitardama(columna, fila);
                }
            }

        }

    }

    public boolean Damaenestafila(int fila) {
        for (int l = 0; l < tamaño; l++) {
            if (tablero[l][fila].getN() == 1) {
                return true;
            }
        }
        return false;
    }

    public final void meterdama(int i, int j) {
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
                Cell casilla = new Cell();
                tablero[i][j] = casilla;
            }
        }

    }

    public void paint(Graphics g) {

    }

}
