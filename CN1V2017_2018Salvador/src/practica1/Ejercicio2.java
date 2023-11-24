/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1;

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
       double pow=0.1;
       for (int i = 0; i < 10; i++) {

       double a=9;
       double e=0.5*pow;
       pow *= 0.1;
       double b=5.5+e;
       double c=3.5+e;
       System.out.println("a="+a);
       System.out.println("b="+b);
       System.out.println("c="+c); 

       double p=a+b+c;
       double s=p/2;
       double A1= Math.sqrt(s*(s-a)*(s-b)*(s-c));
//       System.out.println("s-a="+(s-a));
       System.out.println("Heron: Area1 = "+ A1);
       double cprox=a-b;
       double inest=c-cprox;
//       System.out.println("inest="+inest);
       double A2=Math.sqrt(p*inest*(c+cprox)*(a+(b-c)))/4;
       System.out.println("e= "+ e);
       System.out.println("Heron: Area2 = "+ A2);
       System.out.println("error relativo Area (dos formulas de Heron) = "+ (Math.abs(A1-A2)/A1));
       }
    }
    
}
