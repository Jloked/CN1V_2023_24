/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica4;

import auxiliar.*;
import java.awt.Color;
import javax.swing.*;

/**
 *
 * @author salva
 */
public class Ejercicio2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        int N=15;
        Runge frunge=new Runge();
        double[][] nodos=new double[N][2];
        double[][] TablaFuncion=MetodosFunciones.tablaGrafica(frunge, 200, -1,1);
        double[][] TablaValores;
        double[][] TablaErrores;
       
      
        for (int i=0; i<N; i++) {
            nodos[i][0]=-1.+(2.*i)/(N-1);
            nodos[i][1]=frunge.eval(nodos[i][0]);
        }
//        System.out.println(MetodosListas.toString(nodos));
        
        PanelDibujo win=new PanelDibujo("Runge con nodos equidistantes");
        PanelDibujo win3=new PanelDibujo("Errores absolutos",100,300,900,900);
        win.addEjesCoordenados(true, -1.2, 1.2, -0.3,1.1,0,0); 
        win3.addEjesCoordenados(true, -1.3, 1.3, -0.2, 10, 0, 0);        
        win.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        win3.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
               
        System.out.println("Nodos equidistribuidos");
        PolinomioInterpolador pol=new PolinomioInterpolador(nodos);
        System.out.println("pol="+pol.escribe());
        TablaValores=MetodosFunciones.tablaGrafica(pol, 200, -1,1);
        System.out.println(MetodosListas.toString(TablaValores));
        win.addCurva(Color.red, TablaValores);
        win.addCurva(Color.blue, TablaFuncion);
        win.addListaPuntos(Color.blue, nodos, 3);
        win.repaint();
        TablaErrores=MetodosFunciones.tablaGrafica(new MetodosFunciones.absError(pol, frunge), 200, -1,1);
        win3.addCurva(Color.red, TablaErrores);
        win3.addEtiqueta(1.1, 5, "Lagrange", Color.red);
    
    
        double[][] nodosC;
        nodosC=MetodosFunciones.tablaGraficaTchev(frunge, N, -1., 1.);
       
        PanelDibujo win1=new PanelDibujo("Runge con nodos de Chebyshev",400,100,1200,700);
        win1.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        win1.addEjesCoordenados(true, -1.2, 1.2, -0.3,1.1,0,0);
        win1.addCurva(Color.blue, TablaFuncion);
        System.out.println("Nodos de Chebychev");
        PolinomioInterpolador polC=new PolinomioInterpolador(nodosC);
        TablaValores=MetodosFunciones.tablaGrafica(polC, 200, -1.,1.);
        win1.addCurva(Color.red, TablaValores);
        win1.addListaPuntos(Color.blue, nodosC, 3);
        win1.repaint();
        TablaErrores=MetodosFunciones.tablaGrafica(new MetodosFunciones.absError(polC, frunge), 200, -1,1);
        win3.addCurva(Color.blue, TablaErrores);
        win3.addEtiqueta(1.1, 5.5, "Tchebychev", Color.blue);
        
        
        double[][] nodosH=new double[N][];
        
        System.arraycopy(nodos, 1, nodosH, 1, N-2);
        nodosH[0]= new double[4];
        nodosH[N-1]= new double[4];
        nodosH[0][0]=-1.;
        nodosH[0][1]=frunge.eval(-1.);
        nodosH[0][2]=0.;
        nodosH[0][3]=0.;
        nodosH[N-1][0]=1.;
        nodosH[N-1][1]=frunge.eval(1.);
        nodosH[N-1][2]=0.;
        nodosH[N-1][3]=0.;
//        System.out.println("nodosH:"+MetodosListas.toString(nodosH));
        
        PanelDibujo win2=new PanelDibujo("Runge con Hermite",200,200,1000,800);
        win2.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        win2.addEjesCoordenados(true, -1.2, 1.2, -0.3,1.1,0,0);
        win2.addCurva(Color.blue, TablaFuncion);
        PolinomioInterpolador polH=new PolinomioInterpolador(nodosH);
        TablaValores=MetodosFunciones.tablaGrafica(polH, 200, -1,1);
        win2.addCurva(Color.red, TablaValores);
        win2.addListaPuntos(Color.blue, nodos, 3);
        TablaErrores=MetodosFunciones.tablaGrafica(new MetodosFunciones.absError(polH, frunge), 200, -1,1);
        win3.addCurva(Color.green, TablaErrores);
        win3.addEtiqueta(1.1, 6, "Hermite", Color.green);
        win2.repaint();
        
        win3.repaint();
        
    }
    
    public static class Runge implements Funcion {
        public Runge(){}
        
        public double eval(double x){
           return 1./(1.+25*x*x); 
        }
    }
}
