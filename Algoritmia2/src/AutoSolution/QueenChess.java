package AutoSolution;

import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author Izar Castorina, Juanjo Torres, Lisandro Rocha
 */
public class QueenChess extends JPanel {

    public static int solutions = 0;
    private boolean founded = false;
    public static int size = 2;
    public static int x = 0; //fila
    public static int y = 0; //culumna

    private static int queens = 0;
    public static Cell[][] table = new Cell[size][size];

    public QueenChess() {

        createCells();

        backtracking(y, x);

        System.out.println("Total number of solutions : " + solutions);

        Chess.show = true;
    }

    public final void backtracking(int culumna, int fila) {

        culumna--;
        while (culumna != size - 1) {

            culumna++;

            if (itworks(culumna, fila)) {
                add(culumna, fila);
                if (queens == size) {
                    solutions++;
                    remove(culumna, fila);
                } else {

                    backtracking(0, fila + 1);

                    remove(culumna, fila);

                }
            }

        }
        founded = false;
    }

    public boolean checkRow(int fila) {
        for (int l = 0; l < size; l++) {
            if (table[l][fila].getNum() == 1) {
                return true;
            }
        }
        return false;
    }

    public void add(int i, int j) {
        table[i][j].setNum(1);
        queens++;
        update();
    }

    public void remove(int i, int j) {
        table[i][j].setNum(0);
        queens--;
        update();
    }

    public void paintTable() {
        for (int k = 0; k < size; k++) {
            for (int l = 0; l < size; l++) {
                System.out.println(table[k][l]);
            }
        }
    }

    public void update() {

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {

                if (table[i][j].getNum() == 1) {
                    int ii = i;
                    int jj = j;
                    table[i][j].setCorrect(false);
                    //derecha
                    while (i + 1 != size) {
                        i++;
                        table[i][j].setCorrect(false);
                    }
                    i = ii;

                    while (i - 1 != -1) {

                        i--;
                        table[i][j].setCorrect(false);
                    }
                    i = ii;

                    while (j - 1 != -1) {

                        j--;
                        table[i][j].setCorrect(false);
                    }
                    j = jj;

                    while (j + 1 != size) {

                        j++;
                        table[i][j].setCorrect(false);
                    }
                    j = jj;

                    while (i + 1 != size && j - 1 != -1) {

                        i++;
                        j--;
                        table[i][j].setCorrect(false);
                    }
                    i = ii;
                    j = jj;

                    while (i + 1 != size && j + 1 != size) {

                        i++;
                        j++;
                        table[i][j].setCorrect(false);
                    }
                    i = ii;
                    j = jj;

                    while (i - 1 != -1 && j - 1 != -1) {

                        i--;
                        j--;
                        table[i][j].setCorrect(false);
                    }
                    i = ii;
                    j = jj;

                    while (i - 1 != -1 && j + 1 != size) {

                        i--;
                        j++;
                        table[i][j].setCorrect(false);
                    }
                    i = ii;
                    j = jj;
                }
            }
        }

    }

    public boolean itworks(int i, int j) {

        int ii = i;
        int jj = j;

        if (table[i][j].getNum() == 1) {
            return false;
        }

        while (i + 1 != size) {
            i++;
            if (table[i][j].getNum() == 1) {
                return false;
            }
        }
        i = ii;

        while (i - 1 != -1) {

            i--;
            if (table[i][j].getNum() == 1) {
                return false;
            }
        }
        i = ii;

        while (j - 1 != -1) {

            j--;
            if (table[i][j].getNum() == 1) {
                return false;
            }
        }
        j = jj;

        while (j + 1 != size) {

            j++;
            if (table[i][j].getNum() == 1) {
                return false;
            }
        }
        j = jj;

        while (i + 1 != size && j - 1 != -1) {

            i++;
            j--;
            if (table[i][j].getNum() == 1) {
                return false;
            }
        }
        i = ii;
        j = jj;

        while (i + 1 != size && j + 1 != size) {

            i++;
            j++;
            if (table[i][j].getNum() == 1) {
                return false;
            }
        }
        i = ii;
        j = jj;

        while (i - 1 != -1 && j - 1 != -1) {

            i--;
            j--;
            if (table[i][j].getNum() == 1) {
                return false;
            }
        }
        i = ii;
        j = jj;

        while (i - 1 != -1 && j + 1 != size) {

            i--;
            j++;
            if (table[i][j].getNum() == 1) {
                return false;
            }

        }
        return true;

    }

    public static void createCells() {
        for (int i = 0; i < size; i += 1) {
            for (int j = 0; j < size; j += 1) {
                Cell casilla = new Cell();
                table[i][j] = casilla;
            }
        }

    }

    @Override
    public void paint(Graphics g) {
    }

}
