/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica2;

import auxiliar.MetodosFunciones;
import auxiliar.PanelDibujo;
import java.awt.Color;
import javax.swing.WindowConstants;

/**
 *
 * @author salvaold
 */
public class Ejercicio3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
    PanelDibujo win1 = new PanelDibujo("Gráfica de f");
    Ejercicio1.F1 f = new Ejercicio1.F1();
    Ejercicio1.F2 g = new Ejercicio1.F2();
    int n=11;
    
    win1.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    
    double[][] tabla=MetodosFunciones.tablaGrafica(f, n,-5,5);
    win1.addCurva(Color.red, tabla);
    win1.addListaPuntos(Color.red, tabla, 3);
    win1.addEjesCoordenados(true,-5.5,5.5,-1,2.7);
    win1.repaint();
    
    PanelDibujo win2 = new PanelDibujo("Gráficas de f, g y f+g",100,100,800,600);
    win2.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    win2.addEjesCoordenados(true,-5.5,5.5,-9,10);
    win2.addCurva(Color.red,tabla);
    win2.addCurva(Color.pink,g,n,-5,5);
    win2.addCurva(Color.blue,new MetodosFunciones.suma(f,g),n,-5,5);
    double[] pos1={4.,4.};
    win2.addEtiqueta(pos1, "f", Color.red);
    double[] pos2={4.,5.};
    win2.addEtiqueta(pos2, "g", Color.pink);
    double[] pos3={4.,6.};
    win2.addEtiqueta(pos3, "f+g", Color.blue);
    win2.repaint();
    
    int ngraf=10;
    PanelDibujo win3 = new PanelDibujo("Gráficas de x^e^x, n=1...10",200,100,1000,800);
    win3.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    Color[] colores = new Color[ngraf];
    for(int i=0;i<ngraf;i++){      
        colores[i]=new Color(255-(int)256.*i/10,(int)256.*i/10,(int)2*256*i/(3*10));
//        float red=(i+1.f)/(ngraf+1);
//        float green =((13*i%(ngraf+1)+1.f))/(ngraf+1);
//        float blue  =((11*i%(ngraf+1)+1.f))/(ngraf+1);
//        colores[i]= new Color(red, green, blue);
    }
    win3.addEjesCoordenados(true,-2.5,2.5,-60,1000,0,0);
    double[][] poss=new double[10][2];
    for(int i=1;i<=10;i++){
        win3.addCurva(colores[i-1],new Ejercicio1.F3(i),100,-2,2);                
        poss[i-1][0]=-2.3;
        poss[i-1][1]=10.+(double)i*20;
        win3.addEtiqueta(poss[i-1],"n="+i,colores[i-1]);
    }
    }
    
}
