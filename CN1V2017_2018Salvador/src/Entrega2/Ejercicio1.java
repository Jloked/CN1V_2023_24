/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entrega2;

import auxiliar.Funcion;
import auxiliar.FuncionDeriv;
import auxiliar.MetodosEcuacionNoLineal;
import auxiliar.MetodosFunciones;
import auxiliar.PanelDibujo;
import java.awt.Color;
import javax.swing.WindowConstants;

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
        Funcion f;
        FuncionDeriv F;
        PanelDibujo[] win=new PanelDibujo[4];
        for (int k=0;k<win.length;k++){
        win[k] = new PanelDibujo("k="+(k+3));
        win[k].setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        win[k].addEjesCoordenados(true, -10.1, 10.1, -0.2, 1.1, 0., 0.);
        f=new dens(k+3);
        F=new dist(k+3);
        win[k].addCurva(Color.red, MetodosFunciones.tablaGrafica(f, 500, -10., 10.));
        win[k].addCurva(Color.blue, MetodosFunciones.tablaGrafica(F, 500, -10., 10.));      
        win[k].repaint();
        }
        
        double[] datos={0.6,0.8,0.85,0.95,0.995};
        int parini=5;
        int parfin=11;
        double sol;
        double prec=1E-15;
        int maxit=50;
        FuncionDeriv H;
        for (int k=parini;k<=parfin;k++){
            System.out.println("k="+k);
            F=new dist(k);    
            for (int j=0;j<datos.length;j++){
               H=new Aux(F,datos[j]);
               sol=MetodosEcuacionNoLineal.newton(H, 0.,prec,maxit);
                System.out.println("Inv("+k+")("+datos[j]+")="+sol);
            }
        }
    }
    
    public static class dens implements Funcion{
        int p;
        double C;
    
        public dens(int k){
            p=k;
            C=1.;
            int m;
            if (p%2==0){
                m=k/2;
                for(int j=1;j<m;j++){
//                    System.out.println(C);
                    C=C*(double)(2*j+1.)/(2*j);
                }
                C=C/(2*Math.sqrt(p));
            }
            else {
                m=(int) Math.floor(p/2.);
//                System.out.println("m="+m);
                for(int j=0;j<m;j++){
//                    System.out.println(C);
                    C=C*(double)(2*j+2.)/(2*j+1.);
                }
                C=C/(Math.PI*Math.sqrt(p));
                }
               
        }        
        public double eval(double x){
            return C*Math.pow(1+x*x/p,-(p+1)/2.);
        }                        
    }
    
    public static class dist implements FuncionDeriv{
        int p;
        dens f;
        public dist(int k){
        this.p=k;
        f=new dens(p);
        }
        
        public double eval(double x){
            double aux;
            if (x>=0) {
                aux=0.5;
                aux=aux+MetodosFunciones.integralGauss(f, 0., x, 10);}
            else {
                aux=0.5;
                aux=aux-MetodosFunciones.integralGauss(f, 0., -x, 10);}
            return aux;
        }
        public double derivada(double x){
            return f.eval(x);                    
        }    
        }
    
     public static class Aux implements FuncionDeriv{ 
         FuncionDeriv G;
         double val;
         public Aux(FuncionDeriv g,double y){
             this.val=y;
             this.G=g;
         }
         
         public double eval(double x){
             return G.eval(x)-val;
         }
         
         public double derivada(double x){
             return G.derivada(x);
         }
     }  
}
