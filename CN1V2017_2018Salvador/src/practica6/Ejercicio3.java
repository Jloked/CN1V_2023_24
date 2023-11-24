/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica6;

import auxiliar.Funcion;
import auxiliar.MetodosFunciones;
import auxiliar.PolinomioInterpolador;

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
    int N=2;
    double[][] valores=new double[3][6];
    double aprox1,aprox2;
    double h;
    f1 f =new f1();
    E g = new E();
    for(int i=1;i<=6;i++){
        h=2*(1./N);
        valores[0][i-1]=MetodosFunciones.integralSimpson(f,0,1,N);
        valores[1][i-1]=MetodosFunciones.integralGauss(f, 0, 1, N);
        aprox1=MetodosFunciones.integralSimpson(f, 2*h, 1, N);
        aprox2=2.*Math.sqrt(2.*h)*(6.+8.*g.eval(h)+g.eval(2*h))/15.;
        valores[2][i-1]=aprox1+aprox2;
        N=2*N;
    }
    N=2;
    for(int i=1;i<=6;i++){     
        System.out.println("N="+N);
        System.out.print("    Simpson: "+ valores[0][i-1]);
        System.out.print("      Gauss: "+ valores[1][i-1]);
        System.out.println(" Tercer m: " + valores[2][i - 1]);
        N=2*N;
    }
    }
    
    public static class f1 implements Funcion{
        public  f1(){}
        
        public double eval(double x){
            if (x==0.) return 0;
            else return Math.exp(Math.sqrt(x))/Math.sqrt(x);
        }
    }
    
    public static class E implements Funcion{
        public  E(){}
        
        public double eval(double x){
            return Math.exp(Math.sqrt(x));
        }
    }
}
