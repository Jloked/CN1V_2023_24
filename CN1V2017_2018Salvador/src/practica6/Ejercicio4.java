/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica6;

import auxiliar.ExcepcionAdaptativo;
import auxiliar.Funcion;
import auxiliar.MetodosFunciones;
import auxiliar.MetodosListas;

/**
 *
 * @author salvaold
 */
public class Ejercicio4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ExcepcionAdaptativo {
        // TODO code application logic here
        
    double a=0.;
    double b=10.;
    F f = new F();
    double aprox;
    double tol=1.E-5;
    //double[] Aproxim;
    int N=20;
    
    aprox=MetodosFunciones.integralAdaptada(f, a, b, tol, N);
    System.out.println("Aproximación con Gauss adaptativo:" + aprox);
    aprox=MetodosFunciones.IntegralAdaptativa(f, a, b, tol, 2*N);
    System.out.println("Aproximación con Simpson adaptativo:" + aprox);
    aprox=MetodosFunciones.integralAdaptadaSimpson(f, a, b, tol, 2*N);
    System.out.println("Aproximación con Simpson adaptativo:" + aprox);
//    Aproxim=MetodosFunciones.IntegralAdaptativaIt(f, a, b, tol, 2*N);
//    System.out.println("Aproximación con Simpson adaptativo:" + MetodosListas.toString(Aproxim));
//    Aproxim=MetodosFunciones.IntegralAdaptativaItB(f, a, b, tol, 2*N);
//    System.out.println("Aproximación con Simpson adaptativo:" + MetodosListas.toString(Aproxim));
    }
    
    public static class F implements Funcion{
        public F(){};
        
        public double eval(double x){
            if (x==0.) return 0.;
            else return x*Math.sin(1./x);
        }
    }
}
