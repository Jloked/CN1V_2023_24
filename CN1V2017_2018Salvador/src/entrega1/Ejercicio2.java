/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entrega1;

import auxiliar.Funcion;
import auxiliar.MetodosFunciones;
import auxiliar.PanelDibujo;
import java.awt.Color;
import javax.swing.WindowConstants;

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
        int orden=1;
        Funcion[] func=new Funcion[3];
        Funcion[] dfunc=new Funcion[3];
        Funcion[] apdfunc=new Funcion[3];
        func[0]=new F0();
        func[1]=new F1();
        func[2]=new F2();
        dfunc[0]=new dF0(orden);
        dfunc[1]=new dF1(orden);
        dfunc[2]=new dF2(orden);        
        double h=0.01;
        double[] ext;
        double[][] tabla;
        PanelDibujo[] winf=new PanelDibujo[3];
        for(int K=0;K<=2;K++){
            winf[K]=new PanelDibujo("Aproximación de la derivada de orden "+orden+ "de F"+K,0*K*100,0+K*100,600+K*100,400+K*100);
            winf[K].setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); 
            tabla=MetodosFunciones.tablaGrafica(dfunc[K], 200, 0, 10);
            ext=MetodosFunciones.extremos(tabla);
            winf[K].addEjesCoordenados(true,-0.2, 10.5, ext[0]-0.1*(ext[1]-ext[0]), ext[1]+0.1*(ext[1]-ext[0]), 0, 0);
            winf[K].addCurva(Color.red,tabla);
            apdfunc[K]=new MetodosFunciones.derivadaK3(func[K],orden,h);
            tabla=MetodosFunciones.tablaGrafica(apdfunc[K], 200, 0, 10.);
            winf[K].addCurva(Color.blue,tabla);
            winf[K].repaint();
        }
    }
    
    public static class F0 implements Funcion{
     
     public F0(){}
     
     public double eval(double x){
         return Math.cos(x);
     }
    }
    
    public static class dF0 implements Funcion{
     int k;
     public dF0(int p){k=p;}
     
     public double eval(double x){
        k=k%4; 
        if (k==0) return Math.cos(x);
        else if (k==1) return -Math.sin(x);
        else if (k==2) return -Math.cos(x);
        else return Math.sin(x);
        }
                
    }
    
    public static class F1 implements Funcion{
     
     public F1(){}
     
     public double eval(double x){
         return Math.exp(2.*x);
     }
    }
    
    public static class dF1 implements Funcion{
     int k;
     public dF1(int p){
         k=p;
     }
     
     public double eval(double x){
         return Math.exp(2.*x)*Math.pow(2.,k);
     }
    }
    
    public static class F2 implements Funcion{
     
     public F2(){}
     
     public double eval(double x){
         return Math.exp(x/2.);
     }
    }
    
    public static class dF2 implements Funcion{
     int k;
     public dF2(int p){
         k=p;
     }
     
     public double eval(double x){
         return Math.exp(x/2.)/Math.pow(2.,k);
     }
    }
}
