

package auxiliar;

import ORG.netlib.math.complex.Complex;

/**
 *
 * @author apall para CN 1v del curso 2012/2013
 */
public class PolinomioInterpolador extends Polinomio{

    double[] coefFormaNewton;
    double[] nodos;
    public Object derivada;

    public PolinomioInterpolador(double[][] xy) {
        coefyNodos(xy);
        coeficientesPol();

    }

    public PolinomioInterpolador() {
        coefFormaNewton=new double[1];
        nodos=new double[1];
        coef =new Complex[1];
    }

     void coefyNodos(double[][] xy){
        int m=xy.length-1;   
        int[] aux =new int[m+2];
        aux[0]=0;
         for (int i = 0; i <= m; i++) {
             aux[i+1]=aux[i]+xy[i].length-1;
             // aquí habría que controlar que los datos vienen bien l[i]>=0
             // de momento prometemos pasarlos bien.
         }
        int N= aux[m+1]-1;
        nodos = new double[N+1];  //nodos = lista u de las notas
        coefFormaNewton =new double[N+1]; //coefFormaNewton = lista p de las notas
        
        // incluye el codigo necesario para asignar los valores de los nodos
        // y los coeficientes de la forma de Newton del polinomio interpolador
        // de Hermite correspondiente a la lista de puntos xy
        // utilizando el algoritmo de las diferencias divididas de Newton    
        for(int i=0; i<=m; i++){
            for(int j=aux[i]; j<aux[i+1];j++){
               nodos[j]=xy[i][0]; 
            }
        }

        for(int k=0; k<=N;k++){
            for(int i=m;i>=0;i--){
                for(int j=aux[i+1]-1;j>=Math.max((double)aux[i],(double)k);j--){
                    if (nodos[j-k]==nodos[j]) {
                     coefFormaNewton[j]=xy[i][k+1];
                     for (int r=1;r<=k;r++) coefFormaNewton[j]=coefFormaNewton[j]/r;
                    }
                    else{
                        coefFormaNewton[j]=(coefFormaNewton[j]-coefFormaNewton[j-1])/(nodos[j]-nodos[j-k]);
                    }
                }
            }
        }
         System.out.println("Coeficientes newton"+MetodosListas.toString(coefFormaNewton)); 
    }
      




    @Override
    public double eval(double x){
        int m= coefFormaNewton.length;
        double eval;   
        //incluye el codigo necesario para hacer la evaluacion del polinomio
        // en x utilizando la formula anidada de la forma de Newton.        
        eval=coefFormaNewton[m-1];
        for (int i=m-2;i>=0;i--){
            eval=coefFormaNewton[i]+(x-nodos[i])*eval;
        }
        return eval;
    }
    
  


    void coeficientesPol(){
        int m=coefFormaNewton.length;
        coef = new Complex[m];
        for (int i = 0; i < m; i++) {
             coef[i]=new Complex();
        }      
        for (int i = m-1; i >=0; i--) {
            Complex auxiliar=new Complex(coefFormaNewton[i]);
            for (int k = m-1-i; k >=1; k--) {
                coef[k]=coef[k-1].sub(coef[k].scale(nodos[i]));
            }
            coef[0]=auxiliar.sub(coef[0].scale(nodos[i]));
        }

    }
    
    public double[] evalDerivadas(double x, int n){
        int m=this.grado();
        double[][] alpha=new double[m+1][n+1];
        
        if (n>m) {
            for (int k=m+2; k<=n; k++)
                alpha[0][k]=0.;
        }
        alpha[m][0]=this.coefFormaNewton[m];
        for(int k=m-1;k>=0;k--){
            alpha[k][0]=this.coefFormaNewton[k]+alpha[k+1][0]*(x-this.nodos[k]);
        }
        for(int j=1;j<=Math.min(n,m);j++){
            for (int k=m;k>=0;k--){
                if (j+k>m) {
                    alpha[k][j]=0.;
                    continue;
                }
                alpha[k][j]=j*alpha[k+1][j-1]+alpha[k+1][j]*(x-this.nodos[k]);
            }
        }
        return alpha[0];
    }

}

