/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica7;

import auxiliar.Polinomio;

/**
 *
 * @author salvaold
 */
public class Ejercicio6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Polinomio.ErrorPolinomios {
        // TODO code application logic here
                int n=11;
        Polinomio[] leg;
        leg=Polinomio.legendre(n);
        for (int k=0;k<=n;k++){
            System.out.println("L["+k+"]="+leg[k].escribe());
        }
        double x0;
        double[] raices=new double[n];
        double prec=1E-12;
        int maxit=30;
        Polinomio pol;
        for (int k=2;k<=n;k++){
            x0=1;
            pol=leg[k];
            System.out.println("\n\nRaíces de L["+k+"](x)");
            for (int j=0;j<k;j++){
                raices[j]=pol.newton(x0, prec, maxit);
                System.out.println("raiz["+j+"]="+raices[j]);
                pol=pol.deflacion(raices[j]);
                x0=raices[j];
//                  raices[j]=pol.newton(x0, prec*1E5, maxit);
////                  System.out.println("deflacion");
//                  raices[j]=leg[k].newton(raices[j], prec, maxit);
//                  System.out.println("raiz["+j+"]="+raices[j]);
//                pol=pol.deflacion(raices[j]);
//                x0=raices[j];
                }
            }
    }
}    
