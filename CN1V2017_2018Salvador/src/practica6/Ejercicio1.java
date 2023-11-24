/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica6;

import auxiliar.Funcion;
import auxiliar.MetodosFunciones;
import auxiliar.PanelDibujo;
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.WindowConstants;

/**
 *
 * @author salvaold
 */
public class Ejercicio1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here   
        double a=0;
        double b=1;
        double[][] tabla;
        fChang f=new fChang();
        int numptos=400;
        double[] ext;
        double inc=0.2;
        PanelDibujo winf=new PanelDibujo("La función de Chang",0,0,600,400);
        winf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); 
        tabla=MetodosFunciones.tablaGrafica(f, numptos, a, b);
        ext=MetodosFunciones.extremos(tabla);
        winf.addEjesCoordenados(true, a-inc*(b-a), b+inc*(b-a), ext[0]-inc*(ext[1]-ext[0]), ext[1]+inc*(ext[1]-ext[0]), 0, 0);
        winf.addCurva(Color.red,tabla);
        winf.repaint();
        
        pderfChang fp=new pderfChang();
        MetodosFunciones.derivada5puntos fpapp1=new MetodosFunciones.derivada5puntos(f,0.01);
        MetodosFunciones.derivada5puntos fpapp2=new MetodosFunciones.derivada5puntos(f,0.001);
        PanelDibujo windf=new PanelDibujo("La primera derivada de la función de Chang",650,0,1250,400);
        windf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); 
        tabla=MetodosFunciones.tablaGrafica(fp,numptos,a,b);
        ext=MetodosFunciones.extremos(tabla);
        windf.addEjesCoordenados(true, a-inc*(b-a), b+inc*(b-a), ext[0]-inc*(ext[1]-ext[0]), ext[1]+inc*(ext[1]-ext[0]), 0, 0);
        windf.addCurva(Color.red,tabla);       
        windf.addCurva(Color.orange,fpapp1,numptos,a,b);
        windf.addCurva(Color.magenta,fpapp2,numptos,a,b);
        windf.repaint();
        
        sderfChang fpp=new sderfChang();
        MetodosFunciones.derivada5puntos fppapp1=new MetodosFunciones.derivada5puntos(fp,0.01);
        MetodosFunciones.derivada5puntos fppapp2=new MetodosFunciones.derivada5puntos(fp,0.001);
        MetodosFunciones.derivada5puntos fppapp3=new MetodosFunciones.derivada5puntos(fp,0.0001);
        PanelDibujo winddf=new PanelDibujo("La segunda derivada de la función de Chang",0,650,600,1050);
        winddf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); 
        tabla=MetodosFunciones.tablaGrafica(fpp,numptos,a,b);
        ext=MetodosFunciones.extremos(tabla);
        winddf.addEjesCoordenados(true, a-inc*(b-a), b+inc*(b-a), ext[0]-inc*(ext[1]-ext[0]), ext[1]+inc*(ext[1]-ext[0]), 0, 0);
        winddf.addCurva(Color.red,tabla);       
        winddf.addCurva(Color.orange,fppapp1,numptos,a,b);
        winddf.addCurva(Color.magenta,fppapp2,numptos,a,b);
        winddf.addCurva(Color.blue,fppapp3,numptos,a,b);
        winddf.repaint();
        
//        fChangsc g=new fChangsc();
//        PanelDibujo winp=new PanelDibujo("Zoom",0,650,600,1050);
//        winp.addWindowListener(
//                new WindowAdapter() {
//
//                    @Override
//                    public void windowClosing(WindowEvent e) {
//                        System.exit(0);
//                    }
//                });
//        tabla=MetodosFunciones.tablaGrafica(g,numptos,0.9,1);
//        ext=MetodosFunciones.extremos(tabla);
//        winp.addEjesCoordenados(true, 0.89,1.01, ext[0]-inc*(ext[1]-ext[0]), ext[1]+inc*(ext[1]-ext[0]), 0.9,ext[0]);
//        winp.addCurva(Color.red,tabla); 
    }
    
    
    
    public static class fChang implements Funcion{
        int extsuma=100;
        
        public fChang(){}
        
        public fChang(int n){
        extsuma=n;
        }
        
        @Override
        public double eval(double x){
            double pi=Math.PI;
            double suma=0;
            
            for (int k=extsuma;k>=1;k--){
                suma=suma+Math.sin(2.*pi*k*k*x)/(k*k*k*k*k*4.*pi*pi)+x*x/(2.*k);
            }
        return suma;
        }
    }
    
    
    public static class pderfChang implements Funcion{
        int extsuma=100;
        
        public pderfChang(){}
        
        public pderfChang(int n){
        extsuma=n;
        }
        
        @Override
        public double eval(double x){
            double pi=Math.PI;
            double suma=0;
            
            for (int k=extsuma;k>=1;k--){
                suma=suma+Math.cos(2.*pi*k*k*x)/(k*k*k*2.*pi)+x/(double)k;
            }
        return suma;
        }
    }
    
    
    
    public static class sderfChang implements Funcion{
        int extsuma=100;
        
        public sderfChang(){}
        
        public sderfChang(int n){
        extsuma=n;
        }
        
        @Override
        public double eval(double x){
            double pi=Math.PI;
            double suma=0;
            
            for (int k=extsuma;k>=1;k--){
                suma=suma-Math.sin(2.*pi*k*k*x)/(double)k+1./(double)k;
            }
        return suma;
        }
    }    
    
}
