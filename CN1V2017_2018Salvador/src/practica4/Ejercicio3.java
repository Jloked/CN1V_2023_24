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
public class Ejercicio3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        double[][] TablaValores;
        
        double[][] tabla={{0,0},{0.5,Math.PI/6.},{Math.sqrt(2.)/2.,Math.PI/4.},
            {Math.sqrt(3)/2.,Math.PI/3.},{1,Math.PI/2.}};
        PolinomioInterpolador pol=new PolinomioInterpolador(tabla);
        double aprox=pol.eval(0.75);
        System.out.println("Aproximación= "+aprox);
        System.out.println("Error= "+Math.abs(aprox-Math.asin(0.75)));
        
        PanelDibujo win=new PanelDibujo("Arco seno y polinomio interpolador");
        win.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        
        Arcseno f=new Arcseno();
        TablaValores=MetodosFunciones.tablaGrafica(pol, 200, 0,1);
        win.addEjesCoordenados(true, -0.2, 1.2, -0.5,Math.PI/2.+0.5,0,0);
        win.addCurva(Color.red, TablaValores);
        win.addCurva(Color.blue, MetodosFunciones.tablaGrafica(f, 200, 0,1));
        win.addListaPuntos(Color.blue, tabla, 3);
        win.repaint();
    }
    
    public static class Arcseno implements Funcion{
        public Arcseno(){}
        
        @Override
        public double eval(double x){
            return Math.asin(x);
        }
        
    }
}
