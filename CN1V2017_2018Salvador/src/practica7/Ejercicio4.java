/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica7;

import ORG.netlib.math.complex.Complex;
import auxiliar.MetodosListas;
import auxiliar.Polinomio;

/**
 *
 * @author salvaold
 */
public class Ejercicio4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Polinomio.ErrorPolinomios {       
        // TODO code application logic here
     
        double prec=1E-12;
        int maxit=200;
        Polinomio p=new Polinomio(new double[] {-2.,-5.,7.,-4.,1.});
        System.out.println("p(x)="+p.escribe()+"\n");
        System.out.println("Método de Laguerre");
        Complex cero;
        Complex[] ini= new Complex[3];
        ini[0]=Complex.cart(-2., 0.);
        ini[1]=Complex.cart(3.,0.);
        ini[2]=Complex.cart(1.,1.);
        for(int k=0;k<3;k++){
        System.out.println("x0="+ini[k]);
        cero=p.laguerre(ini[k], prec,maxit);
        System.out.println("cero="+cero+"   p(cero)="+p.eval(cero));
        }
        
        System.out.println("\nMétodo de Sturm");
        double radio=p.radioRaices();
        double[] ceros=p.bisecSturm(prec, -radio,radio);
        System.out.println("ceros: "+MetodosListas.toString(ceros));
        
        Polinomio q=new Polinomio(new double[] {3*Math.PI,-1,12,-12,0,-3,0,-1,25,-3,-12,1});
        Polinomio qd=q;
        System.out.println("\n\nq(x)="+q.escribe());
        radio=q.radioRaices();
        ceros=q.bisecSturm(prec, -radio, radio);
        System.out.println("ceros: "+MetodosListas.toString(ceros));
        for(int k=0;k<ceros.length;k++){
            qd=qd.deflacion(Complex.real(ceros[k]));            
        }
        Complex[] cerosa=qd.buscaRaicesAleatorioPCR(prec, maxit, 10);
        int n=ceros.length;
        n=n+cerosa.length;  
        System.out.println("Se han encontrado "+n+" raíces");
        Complex[] raices=new Complex[n];
        for(int k=0;k<ceros.length;k++){
            raices[k]=Complex.real(ceros[k]);
            System.out.println("raiz["+k+"]="+raices[k]);
        }
        for(int k=ceros.length;k<n;k++){
            raices[k]=cerosa[k-ceros.length];
            System.out.println("raiz["+k+"]="+raices[k]);
        }
        Polinomio qr=Polinomio.construido(Complex.real(1.),raices);
        Complex sum=new Complex();
        Complex aux;
        for(int k=0;k<q.grado();k++){
            aux=q.coef[k].mul(q.coef[k]);
            aux=aux.sub(qr.coef[k].mul(qr.coef[k]));
            sum=sum.add(aux);
        }
        System.out.println("Estimación del error="+sum.toString());
        
    }
//raiz[0]=(-1.5705825408258534 + 0.0i)
//raiz[1]=(1.3373016147124872 + 0.0i)
//raiz[2]=(12.077585865768924 + 0.0i)
//raiz[3]=(0.2042772641561029 + 0.8386043578445692i)
//raiz[4]=(0.2042772641561029 - 0.8386043578445692i)
//raiz[5]=(-0.20865627064889802 + 0.6844968887696559i)
//raiz[6]=(-0.20865627064889802 - 0.6844968887696559i)
//raiz[7]=(0.9057216569526801 - 0.4028761379490265i)
//raiz[8]=(0.9057216569526801 + 0.4028761379490265i)
//raiz[9]=(-0.8234951202876892 + 0.5578824843311155i)
//raiz[10]=(-0.8234951202876892 - 0.5578824843311155i)
//Estimación del error=(0.1262270599511235 - 4.007505158703904E-14i)
}
    

