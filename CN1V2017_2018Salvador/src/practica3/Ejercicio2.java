/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica3;

import auxiliar.Polinomio;

/**
 *
 * @author salvaold
 */
public class Ejercicio2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        double[] abscisas={0,1,2};
        Polinomio[] L;
        L=Polinomio.facLagrange(abscisas);
        for(int i=0;i<abscisas.length;i++){
            System.out.println("L["+abscisas[i]+"]="+L[i].escribe()+"\n");
        }
    }
    
}
