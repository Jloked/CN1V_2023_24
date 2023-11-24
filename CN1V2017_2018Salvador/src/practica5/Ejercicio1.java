/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica5;

import auxiliar.*;
import java.awt.Color;
import javax.swing.WindowConstants;
/**
 *
 * @author salva
 */
public class Ejercicio1 {
    
    public static void main(String[] args) {
        double[][] datos1={{1,4},{3,0},{0,1},{2,2}};
        Color[] colores={Color.red,Color.blue,Color.green,Color.magenta};
        String[] etiq =new String[4];
       

        PanelDibujo win1=new PanelDibujo("Spline natural",0,0,800,600);
        win1.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);        
        Spline spnat=new Spline(datos1);
        double[][] tablaval=MetodosFunciones.tablaGrafica(spnat, 200, 0, 3);
        win1.addCurva(Color.red, tablaval);
        double[] extr=MetodosFunciones.extremos(tablaval);
        win1.addEjesCoordenados(true,-0.5,3.5,extr[0]-1,extr[1]+1,0,0);
        win1.addListaPuntos(Color.red, datos1, 3);
        win1.repaint();
        
        PanelDibujo win2=new PanelDibujo("Spline sujeto",200,200,1000,800);
        win2.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);        

        Spline[] spsuj=new Spline[4];
        spsuj[0]=new Spline(datos1,0.,-1.);
        etiq[0]="(0,-1)";
        spsuj[1]=new Spline(datos1,1,5);
        etiq[1]="(1,5)";
        spsuj[2]=new Spline(datos1,-2,-5);
        etiq[2]="(-2,-5)";
        spsuj[3]=new Spline(datos1,-5,-1);
        etiq[3]="(-5,-1)";
        double aux[]=new double[2];
        for (int i=0;i<spsuj.length;i++){
          tablaval=MetodosFunciones.tablaGrafica(spsuj[i], 200, 0, 3);
          win2.addCurva(colores[i],tablaval);
          extr=MetodosFunciones.extremos(tablaval);
          if (extr[0]<aux[0]) aux[0]=extr[0];
          if (extr[1]>aux[1]) aux[1]=extr[1];
          win2.addEtiqueta(3,(i+2)*0.4, etiq[i], colores[i]);
        }
        win2.addEjesCoordenados(true,-0.5,3.5,aux[0]-(aux[1]-aux[0])/10.,aux[1]+(aux[1]-aux[0])/10.,0,0);
        win2.addListaPuntos(Color.red, datos1, 3);
        win2.repaint();
    }   
    
    

    
      
}
