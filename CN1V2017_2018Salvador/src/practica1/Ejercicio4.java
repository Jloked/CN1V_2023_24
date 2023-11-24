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
public class Ejercicio4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
      // Apartado 1.a 
      double bino = 1.;
      double suma;
      System.out.println("Cálculo de sqrt(2) con la serie binomial");
      System.out.println("1000 términos sumados");
      suma=1.;
      for(int n=1;n<1000;n++){
          bino=bino*(0.5-n+1)/n;
          suma=suma+bino;
      }
      System.out.println("Valor calculado="+suma);
      System.out.println("Error="+ Math.abs(suma*suma-2.));
      System.out.println("\nCálculo de sqrt(2) con la serie binomial");
      System.out.println("10000 términos sumados");
      suma=1.;
      bino=1.;
      for(int n=1;n<10000;n++){
          bino=bino*(0.5-n+1)/n;
          suma=suma+bino;
      }
      System.out.println("Valor calculado="+suma);
      System.out.println("Error="+ Math.abs(suma*suma-2.));

//    Aparatado 1.d  
      suma=0.;
      double sumaplus = 0.;
      double sumaminus = 0.;
      double[] sumandos = new double[1000];
      sumandos[0]=1.;
      System.out.println("\n\nSumando por paquetes; 1000 sumandos");
      bino=1.;
      for(int n=1;n<1000;n++){
          bino=bino*(0.5-n+1)/n;
          sumandos[n]=bino;
      }
      for (int i = sumandos.length - 1; i >= 0; i=i-2) {
          sumaminus=sumaminus+sumandos[i];}
      for (int i = sumandos.length - 2; i >= 0; i=i-2) {
          sumaplus=sumaplus+sumandos[i];}
     
      suma=sumaplus+sumaminus;
      System.out.println("Valor calculado="+ suma);
      System.out.println("Error="+ Math.abs(suma*suma-2.));

      bino=1.;
      sumaplus=0;
      sumaminus=0;
      sumandos = new double[10000];
      sumandos[0]=1;
      System.out.println("\n\n"+"Sumando por paquetes; 10000 sumandos");
      for(int n=1;n<10000;n++){
          bino=bino*(0.5-n+1)/n;
          sumandos[n]=bino;
      }

      for (int i = sumandos.length - 1; i >= 0; i=i-2) {
          sumaminus=sumaminus+sumandos[i];}
      for (int i = sumandos.length - 2; i >= 0; i=i-2) {
          sumaplus=sumaplus+sumandos[i];}

      suma=sumaplus+sumaminus;
      System.out.println("Valor calculado="+ suma);
      System.out.println("Error="+ Math.abs(suma*suma-2.));




//    Apartado 2
      System.out.println("\n \n" + "Cálculo de sqrt(2) con la serie binomial de (1+x)^(-1/2)");
      System.out.println("1000 términos sumados");
      bino=1.;
      suma=0.;     
      sumandos=new double[1000];
      sumandos[0]=1.;
      for(int n=1;n<1000;n++){
          bino=bino*(n-0.5)/(2*n);
          sumandos[n]=bino;
      }
      for (int i = sumandos.length - 1; i >= 0; i--) {          
          suma=suma + sumandos[i];
      }      
      System.out.println("Valor calculado = " + suma);
      System.out.println("Error = "+ Math.abs(suma*suma-2));

      System.out.println("10000 términos sumados");
      bino=1.;
      suma=0.;
      sumandos=new double[10000];
      sumandos[0]=1.;
      for(int n=1;n<sumandos.length;n++){
          bino=bino*(n-0.5)/(2*n);
          sumandos[n]=bino;
      }
      for (int i = sumandos.length - 1; i >= 0; i--) {          
          suma=suma + sumandos[i];
      }     
      System.out.println("Valor calculado = " + suma);
      System.out.println("Error = "+ Math.abs(suma*suma-2));


    //Apartado 3: Con BigDecimal

    
    System.out.println("\n \n"+ "Cálculo de sqrt(2) con el método de Newton");
    System.out.println("Utilizamos 1000 cifras significativas");
    MathContext mc = new MathContext(1000, RoundingMode.HALF_UP);
    BigDecimal B= new BigDecimal(1., mc);
    BigDecimal Bp = new BigDecimal(0., mc); //BigDecimal.ZERO;
    BigDecimal two = new BigDecimal(2.,mc);
    BigDecimal aux; //=new BigDecimal(1.,mc);
    int n=0;


    while ((B.compareTo(Bp)!=0) & (n<100)){
        Bp=B;
        B=two.divide(Bp, mc);
        B=B.add(Bp,mc);
        B=B.divide(two,mc);                       
        n++;
        System.out.println("Paso "+n);
        System.out.println(B);
    } 
    System.out.println("raíz de 2="+B);
    System.out.println("Error = " + B.multiply(B,mc).subtract(two,mc).abs(mc));
    }
}

