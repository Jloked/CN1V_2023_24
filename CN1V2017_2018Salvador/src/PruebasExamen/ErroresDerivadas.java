/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PruebasExamen;

import auxiliar.Funcion;
import auxiliar.MetodosFunciones.*;
import auxiliar.PanelDibujo;
import java.awt.Color;
import javax.swing.WindowConstants;

/**
 *
 * @author salvaold
 */
public class ErroresDerivadas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         
       F1 DerC = new F1();
       int numptos=1000;
       
       PanelDibujo winf=new PanelDibujo("La función de Chang",0,0,1000,800);
        winf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); 
        winf.addEjesCoordenados(true, 0, 9*1E-9, -1E-6, 1E-6,0,0);
        winf.repaint();
        winf.addCurva(Color.blue, DerC, 1000, 1E-12, 1E-10);
        winf.repaint();
        winf.addCurva(Color.blue, DerC, 2000, 1E-10, 1E-9);
        winf.repaint();
        winf.addCurva(Color.blue, DerC, 3000, 1E-9, 9*1E-9);
        winf.repaint();
    }
    
    public static class g implements Funcion{
        
        public g(){}
        
        public double eval (double x){
            return Math.atan(x);
        }
    }
    public static class F1 implements Funcion {
        
        public F1(){}
        
        public double eval(double x){  
            double ap;
            g arco = new g();
            derivada3puntos c =new derivada3puntos(arco,x);
            ap=c.eval(1.);
            System.out.print(x + "   ");
            System.out.println(ap-0.5);
            return ap-0.5;
        }
    }
 
    public static class F2 implements Funcion {
        
        public F2(){}
        
        public double eval(double x){  
            double ap;
            g arco = new g();
            derivada3puntosR c =new derivada3puntosR(arco,x);
            ap=c.eval(1.);
            System.out.print(x + "   ");
            System.out.println(ap-0.5);
            return ap-0.5;
        }
    }
}