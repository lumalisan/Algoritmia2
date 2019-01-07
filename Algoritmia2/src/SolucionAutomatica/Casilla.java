/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SolucionAutomatica;

/**
 *
 * @author mates
 */
public class Casilla {

    private int n;
    private boolean valida;

    public Casilla() {
        this.n = 0;
        this.valida = true;
    }

    @Override
    public String toString() {
        return "Casilla{" + "n=" + n + ", valida=" + valida + '}';
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public boolean isValida() {
        return valida;
    }

    public void setValida(boolean valida) {
        this.valida = valida;
    }

}
