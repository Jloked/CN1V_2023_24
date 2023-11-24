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
public class RepresentacionEnteros {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       int P=157987;
       int b=17;
       
       int n=(int) Math.floor(Math.log(P)/Math.log(b));
       int[] digPbaseb=new int[n+1];
       int workP=P;
       String Pbaseb="";
       
        for (int i = 0; i <=n; i++) {
            digPbaseb[i]=workP % b;
            workP=workP / b;
            Pbaseb = digPbaseb[i]+"¬"+Pbaseb;   
        }
        System.out.println("P en base "+ b + " = "+ Pbaseb);
        
        int testP=0;
        for (int i = n; i >= 0; i--) {
            testP=testP*b + digPbaseb[i];
        }
        System.out.println("P = p"+ "\t testP==P ->"+ (testP==P));
        
        
        
        
        
        
        
        
        
    }
    
}
