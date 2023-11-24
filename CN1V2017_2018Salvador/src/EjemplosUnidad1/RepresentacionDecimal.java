/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EjemplosUnidad1;

/**
 *
 * @author antonio
 */
public class RepresentacionDecimal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int b=2; //base
        double d=0.125; //decimal
        
        int l= 52+2; //número de cifras decimales
        
        int[] digDecd=new int[l];
        
        double workd=d*b;
        String dbaseb="0,";
        for (int i = 0; i < l; i++) {
             digDecd[i]=(int) Math.floor(workd);
             workd= (workd - digDecd[i])*b;
             dbaseb=dbaseb + "¬" + digDecd[i];
        }
        
        System.out.println("d en base b -> "+ dbaseb);
        
        double testd=0;
        for (int i = l-1; i >=0; i--) {
            testd=(testd+digDecd[i])/b;
        }
        
        System.out.println("     d = "+ d + "\n testd = "+ testd);
        
        
        
        
        
    }
    
}















