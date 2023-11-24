/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entrega2;

import ORG.netlib.math.complex.Complex;
import auxiliar.MetodosListas;
import auxiliar.Polinomio;

/**
 *
 * @author salva
 */
public class Ejercicio3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Polinomio.ErrorPolinomios {
        // TODO code application logic here
    double DNI=27427479;
    double aux;
    double[] coefi=new double[7];
    for(int k=0;k<coefi.length;k++){
        coefi[k]=Math.pow(-1.,Math.floor(DNI/(k+1)));
        aux=(DNI*(k+1))%(Math.E+1.);
        coefi[k]=coefi[k]*aux;
    }
    Polinomio p=new Polinomio(coefi);
    System.out.println("p(x)="+p.escribe());
    double radio=p.radioRaices();
    double[] raicesreales=p.bisecSturm(1E-20, -radio, radio);
    Complex[] raices=new Complex[p.grado()];
    raices=p.buscaRaicesAleatorioPCR(1E-12, 100, 100);
    for (int k=0;k<raices.length;k++){
        System.out.println("raiz("+k+")="+raices[k]);
    }
    for (int k=0;k<raices.length;k++){
        System.out.println("p[raiz("+k+")]="+p.eval(raices[k]));
    }
    Polinomio q=Polinomio.construido(p.coef[p.grado()],raices);
        System.out.println("q(x)="+q.escribe());
        System.out.println("diferencia(x)="+p.resta(q).escribe());
    }
    
}
