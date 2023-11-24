/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PruebasExamen;

import auxiliar.Funcion;
import auxiliar.MetodosEcuacionNoLineal;

/**
 *
 * @author salvaold
 */
public class Ejercicio1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws MetodosEcuacionNoLineal.ERROR {
        // TODO code application logic here
        
        F f=new F();
        double tol=1E-14;
        int maxit=100;
        double x0=0.;
        double x1=0.25;
        double x2=-0.25;
        double x;
        x=MetodosEcuacionNoLineal.interpInver3p(f,x0,x1,x2,tol,maxit);
        System.out.println("aproximación:"+ x);
    }
    
    public static class F implements Funcion{
        public F(){}
        
        public  double eval(double x){
            return (x-2.)*(x-2.)*Math.log(2.+x*x);
        }
    }
    
}
