package EjemplosUnidad1;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author antonio
 */
public class MaximoComunDivisor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        long n= 35478973;
        long m=178932571;
        
        long tini=System.currentTimeMillis();
        long d=mcd(m, n);
        long tfin=System.currentTimeMillis();
        System.out.println("mcd( "+m+" , "+n + " ) = \n "+ d);
        System.out.println("encontrado en "+ (tfin-tini) + " milisegundos ");
        
        tini=System.currentTimeMillis();
        d=mcdEuclidesIt(m, n);
        tfin=System.currentTimeMillis();
        System.out.println("mcdEuclidesIt( "+m+" , "+n + " ) = \n "+ d);
        System.out.println("encontrado en "+ (tfin-tini) + " milisegundos ");
        
        tini=System.currentTimeMillis();
        d=mcdEuclidesRecursivo(m, n);
        tfin=System.currentTimeMillis();
        System.out.println("mcdEuclidesRecursivo( "+m+" , "+n + " ) = \n "+ d);
        System.out.println("encontrado en "+ (tfin-tini) + " milisegundos ");
        
    }
    
    
    public static long  mcd(long m,long n){
        long wm=m, wn=n;
        long d=1;
        if(wm<wn){wm=n;wn=m;}
        for (long k = 2; k <=wn; k++) {
            if((wn%k==0) && (wm%k==0)){
                d=k;
            }
        }
        return d;
    }
    
    public static long mcdEuclidesIt(long m,long n){
        long wm=m, wn=n;
        long d=1;
        if(wm<wn){wm=n;wn=m;}
        while(wn != 0){
            long aux = wn;
            wn = wm % wn;
            wm = aux;
        }
        return wm;
    }
    
    public static long mcdEuclidesRecursivo(long m,long n){
        
         if( m == 0 ){
             return n;
         }
         if( n == 0 ){
             return m;
         }
         return mcdEuclidesRecursivo(n, m%n);
    }
    
    
}
