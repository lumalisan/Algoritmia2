package ManualSolution;

import java.awt.Graphics;
import static java.lang.System.exit;
import javax.swing.JPanel;

/**
 *
 * @author Izar Castorina, Juanjo Torres, Lisandro Rocha
 */
public class QueenChess extends JPanel {

    public static int size = 10;
    public static int x = 0; //fila
    public static int y = 0; //columna

    private static int queens = 0;
    public static Cell[][] table = new Cell[size][size];

    public QueenChess() {
        if (size > 3) {

            createCells();

            if (x != 0) {
                add(y, x);
                backtracking(0, 0);
            } else {
                backtracking(y, x);
            }

            if (queens != size) {
                System.out.println("No solution");
                exit(0);
            }

        } else if (size == 1){
            createCells();
            System.out.println("Solution = 1");
        } else {
            System.out.println("No solution");
            exit(0);
        }

    }

    public final void backtracking(int columna, int fila) {

        columna--;
        while (columna != size - 1) {

            columna++;

            if (isCorrect(columna, fila)) {
                add(columna, fila);
                if (queens == size) {
                    if (table[y][x].getNum() == 0) {
                        System.out.println("No solution");
                        exit(0);
                    }
                    showTable();

                    while (true) {

                    }
                } else {
                    if (Damaenestafila(fila + 1)) {
                        backtracking(0, fila + 2);
                    } else {
                        backtracking(0, fila + 1);
                    }
                    remove(columna, fila);
                }
            }

        }

    }

    public boolean Damaenestafila(int fila) {
        for (int l = 0; l < size; l++) {
            if (table[l][fila].getNum() == 1) {
                return true;
            }
        }
        return false;
    }

    public final void add(int i, int j) {
        table[i][j].setNum(1);
        queens++;
        update();
    }

    public void remove(int i, int j) {
        table[i][j].setNum(0);
        queens--;
        update();
    }

    public void showTable() {
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

    public boolean isCorrect(int i, int j) {

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

    public void paint(Graphics g) {
    }

}
