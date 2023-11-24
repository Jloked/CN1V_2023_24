/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica3;
import auxiliar.Funcion;
import auxiliar.Polinomio;
import auxiliar.MetodosFunciones;
import auxiliar.PanelDibujo;
import java.awt.Color;
import javax.swing.WindowConstants;


/**
 *
 * @author salva
 */
public class Ejercicio3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // TODO code application logic here
        
        
        double[] tablax={1.5,2.7,3.1,-2.1,-6.6,11.};
        double[] tablay={0.,1.,-0.5,1.,0.5,0.};
        Polinomio[] pol;
        pol=Polinomio.facLagrange(tablax);   
        Polinomio interp=new Polinomio(0.);
        for(int i=0;i<tablax.length;i++){
            interp=interp.suma(pol[i].producto(tablay[i]));
        }
        System.out.println("P(x) = "+interp.escribe());
        for(int i=0;i<tablax.length;i++){
            System.out.println("p("+tablax[i]+") = "+interp.eval(tablax[i]));
        }
        
        
       //Apartado 2 
       F f = new  F();
       int n=13;
       double[][] tabla=MetodosFunciones.tablaGrafica(f,n, 0.,1.);
       double[] absc = new double[n];
       double[] orden = new double[n];
       for(int i=0;i<n;i++){
           absc[i]=tabla[i][0];
           orden[i]=tabla[i][1];
       }
       interp= new Polinomio(0.);             
       pol=Polinomio.facLagrange(absc);
       for(int i=0;i<n;i++){
            interp=interp.suma(pol[i].producto(orden[i]));
        }

       System.out.println(interp.escribe());
       PanelDibujo win = new PanelDibujo("Interpolacion de sen(pi*x^2)");
       
       win.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
       win.addCurva(Color.red, MetodosFunciones.tablaGrafica(f, 100, 0., 1.));
       win.addCurva(Color.blue, interp, 100, 0., 1.);      
       win.addListaPuntos(Color.blue, tabla, 3);
       win.addEjesCoordenados(true, -0.1, 1.1, -0.2, 1.3, 0., 0.);
       win.repaint();
       
          
        
    }
    
    public static class F implements Funcion {
        
        public F(){};
        
        @Override
        public double eval(double x){
            return Math.sin(Math.PI*x*x);
        }
        
    }
    
}
