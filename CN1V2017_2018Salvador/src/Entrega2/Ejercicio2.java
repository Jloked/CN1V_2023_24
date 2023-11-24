/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entrega2;

import auxiliar.Funcion;
import auxiliar.MetodosFunciones;
import auxiliar.MetodosListas;
import auxiliar.PanelDibujo;
import auxiliar.Polinomio;
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
        Polinomio[] leg= Polinomio.legendre(10);
        PanelDibujo win = new PanelDibujo("Legendre");
        win.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        win.addEjesCoordenados(true, -1.1, 1.1, -1.5, 1.5, 0., 0.);
        Color[] col={Color.red,Color.blue,Color.black,Color.green,Color.GRAY};
        for(int k=0;k<5;k++){       
        win.addCurva(col[k],leg[k], 200,-1.,1.);
        }
        win.repaint();
        
        double[][] ceros=new double[8][];
        for (int k=3;k<leg.length;k++){
            ceros[k-3]=leg[k].bisecSturm(1E-12,-1.,1.);
            System.out.println("Legendre, n="+k);
            System.out.println(MetodosListas.toString(ceros[k-3]));
        }
        
        double[] pesos=new double[10];
        Polinomio[] facL=Polinomio.facLagrange(ceros[7]);
        for(int k=0;k<10;k++){
//            pesos[k]=MetodosFunciones.integralSimpson(facL[k], -1.,1.,50);
            pesos[k]=MetodosFunciones.IntegralAdaptativa(facL[k], -1.,1.,1E-10,50);
        }
        System.out.println("pesos:"+MetodosListas.toString(pesos));
        
        double intapp=0.;
        F g=new F();
        for(int k=0;k<pesos.length;k++){
            intapp=intapp+pesos[k]*g.eval((3.+ceros[7][k])/2.);
        }
        intapp=intapp/2.;
//        System.out.println(ceros.length);
//        System.out.println(ceros[7].length);
        System.out.println("integral aproximada="+intapp);
        System.out.println("Error="+Math.abs(Math.log(2.)-intapp));
        System.out.println(Math.log(2.));
    }
    
    public static class F implements Funcion {
        
        public F(){}
        
        public double eval(double x){
            return 1./x;
        }
    }
}
