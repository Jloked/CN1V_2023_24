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
public class Ejercicio3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int precision=20;
        int precisionb=30;
        MathContext mc=new MathContext(precision,RoundingMode.HALF_EVEN);
        MathContext mcb=new MathContext(precisionb,RoundingMode.HALF_EVEN);
        System.out.println("Math.PI ="+Math.PI);
        BigDecimal a=new BigDecimal(Math.PI, mc);
        BigDecimal b=new BigDecimal(Math.PI, mcb);
        System.out.println("BigDecimal a = " + a);
        System.out.println("BigDecimal b = " + b);
        System.out.println("Math.PI - BigDecimal a = " + (Math.PI - a.doubleValue()));
        System.out.println("Bigdecimal b - BigDecimal a = " + b.subtract(a,mcb));
    }
    
}
