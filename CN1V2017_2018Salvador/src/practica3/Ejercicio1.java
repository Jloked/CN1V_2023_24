/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica3;
import ORG.netlib.math.complex.Complex;
import auxiliar.Polinomio;
/**
 *
 * @author salvaold
 */
public class Ejercicio1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        double[] tabla = {1,-2,3,-4,0,5};
        Polinomio p= new Polinomio(tabla);
        System.out.println("p(x)="+p.escribe());
        System.out.println("p(0)="+p.eval(0.));
        System.out.println("p(0)="+p.eval(1.));
        System.out.println("p(0)="+p.eval(Complex.cart(0.,1.)));
    }
    
}
