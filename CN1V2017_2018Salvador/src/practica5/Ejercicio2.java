/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica5;

import auxiliar.Funcion;
import auxiliar.MetodosFunciones;
import auxiliar.PanelDibujo;
import auxiliar.Spline;
import java.awt.Color;
import javax.swing.WindowConstants;

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
        int N=9;
        double[][] datosx=new double[N][2];
        double[][] datosy=new double[N][2];
        double[] datost=new double[N];
        double a=0;
        double b=4*Math.PI;
        espx cx=new espx();
        espy cy=new espy();
        double[] extrx;
        double[] extry;
        double[][] pplano=new double[N][2];
//      
        double h=(b-a)/(N-1);
        for(int i=0;i<N;i++){
            datost[i]=a+i*h;
            datosx[i][0]=datost[i];
            datosy[i][0]=datost[i];
            datosx[i][1]=cx.eval(datost[i]);
            datosy[i][1]=cy.eval(datost[i]);
            pplano[i][0]=datosx[i][1];
            pplano[i][1]=datosy[i][1];
        }
        extrx=MetodosFunciones.extremos(datosx);
        extry=MetodosFunciones.extremos(datosy);

        Spline spnatx=new Spline(datosx);
        Spline spnaty=new Spline(datosy);
        PanelDibujo win1=new PanelDibujo("Espiral de Arquímedes con splines naturales",0,0,700,600);
        win1.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);        
        win1.addEjesCoordenados(false, extrx[0]-5,extrx[1]+5,extry[0]-5,extry[1]+5,0,0);
        win1.addCurva(Color.red, spnatx, spnaty,200, a, b);
        win1.addCurva(Color.blue, cx, cy,200, a, b);
        win1.addListaPuntos(Color.red, pplano, 3);
        win1.repaint();

        Spline spsujx=new Spline(datosx,2.,2.);
        Spline spsujy=new Spline(datosy,0.,8*Math.PI);
        PanelDibujo win2=new PanelDibujo("Espiral de Arquímedes con splines sujetos",100,100,800,700);
        win2.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);       
        win2.addEjesCoordenados(false, extrx[0]-5,extrx[1]+5,extry[0]-5,extry[1]+5,0,0);
        win2.addCurva(Color.red, spsujx, spsujy,200, a, b);
        win2.addCurva(Color.blue, cx, cy,200, a, b);
        win2.addListaPuntos(Color.red, pplano, 3);
        win2.repaint();
        
        // Cardioide:
        double bc=2*Math.PI;
        double[][] datoscx=new double[N][2];
        double[][] datoscy=new double[N][2];
        double[] datosct=new double[N];
        cardx cdx=new cardx(2);
        cardy cdy=new cardy(2);
        double[][] pplanoc=new double[N][2];
        double hc=(bc-a)/(N-1);
        for(int i=0;i<N;i++){
            datosct[i]=a+i*hc;
            datoscx[i][0]=datosct[i];
            datoscy[i][0]=datosct[i];
            datoscx[i][1]=cdx.eval(datosct[i]);
            datoscy[i][1]=cdy.eval(datosct[i]);
            pplanoc[i][0]=datoscx[i][1];
            pplanoc[i][1]=datoscy[i][1];
        }
        extrx=MetodosFunciones.extremos(datoscx);
        extry=MetodosFunciones.extremos(datoscy);

        Spline cdnatx=new Spline(datoscx);
        Spline cdnaty=new Spline(datoscy);
        PanelDibujo win3=new PanelDibujo("Cardioide con splines naturales",200,200,800,800);
        win3.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);        
        win3.addEjesCoordenados(false, extrx[0]-5,extrx[1]+5,extry[0]-5,extry[1]+5,0,0);
        win3.addCurva(Color.red, cdnatx, cdnaty,200, a, b);
        win3.addCurva(Color.blue, cdx, cdy,200, a, b);
        win3.addListaPuntos(Color.red, pplanoc, 3);
        win3.repaint();

        Spline cdsujx=new Spline(datoscx,0.,0.);
        Spline cdsujy=new Spline(datoscy,0.,0.);
        PanelDibujo win4=new PanelDibujo("Cardioide con splines sujetos",300,300,900,900);
        win4.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);       
        win4.addEjesCoordenados(false, extrx[0]-5,extrx[1]+5,extry[0]-5,extry[1]+5,0,0);
        win4.addCurva(Color.red, cdsujx, cdsujy,200, a, b);
        win4.addCurva(Color.blue, cdx, cdy,200, a, b);
        win4.addListaPuntos(Color.red, pplanoc, 3);
        win4.repaint();
    }
    
    public static class espx implements Funcion{
    
    public espx(){}
    
    public double eval(double x){
        return 2*x*Math.cos(x);
    }
    }
    public static class espy implements Funcion{
    
    public espy(){}
    
    public double eval(double x){
        return 2*x*Math.sin(x);
    }
    }
    
    public static class esplx implements Funcion{
    
    public esplx(){}
    
    public double eval(double x){
        return Math.pow(1.5, x)*Math.cos(x);
    }
    }
    public static class esply implements Funcion{
    
    public esply(){}
    
    public double eval(double x){
        return Math.pow(1.5, x)*Math.sin(x);
    }
    }
    
    public static class cardx implements Funcion{
        double par;
        
    public cardx(double a){
        par=a;       
        }
    
    public double eval(double x){
        return 2.*par*(1.-Math.cos(x))*Math.cos(x);
    }
    }
    public static class cardy implements Funcion{
        double par;
    
    public cardy(double a){
        par=a;
    }
    
    public double eval(double x){
        return 2.*par*(1.-Math.cos(x))*Math.sin(x);
    }
    }

}
