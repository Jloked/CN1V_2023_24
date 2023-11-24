/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica2;

import auxiliar.Funcion;
import auxiliar.MetodosFunciones;
import auxiliar.MetodosListas;

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
        F1 f= new F1();
        F2 g= new F2();
        double[][] tablav;
               
        tablav=MetodosFunciones.tablaGrafica(f,11,-5.,5);
        System.out.println("Tabla de valores de f\n");
        System.out.println(MetodosListas.toString(tablav));
        
        //Apartado 3
        MetodosFunciones.suma h = new MetodosFunciones.suma(f,g);
        tablav=MetodosFunciones.tablaGrafica(h, 11, -5.,5.);
        System.out.println("Tabla de valores de f+g\n");
        System.out.println(MetodosListas.toString(tablav));
        
        //Apartado 4
        tablav=MetodosFunciones.tablaGrafica(new MetodosFunciones.diferencia(f,g),11,-5,5);
        System.out.println("Tabla de valores de f-g\n");
        System.out.println(MetodosListas.toString(tablav));
        //
        tablav=MetodosFunciones.tablaGrafica(new MetodosFunciones.producto(f,g),11,-5,5);
        System.out.println("Tabla de valores de f*g\n");
        System.out.println(MetodosListas.toString(tablav));
        //
        tablav=MetodosFunciones.tablaGrafica(new MetodosFunciones.composicion(f,g),11,-5,5);
        System.out.println("Tabla de valores de g(f(x))\n");
        System.out.println(MetodosListas.toString(tablav));
        
        //Apartado 5
        for(int n=1;n<=3;n++){
            tablav=MetodosFunciones.tablaGrafica(new F3(n),11,-5,5);
            System.out.println("Tabla de valores de x^" + n + "*e^x\n");
            System.out.println(MetodosListas.toString(tablav));
        }
    }
    
    public static class F1 implements Funcion {
    
        public F1(){}
        
        public double eval(double x){
            double z;
            if (x>=0) 
                z=1 + Math.cos(x*x*Math.exp(x));
            else 
                z=Math.exp(-0.1*x)+Math.cos(x*x*Math.exp(-x));
            return z;
        }
        }
    
    public static class F2 implements Funcion{
        
        public F2(){}
        
        public double eval(double x){
            return Math.PI + Math.sqrt(1.+x*x);
        }
    }
    
    public static class F3 implements Funcion{
        int m;
        
        public F3(int n){
            m=n;
        }
        
        public double eval(double x){
            double pot=1.;
            for(int j=1;j<=m;j++){
                pot=pot*x;
            }
            return pot*Math.exp(x);
        }
    }
}
