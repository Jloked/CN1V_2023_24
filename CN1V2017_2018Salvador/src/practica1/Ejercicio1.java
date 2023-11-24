/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1;

/*
Si se igualan dos referencias a un array no se copia el array, sino que se tiene un array
con dos nombres, ambos apuntan al mismo y único objeto.
*/
/**
 *
 * @author salvaold
 */
public class Ejercicio1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        // Explica los resultados de las siguientes instrucciones.
        double[] a = {12.6, 2.3, 6.28};
        double[] c=cambiar(a);
        double[] d=nocambiar(a); 
//        System.out.println(a[0]);
        System.out.println(c[0]);
        System.out.println(d[0]);       
    }
    public static double[] cambiar(double[] b) {
        double[] c;
        c = b;
        c[0] = 3455.23;
        return c;
        }
    public static double[] nocambiar(double[] d) {
        double[] e;
        e = d;
        return e;
        }

   
    public static double[] cambiarb(double[] b) {
        double[] c = new double[b.length];
        for(int i=0;i<c.length;i++) c[i]=b[i];       
        c[0] = 3455.23;
        return c;
        }
    public static double[] cambiarc(double[] b){
        double[] c= new double[b.length];
        System.arraycopy(b, 0, c, 0, b.length);
        c[0]=3455.23;
        return c;
    }
 }
