/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

/**
 *
 * @author salvaold
 */
public class Ejercicio3b {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         int precision=4;
        MathContext mc=new MathContext(precision,RoundingMode.HALF_EVEN);
        //Apartado 1.
        System.out.println("Apartado 1");
        BigDecimal a=new BigDecimal("0.6688",mc);
        BigDecimal b=new BigDecimal("0.3334",mc);
        System.out.println("a="+a+"  b="+b);
        System.out.println("a+b="+a.add(b,mc));
        a=new BigDecimal("1000",mc);
        b=new BigDecimal("0.05001",mc);
        System.out.println("a="+a+"  b="+b);
        System.out.println("a-b="+a.subtract(b,mc));
        a=new BigDecimal("2.000",mc);
        b=new BigDecimal("0.6667",mc);
        System.out.println("a="+a+"  b="+b);
        System.out.println("a*b="+a.multiply(b,mc));
        a=new BigDecimal("25.00",mc);
        b=new BigDecimal("16.00",mc);
        System.out.println("a="+a+"  b="+b);
        System.out.println("a/b="+a.divide(b,mc));
        
        // apartado 2.
        System.out.println("\nApartado 2");
        a=new BigDecimal("0.6688",mc);
        b=new BigDecimal("0.3334",mc);
        BigDecimal c=new BigDecimal("0.0004",mc);
        System.out.println("a="+a+",  b="+b+",   c="+c);
        System.out.println("(a+b)+c="+c.add(a.add(b,mc),mc));
        System.out.println("a+(b+c)="+a.add(b.add(c,mc),mc));
        
        //Apartado 3
        System.out.println("\nApartado 3");
        a=new BigDecimal("1000",mc);
        b=new BigDecimal("0.05001",mc);
        System.out.println("a="+a+"  b="+b);
        System.out.println("a-b="+a.subtract(b,mc));
        b=new BigDecimal("0.06",mc);
        System.out.println("a="+a+"  b="+b);
        System.out.println("a-b="+a.subtract(b,mc));
        
        //Apartado 4
        System.out.println("\nApartado 4");
        a=new BigDecimal("2",mc);
        b=new BigDecimal("5.5",mc);
        c=new BigDecimal("5.533",mc);
        System.out.println("a="+a+",  b="+b+",   c="+c);
        System.out.println("a*b="+a.multiply(b,mc));
        System.out.println("a*c="+a.multiply(c,mc));
        System.out.println("b+c="+b.add(c,mc));
        System.out.println("a*(b+c)="+a.multiply(b.add(c,mc),mc));
        System.out.println("(a*b)+(a*c)="+a.multiply(c,mc).add(a.multiply(b,mc),mc));
        
        //Apartado 5
        // Como el coeficiente de x es par, usamos la expresión (-b+-sqrt(b^2-ac))/a
        System.out.println("\nApartado 5");
        b=new BigDecimal("400",mc);
//        c=new BigDecimal("1",mc);
        c=BigDecimal.ONE;
        BigDecimal raiz,raiz1,raiz2;
        System.out.println("Cálculo con la fórmula directa, precisión:4");
        raiz=b.multiply(b,mc).subtract(c,mc);
        raiz=new BigDecimal(Math.sqrt(raiz.doubleValue()),mc);
        raiz1=raiz.subtract(b,mc);        
        System.out.println("Raíz_1="+raiz1);       
        raiz=b.multiply(b,mc).subtract(c,mc);
        raiz=new BigDecimal(Math.sqrt(raiz.doubleValue()),mc);
        raiz=raiz.add(b,mc);
        raiz2=raiz.negate();
        System.out.println("Raíz_2="+raiz2);
        System.out.println("Término independiente, aproximado="+raiz1.multiply(raiz2,mc));
        System.out.println("Cálculo con la fórmula modificada, tras utilizar el conjugado; precisión:4");
        raiz=b.multiply(b,mc).subtract(c,mc);
        raiz=new BigDecimal(Math.sqrt(raiz.doubleValue()),mc);
        raiz=raiz.add(b,mc);
        raiz=raiz.negate(mc);
        raiz1=c.divide(raiz,mc);
//        raiz=c.negate();
        System.out.println("Raíz_1="+raiz1);
        System.out.println("Término independiente, aproximado="+raiz1.multiply(raiz2,mc));
        
        System.out.println("\nCálculo con double");
        double B=400.;
        double C=1.;
        double Raiz1,Raiz2;
        Raiz1=Math.sqrt(B*B-C);
        Raiz1=Raiz1-B;
        System.out.println("Raiz1="+ Raiz1);
        Raiz2=-Math.sqrt(B*B-C);
        Raiz2=Raiz2-B;
        System.out.println("Raiz2="+ Raiz2);
        System.out.println("Término independiente, aproximado="+Raiz1*Raiz2);
    }
    
}
