/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ExpedientesX;

/**
 *
 * @author Antonio
 */
public class ExpedienteXNo6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        // Explica los resultados de las siguientes instrucciones.
        double[] a = {12.6, 2.3, 6.28};
        double[] c = cambiar(a);
        //double[] d = nocambiar(a);
        System.out.println(c[0]);
        System.out.println(c[1]);
        System.out.println(c[2]);
        //System.out.println(d[0]);
    }

    public static double[] cambiar(double[] b) {
        double[] c = new double[b.length];
        c=b;
        c[0] = 3455.23;
        return c;
    }

    //public static double[] nocambiar(double[] d) {
    //    double[] e = new double[d.length];
    //    e = d;
    //    return e;
    //}
}
