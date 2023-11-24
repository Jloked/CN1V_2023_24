/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EjemplosUnidad1;

/**
 *
 * @author antoniojosepallaresruiz
 */
public class Ejercicio1_2multplo01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int n= 257;//17117;
        int k=1;
        long m=1;
        while(m%n > 0 && m > 0 ){
            k++;
            // vamos a ir calculando los dígitos de la representación de k en base 2
            // y con ellos construiremos el número nk formado por los mismos dígitos 
            // en base 10.
            int aux=k;
            m=0;
            long pow10=1;
            while(aux > 0 ){
                int d=aux%2;
                aux=aux/2;
                m += d*pow10;
                pow10 *= 10;
            }
            //if(nk%10 !=0 && nk%10 != 1) break;
            System.out.println("     k = "+ k);
            System.out.println("    m = "+ m);
            System.out.println("m % n = "+ (m%n) + " \n ");
        }
        System.out.println("Si no nos hemos salido "
                + "de los int \n  n_k = "+ m );
        
        
        
        
    }
    
}
