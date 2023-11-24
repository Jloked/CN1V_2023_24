/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica4
;

import auxiliar.*;
import java.awt.Color;
import javax.swing.WindowConstants;
/**
 *
 * @author salva
 */
public class Ejercicio1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        double[][] tabla1 ={{1.5,0.0},{2.7,1},{3.1,-0.5},{-2.1,1.},{-6.6,0.5},{11.,0.}};
        System.out.println(MetodosListas.toString(tabla1));
        PolinomioInterpolador pol1=new PolinomioInterpolador(tabla1);
        //System.out.println("Nodos="+MetodosListas.toString(pol1.nodos));
        System.out.println("Polinomio de Lagrange:"+pol1.toString());
        
        double[][] tabla2 = {{0.,1.,2.},{1.,0.,1.,1.},{2.,3.},{3,1.,1.}};
        //double[][] tabla2 = {{0.,2.,-1.},{1.,4.},{2.,30.,0.}};
        //double[][] tabla2 = {{0.,1.,1.,1.},{1.,2.,2.},{2.,1.}};
        //double[][] tabla2 = {{2,6,7,8},{1,2,3}};
        System.out.println(MetodosListas.toString(tabla2));
        PolinomioInterpolador pol2=new PolinomioInterpolador(tabla2);
        //System.out.println("Nodos="+MetodosListas.toString(pol2.nodos));
        System.out.println("Polinomio de Hermite:"+pol2.escribe());
//        System.out.println("p(0)="+pol2.eval(0));
//        System.out.println("p(1)="+pol2.eval(1));
//        System.out.println("p(2)="+pol2.eval(2));       
    
    
    PanelDibujo win1 = new PanelDibujo("Polinomio de Lagrange");
    win1.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    
    double[] exty;
    double minx=-7.;
    double maxx=11.5;    
    double[][] TablaValores;
    
    
    TablaValores=MetodosFunciones.tablaGrafica(pol1,100,minx,maxx);
    exty=MetodosFunciones.extremos(TablaValores);
    win1.addEjesCoordenados(true, minx, maxx, exty[0]-(exty[1]-exty[0])/50,exty[1]+(exty[1]-exty[0])/50,0.,0.);
    win1.addCurva(Color.red, TablaValores);    
    win1.addListaPuntos(Color.red, tabla1, 5);
    win1.repaint();
    
    PanelDibujo win2 = new PanelDibujo("Polinomio de Hermite",100,100,900,700);
    win2.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    
    minx=0.;
    maxx=3.;
               
    TablaValores=MetodosFunciones.tablaGrafica(pol2,100,minx,maxx);
    exty=MetodosFunciones.extremos(TablaValores);
    win2.addEjesCoordenados(true, minx-0.5, maxx+0.5, exty[0]-1,exty[1]+1,0.,0.);
    win2.addCurva(Color.red, TablaValores);
    for(int i=0;i<tabla2.length;i++){
        double[] punto=new double[2];
        punto[0]=tabla2[i][0];
        punto[1]=tabla2[i][1];
        win2.addPunto(Color.red, punto, 5);
    }
    win2.repaint();
    }
    
}
