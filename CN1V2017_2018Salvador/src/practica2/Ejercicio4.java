/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica2;

import ORG.netlib.math.complex.Complex;

/**
 *
 * @author salvaold
 */
public class Ejercicio4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    Complex z1= new Complex(1.,3.);    
    Complex z2= new Complex(2.,-6.);    
    Complex z;
    
    //Apartado a)
        z=z1.add(z2);
        System.out.println("z1+z2="+z);
    
    //Apartado b)
        System.out.println("arg(z1)="+z1.arg());
        System.out.println("abs(z1)="+z1.abs());
                
    //Apartado c)
        z= Complex.cart(-2.,-3.);
        System.out.println("arg(-2-3i)="+z.arg());
        System.out.println("|-2-3i|="+z.abs());
    
    //Apartado d)
        z1 = new Complex(1.,-1.);
        z2 = new Complex(1.,1.);
        z1=z1.sqrt();
        z2=z2.sqrt();
        System.out.println("sqrt(1-i)="+ z1);
        System.out.println("sqrt(1+i)="+ z2);
        System.out.println("sqrt(1-i)*sqrt(1+i)="+ z1.mul(z2));
    
    // Apartado (e)
        z1=new Complex(-1.,-2.);
        z2=Complex.pow(z1, 0.2);
        System.out.println("Una única raíz quinta de -1-2i="+z2);
        
        System.out.println("Ahora buscamos las cinco:");
        double x=z1.abs();
        double angulo=z1.arg();
        System.out.println("Módulo de 1-2i="+x);
        System.out.println("Argumento de 1-2i="+angulo);
        x=Math.pow(x,0.2);
        for(int i=0;i<5;i++){
            z2=Complex.polar(x,angulo/5.+(Math.PI*2.*i)/5.);
            System.out.println("raíz_"+i+" = "+z2);
        }
    }
}    
    
    
