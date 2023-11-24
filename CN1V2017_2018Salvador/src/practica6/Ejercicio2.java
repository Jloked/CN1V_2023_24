/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica6;

import auxiliar.Funcion;
import auxiliar.MetodosFunciones;

/**
 *
 * @author salvaold
 */
public class Ejercicio2 {
    public static  final double EXAC=Math.sqrt(Math.PI)/2.;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    // apartado a)
        System.out.println("Valor de la integral="+EXAC);
        double colamax=1.E-12;
        campana f=new campana();
        double a=0.;
        int b=0;
        //acotación de la cola
        for(int i=1;i<=20;i++){
            if ((f.eval(i)/(double)i)<colamax){                
                b=i;
                System.out.println("Extremo derecho de integración: "+i);
                break;
                }
        }
        double aprox1=MetodosFunciones.integralSimpson(f, a, b, b);
        System.out.println("Aproximación a la integral="+aprox1);
        System.out.println("Error="+Math.abs(aprox1-EXAC));
        double aprox2=MetodosFunciones.integralSimpson(f, a, b, 5*b);
        System.out.println("Aproximación a la integral="+aprox2);
        System.out.println("Error="+Math.abs(aprox2-EXAC));
    // apartado b)
        funcionb g=new funcionb();
        int N=10;
        aprox1 =MetodosFunciones.integralSimpson(g, 0., 1.,N);
        System.out.println("\n\nAroximación a la segunda integral (Simpson, 10)="+aprox1);
        aprox1 =MetodosFunciones.integralGauss(g, 0., 1.,2);
        System.out.println("\nAroximación a la segunda integral (Gauss, 2)="+aprox1);
        aprox1 =MetodosFunciones.integralGauss(g, 0., 1., N);
        System.out.println("\nAroximación a la segunda integral (Gauss, 10)="+aprox1);
    // Segunda forma de cálculo
        funcionc h=new funcionc(); 
        aprox1 =3.+MetodosFunciones.integralSimpson(h, 0., 1.,N);
        System.out.println("\n\nSegundo método");
        System.out.println("\nAroximación a la segunda integral (Simpson, 10)="+aprox1);
        aprox1 =3.+MetodosFunciones.integralGauss(h, 0., 1.,2);
        System.out.println("\nAroximación a la segunda integral (Gauss, 2)="+aprox1);
        aprox1 =3.+MetodosFunciones.integralGauss(h, 0., 1., N);
        System.out.println("\nAroximación a la segunda integral (Gauss, 10)="+aprox1);
        
    }
    
    public static class campana implements Funcion {
        
        public campana(){}
        
        public double eval(double x){
            return Math.exp(-x*x);
        }
    }
    
    public static class funcionb implements Funcion {
        
        public funcionb(){}
        
        public double eval(double x){
            return 3*Math.exp(x*x);
        }
    }
    
    public static class funcionc implements Funcion {
        
        public funcionc(){}
        
        public double eval(double x){
            if (x==0.) return 0.;
            else return Math.pow(x,-2./3.)*(Math.exp(x)-1.);
        }
    }
}
