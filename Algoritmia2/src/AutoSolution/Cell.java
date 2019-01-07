package AutoSolution;

/**
 *
 * @author Izar Castorina, Juanjo Torres, Lisandro Rocha
 */
public class Cell {

    private int num;
    private boolean correct;

    public Cell() {
        this.num = 0;
        this.correct = true;
    }

    @Override
    public String toString() {
        return "Cell --> " + "number = " + num + "/ is correct = " + correct;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }

}
