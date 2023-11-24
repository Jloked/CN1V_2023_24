/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica7;

import auxiliar.Funcion;
import auxiliar.MetodosEcuacionNoLineal;
import auxiliar.MetodosFunciones;
import auxiliar.PanelDibujo;
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.WindowConstants;

/**
 *
 * @author antonio
 */
public class Ejercicio2 {

    public static class F1 implements Funcion{
        public double eval(double x){
            return Math.PI*Math.sin(x)/(2*(1+x*x));
        }
    }
    public static class F2 implements Funcion{
        public double eval(double x){
            return Math.exp(-x);
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        F1 f=new F1();
        F2 g=new F2();
        MetodosFunciones.diferencia dif=new MetodosFunciones.diferencia(f, g);
        double prec=0.5E-6;
        int nmaxit=200;
        
        int puntos=137;
        double xmin=0., xmax=10;
        int n =(int) Math.floor(xmax/Math.PI)+1;
        System.out.println("n = "+n);
        double[][] intersecciones=new double[n][2];
        double[][] kPI=new double[n][2];
        double[] extf=MetodosFunciones.extremos(f, puntos, xmin, xmax);
        double[] extg=MetodosFunciones.extremos(g, puntos, xmin, xmax);
        double ymax=Math.max(extf[1],extg[1]);
        double ymin=Math.min(extf[0],extg[0]);
        
        double xinf=xmin-0.1*(xmax-xmin), xsup=xmax + 0.1*(xmax-xmin);
        double yinf=ymin-0.1*(ymax-ymin), ysup=ymax + 0.1*(ymax-ymin);
        
        PanelDibujo pd=new PanelDibujo("Intersecciones", 0, 0, 800, 600);
        pd.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        pd.addEjesCoordenados(true, xinf, xsup, yinf, ysup, 0, 0);
        pd.addCurva(Color.blue, f, puntos, xmin, xmax);
        pd.addCurva(Color.red, g, puntos, xmin, xmax);
        int k=0;
        while(k < n){
            kPI[k][0]=k*Math.PI;
            pd.addPunto(Color.yellow, kPI[k]);
            try{
                intersecciones[k][0]=MetodosEcuacionNoLineal.newtonAprox(dif, (k)*Math.PI, 
                        prec, nmaxit);
                intersecciones[k][1]=f.eval(intersecciones[k][0]);
                pd.addPunto(Color.yellow, intersecciones[k]);
            }catch(MetodosEcuacionNoLineal.ERROR err){
                
            }          
            k++;
        }
        
        pd.repaint();
        
                
    }
    
}
