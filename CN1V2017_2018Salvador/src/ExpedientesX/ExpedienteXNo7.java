/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ExpedientesX;

/**
 *
 * @author Antonio
 */
public class ExpedienteXNo7 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("OJO CON LAS EVALUACIONES DE N! ");
        int mul = 1; //prueba también escribiendo long o double en lugar de int
        for (int i = 1; i < 32; i++) {
            mul = mul * 2;
            System.out.println("2^"+ i + "= " + mul);
        }
    }
}
