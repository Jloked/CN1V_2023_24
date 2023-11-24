package Ejercicios;

import auxiliar.MetodosFunciones;
import auxiliar.Polinomio;
import auxiliar.PanelDibujo;
import auxiliar.PolinomioInterpolador;
import java.awt.Color;
import javax.swing.WindowConstants;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author salvaold
 */
public class EjAdicional2_3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    
    double[][] tabla2 = {{0.,0.,30.},{3.,99.,33.},{5.,165.,30},{9.,290.,25.},{12.,380.,33}};
    PolinomioInterpolador pol2=new PolinomioInterpolador(tabla2);
    System.out.println("Polinomio de Hermite:"+pol2.escribe());
    PanelDibujo win2 = new PanelDibujo("Polinomio de Hermite",100,100,900,700);
    win2.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    double[][] TablaValores=MetodosFunciones.tablaGrafica(pol2,500,0,12);
    double[] exty=MetodosFunciones.extremos(TablaValores);
    win2.addEjesCoordenados(true, -2.5, 12.5, exty[0]-30,exty[1]+30,0.,0.);
    win2.addCurva(Color.red, TablaValores);
    
    
    Polinomio der=pol2.derivada();
    win2.addCurva(Color.blue,der,500,0,12);
        System.out.println("p'(12)="+der.eval(9.));
        win2.repaint();
    }
    
}
