/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica4;

import auxiliar.Funcion;
import auxiliar.MetodosFunciones;
import auxiliar.MetodosListas;
import auxiliar.PolinomioInterpolador;
import auxiliar.PanelDibujo;
import java.awt.Color;
import javax.swing.WindowConstants;

/**
 *
 * @author salvaold
 */
public class Prueba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    
    F f=new F();
    int nump=10;
    double[][] tabla=MetodosFunciones.tablaGrafica(f,nump, 0,1);
    System.out.println("tabla de puntos:\n"+MetodosListas.toString(tabla));
    PolinomioInterpolador p=new PolinomioInterpolador(tabla);
    System.out.println("Polinomio interpolador\n"+p.escribe());
    
    PanelDibujo win=new PanelDibujo("La función seno interpolada");
    win.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    win.addEjesCoordenados(true, -2*Math.PI-0.1, 2*Math.PI+0.1, -1.1, 1.1, 0., 0.);
    win.addListaPuntos(Color.black, tabla,3);    
    win.addCurva(Color.red, f, 300, -2*Math.PI,2*Math.PI);
    win.addCurva(Color.blue,p,300,-2*Math.PI,2*Math.PI);
    win.repaint();
    }
 
    public static class F implements Funcion {
        
        public F(){}
        
        public double eval(double x){
            return Math.sin(x);
        }
    }
}
