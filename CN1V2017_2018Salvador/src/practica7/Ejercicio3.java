/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica7;
import auxiliar.*;

/**
 *
 * @author antonio
 */
public class Ejercicio3 {

    public static class Fmultiple implements FuncionDeriv{
        int k;
        public Fmultiple(int k){
            this.k=k;
        }
       public double eval(double x){
           return Math.pow(Math.exp(x)-x*x+2*x-1-Math.E,k);
       }
       public double derivada(double x){
           return k * Math.pow(Math.exp(x)-x*x+2*x-1-Math.E,k-1) * (Math.exp(x)-2*x+2);
       }
    }
    
    public static class Fpuntofijo implements Funcion{
        FuncionDeriv f;
        public Fpuntofijo(FuncionDeriv f){
            this.f=f;
        }
        public double eval(double x){
            return x- f.eval(x)/f.derivada(x);
        }
    }
    
    public static class RedMultiple implements FuncionDeriv{
        FuncionDeriv f;
        double h;
        public RedMultiple(FuncionDeriv f, double h){
            this.f=f;
            this.h=h;
        }
        public double eval(double x){
            return f.eval(x)/f.derivada(x);
        }
        public double derivada(double x){
            return (this.eval(x+h)-this.eval(x-h))/(2*h);
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws MetodosEcuacionNoLineal.ERROR {
        // TODO code application logic here
        int k=5;
       
        Fmultiple f=new Fmultiple(k);
        double h=0.1;
        Fpuntofijo F=new Fpuntofijo(f);
        RedMultiple g= new RedMultiple(f, h);
        double xini=0.8;
        double xinii=0.7;
        int nmax=200;
        double prec=0.5E-10;
        double cero=MetodosEcuacionNoLineal.newton(f, xini, prec, nmax);
        cero=MetodosEcuacionNoLineal.secante(f, xinii, xini, prec, nmax);
        
        try{
            cero=MetodosEcuacionNoLineal.steffensenPF(F, xini, prec, nmax);
        }catch(MetodosEcuacionNoLineal.ERROR err){
            
        }
        
        cero=MetodosEcuacionNoLineal.newton(g, xini, prec, nmax);
    }
    
}
