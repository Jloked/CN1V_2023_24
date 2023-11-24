/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package auxiliar;

import java.util.LinkedList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 *
 * @author antoniopallaresruiz
 */
public class MetodosFunciones {




    public static double[][] tablaGrafica(Funcion f,int numpuntos, double a, double b){
        double[][] tabla=new double[numpuntos][2];
        for (int i = 0; i < tabla.length; i++) {
            tabla[i][0]=a+i*(b-a)/(numpuntos-1);
            tabla[i][1]=f.eval(tabla[i][0]);

        }
        return tabla;
    }
    
    public static double[] extremos(double[][] tablaVal){
        double[] extremos={0,0};
        double max=tablaVal[0][0];
        double min=tablaVal[0][0];
        for (int i=1;i<tablaVal.length;i++){
            if (max<tablaVal[i][1]) max=tablaVal[i][1];
            else if (min>tablaVal[i][1]) min=tablaVal[i][1];
        }
        extremos[0]=min;
        extremos[1]=max;
        return extremos;
    }
    
    public static double[] extremos(Funcion f, int n, double a, double b){
        double[][] tabla=tablaGrafica(f,n,a,b);
        return extremos(tabla);
    }
    
    
    public static class suma implements Funcion{
        Funcion f;
        Funcion g;

        public suma(Funcion f1,Funcion g1){
            f=f1;
            g=g1;
        }
        public double eval(double x){
            return f.eval(x)+g.eval(x);
        }
    }
    
    public static class diferencia implements Funcion {
        Funcion f;
        Funcion g;
        
        public diferencia(Funcion f1,Funcion g1){
            f=f1;
            g=g1;
        }
            
        public double eval(double x){
            return f.eval(x)-g.eval(x);
        }                    
    }

    public static class producto implements Funcion {
        Funcion f;
        Funcion g;
        
        public producto(Funcion f1,Funcion g1){
            f=f1;
            g=g1;
        }
            
        public double eval(double x){
            return f.eval(x)*g.eval(x);
        }                    
    }
    
    public static class composicion implements Funcion {
        Funcion f;
        Funcion g;
        
        public composicion(Funcion f1,Funcion g1){
            f=f1;
            g=g1;
        }
            
        public double eval(double x){
            return g.eval(f.eval(x));
        }                    
    }
    
    public static class absError implements Funcion {
        Funcion f;
        Funcion g;
        public  absError(Funcion f1,Funcion g1){
        f=f1;
        g=g1;
        }
        
        
        @Override
        
        public double eval(double x) {
         return Math.abs(f.eval(x)-g.eval(x));   
        }
        
    }
    
    public static double[][] tablaGraficaTchev(Funcion f,int N, double a, double b){
        double[][] tabla=new double[N][2];
        for (int i = 0; i < tabla.length; i++) {
            tabla[i][0]=a+(Math.cos((2*i+1)*Math.PI/(2*N))+1)/2*(b-a);
            tabla[i][1]=f.eval(tabla[i][0]);

        }
        return tabla;
    }
    
    public static class derivada3puntos implements Funcion{
        Funcion f;
        double h; //paso
        public derivada3puntos(Funcion f, double h){
            this.f=f;
            this.h=h;
        }
        @Override
        public double eval(double x){
            return (f.eval(x+h)-f.eval(x-h))/(2*h);
        }
    }
    
    public static class derivada3puntosR implements Funcion{
        Funcion f;
        double h; //paso
        public derivada3puntosR(Funcion f, double h){
            this.f=f;
            this.h=h;
        }
        @Override
        public double eval(double x){
            return (-3*f.eval(x)+4*f.eval(x+h)-f.eval(x+2*h))/(2*h);
        }
    }
    
    public static class derivada5puntos implements Funcion{
        Funcion f;
        double h; //paso
        public derivada5puntos(Funcion f, double h){
            this.f=f;
            this.h=h;
        }
        @Override
        public double eval(double x){
            double y;
            y=(f.eval(x-2.*h)-8.*f.eval(x-h)+8.*f.eval(x+h)-f.eval(x+2.*h))/(12.*h);
            return y;
        }
    }
    public static class derivadaK3 implements Funcion{
        int N;
        int orden;
        double[] nodos;
        double deriv;
        double paso;
        double[][][] pesos;
        Funcion func;
        public derivadaK3(Funcion f, int k, double h){
            func=f;
            paso=h;
            orden=k;
            N=2*Math.floorDiv(k,2)+4;
            nodos=new double[N+1];            
            pesos=new double[orden+1][N+1][N+1];            
            }
        
        public double eval(double x){
            double aux1, aux2, aux3;
            deriv=0.;
            for(int j=0;j<N+1;j++){               
                nodos[j]=x+(j-Math.floorDiv(N, 2))*paso;
                System.out.println("nodos["+j+"]="+nodos[j]);
            }
            pesos[0][0][0]=1.;
            aux1=1.;
            for(int n=1;n<N+1;n++){
                aux2=1.;
                for(int q=0;q<=n-1;q++){
                    aux3=nodos[n]-nodos[q];
                    aux2=aux2*aux3;
                   pesos[0][n][q]=(nodos[n]-x)*pesos[0][n-1][q]/aux3;
                    for(int m=1;m<=Math.min(n, orden);m++){
                       pesos[m][n][q]=((nodos[n]-x)*pesos[m][n-1][q]-m*pesos[m-1][n-1][q])/aux3;
                    }
                   pesos[0][n][n]=-(nodos[n-1]-x)*pesos[0][n-1][n-1]*aux1/aux2;
                    for(int m=1;m<=Math.min(n,orden);m++){
                        pesos[m][n][n]=(m*pesos[m-1][n-1][n-1]-(nodos[n-1]-x)*pesos[m][n-1][n-1])*aux1/aux2;
                    }
                }
                aux1=aux2;
            }
            for(int p=0;p<N+1;p++){
                deriv=deriv+pesos[orden][N][p]*func.eval(nodos[p]);
            }
            return deriv;        
        }
        
    }
    
    
    /** Metodo que implementa la regla compuesta del trapecio en el intervalo
     * [a,b] usando N intervalos ( h=(b-a)/N )
     *
     * @param f
     * @param a
     * @param b
     * @param N
     * @return
     */

    public static double integralTrapecio(Funcion f, double a, double b, int N){
        double suma=f.eval(a)+f.eval(b);
        double h=(b-a)/N;
        for (int i = 1; i < N; i++) {
            suma =suma + 2* f.eval(a+i*h);

        }

        return suma * h / 2 ;
    }

     /** Metodo que implementa la regla compuesta de Simpson 1/3 utilizando 2N
     * divisiones del intervalo $[a,b]$  ( h= (b-a)/(2N) )
     *
     * @param f
     * @param a
     * @param b
     * @param N
     * @return
     */

     public static double integralSimpson(Funcion f, double a, double b, int N){
        double suma=f.eval(a)+f.eval(b);
        double h=(b-a)/(2*N);
        for (int i = 1; i <= N; i++) {
            suma =suma + 4* f.eval(a+(2*i-1)*h);
        }
         for (int i = 1; i < N; i++) {
            suma= suma + 2* f.eval(a+2*i*h);
         }

        return suma * h / 3;
    }

    
    /** Metodo que implementa la regla compuesta que usa la cuadratura de Gauss
      * de 5 puntos en N divisiones del intervalo $[a,b]$  ( h= (b-a)/N )
      *
      * @param f
      * @param a
      * @param b
      * @param N
      * @return
      */
     public static double integralGauss(Funcion f, double a, double b, int N){
         double[] x= new double[5];
         double[] c= new double[5];
         // nodos y pesos en [-1,1]
         x[2]=0.0; c[2]=0.568888888888889;
         x[1]=-0.538469310105683; c[1]=0.478628670499366;
         x[3]=0.538469310105683; c[3]=0.478628670499366;
         x[0]=-0.906179845938664; c[0]=0.236926885056189;
         x[4]=0.906179845938664; c[4]=0.236926885056189;

         double suma= 0;
         double h=(b-a)/N;
         for (int i = 0; i < N; i++) {
             double ai=a+i*h;
             for (int j = 0; j < 5; j++) {
                 suma=suma+ c[j]* f.eval(ai+(1+x[j])/2 * h );
             }
         }
         return suma * h / 2;
     }
     
     public static double integralAdaptada(Funcion f, double a, double b,double precision, int NSC){
        double integral=integralGauss(f, a, b, NSC);
        double m= a +(b-a)/2.;
        double integral0=integralGauss(f, a, m, NSC);
        double integral1=integralGauss(f, m, b, NSC);
        if(Math.abs(integral - integral0 - integral1)> precision){
            return integralAdaptada(f, a, m, precision/2, NSC )+ integralAdaptada(f, m, b, precision/2, NSC );
        }
        return integral0+integral1;
    }
    
    
         /** (entrega de A. Juarez (2013-14), sigue el algoritmo del libro de Burden-Faires)
      * Implementaci’on del algoritmo de la integral adaptativa de una funci’on f,
      * en un intervalo [a,b], con una precisi’on(Tol),con una profundidad m’axima de
      * N subdivisiones del
      * intervalo.
      * @param f
      * @param a
      * @param b
      * @param Tol
      * @param N
      * @return 
      */
    public static double IntegralAdaptativa(Funcion f, double a, double b, double Tol, int N) {
        //Inicializamos un contador para llevar las evaluaciones que se hacen de la funcion
        //y tambien creamos e inicializamos los arrays que necesitamos con los datos que nos da el
        //articulo.En la variable I guardaremos el valor de la integral.

        int evaluaciones = 0;
        double I = 0;  //para ir acumulando las integrales
        double[] TOL = new double[N];
        double[] A = new double[N];
        double[] h = new double[N];
        double[] FA = new double[N];
        double[] FC = new double[N];
        double[] FB = new double[N];
        double[] S = new double[N];
        double[] L = new double[N];
        double[] v = new double[8];
        int i = 1;
        TOL[0] = 10 * Tol;
        A[0] = a;
        h[0] = (b - a) / 2.;
        FA[0] = f.eval(a);
        FC[0] = f.eval(a + h[i - 1]);
        FB[0] = f.eval(b);
        evaluaciones += 3;
        S[0] = h[i - 1] / 3. * (FA[i - 1] + 4 * FC[i - 1] + FB[i - 1]);
        L[0] = 1.;

        //Variable booleana de control de flujo.Para parar la ejecuciÛn si se da el caso
        boolean stop = false;
        while (i > 0 & !stop) {
            //Entramos en el bucle donde implementamos el algoritmo que nos da el artÌculo ,al
            //mismo tiempo que vamos sumando al contador de evaluaciones si es necesario.
            double FD = f.eval(A[i - 1] + h[i - 1] / 2);
            double FE = f.eval(A[i - 1] + 3 * h[i - 1] / 2);
            evaluaciones += 2;
            double S1 = h[i - 1] / 6 * (FA[i - 1] + 4 * FD + FC[i - 1]);
            double S2 = h[i - 1] / 6 * (FC[i - 1] + 4 * FE + FB[i - 1]);
            v[0] = A[i - 1];
            v[1] = FA[i - 1];
            v[2] = FC[i - 1];
            v[3] = FB[i - 1];
            v[4] = h[i - 1];
            v[5] = TOL[i - 1];
            v[6] = S[i - 1];
            v[7] = L[i - 1];

            i = i - 1;
            if (Math.abs(S1 + S2 - v[6]) < v[5]) {
                I = I + (S1 + S2);
            } else {
                if (v[7] >= N) {
                    //En este caso devolvemos un mensaje de error
                    //y paramos el flujo de ejecuciÛn
                    System.out.println("\n ******ERROR INT ADAPT:"
                            + " NIVEL SOBREPASADO******\n");
                    stop = true;

                } else {
                    i = i + 1;
                    A[i - 1] = v[0] + v[4];
                    FA[i - 1] = v[2];
                    FC[i - 1] = FE;
                    FB[i - 1] = v[3];
                    h[i - 1] = v[4] / 2;
                    TOL[i - 1] = v[5] / 2;
                    S[i - 1] = S2;
                    L[i - 1] = v[7] + 1;
                    i = i + 1;
                    A[i - 1] = v[0];
                    FA[i - 1] = v[1];
                    FC[i - 1] = FD;
                    FB[i - 1] = v[2];
                    h[i - 1] = h[i - 2];
                    TOL[i - 1] = TOL[i - 2];
                    S[i - 1] = S1;
                    L[i - 1] = L[i - 2];
                }
            }
        }
         //Imprimimos las evaluaciones de f y devolvemos el valor de I
        System.out.println("Evaluaciones de f = " + evaluaciones);
        return I;

    }
    
    public static double integralAdaptadaSimpson(Funcion f, double a, double b, double precision, int nProfundidad){
        if(nProfundidad==0){
            System.out.println("Se alcanzó el nivel máximo permitido ABORTAMOS");
            System.exit(0);
            return Double.NaN;
        }
        double fA=f.eval(a);
        double fB=f.eval(b);
        double h=(b-a);
        double m= a +h/2;
        double fM=f.eval(m);
        double integral= (fA+ 4*fM+fB)*h/6;
        h=h/2;
        double fM1=f.eval(a+h/2);
        double integral0=(fA+ 4*fM1+fM)*h/6;
        double fM2=f.eval(m+h/2);
        double integral1=(fM+ 4*fM2+fB)*h/6;
        if(Math.abs(integral - integral0 - integral1)> precision){
            nProfundidad= nProfundidad-1;
            return integralAdaptada(f, a, m, precision/2, nProfundidad )+
                    integralAdaptada(f, m, b, precision/2, nProfundidad ); 
        }
        
        return integral0+integral1;
    }  

    /**
    * Se trata de una implementación directa del algoritmo iterativo descrito en los apuntes, con la 
    * pequeña modificación pedida en el apartado 3. De los detalles de implementación cabe destacar
    * que podemos utilizar arrays para guardar los valores gracias al máximo de profundidad y a que 
    * en cada paso se "borra" el nivel anterior (i-- consigue que se sobrescriban los datos del nivel
    * anterior), lo que disminuye el número máximo de datos que debemos guardar a tamaño profMax, cuando
    * si no se hiciera este paso podríamos llegar a utilizar 2^n (la subdivisión de intervalos lleva a 
    * una estructura de datos de árbol binario).
    * Para implementar la modificación cambiamos el dato de retorno a un array de double (descrito en @return)
    * y nos valemos de la clase de Java TreeSet, que implementa conjuntos ordenados con tiempos de inserción
    * logarítmicos. Añadimos a este conjunto todos los extremos izquierdos de los intervalos que usamos a
    * lo largo de la ejecución y el extremo b. Por ser un conjunto ordenado los elementos quedan ordenados
    * y sin repeticiones. Por último ponemos el resultado obtenido en la posición 0 del array que vamos a devolver
    * y volcamos el contenido del conjunto en el resto de posiciones del array (con un recorrido forEach).
    * 
    * @param f Función a la que queremos aproximar la integral.
    * @param a Extremo izquierdo de integración.
    * @param b Extremo derecho de integración.
    * @param Tol Toloerancia/precisión que que buscamos en la aproximación.
    * @param N Límite del número de niveles.
    * @return Una tabla de double que contiene en la posición 0 el valor aproximado de la integral
    *         y en el resto los valores de los extremos de los intervalos en los que se ha dividido
    *         el intervalo inicial para calcular la integral.
     * @throws auxiliar.ExcepcionAdaptativo Excepción lanzada cuando no se consigue calcular el valor.
    */
    public static double[] IntegralAdaptativaIt(Funcion f, double a,double b, double Tol,int N)throws ExcepcionAdaptativo{
        double resultado=0;
        int i=1;
        int tam=N+1;
        SortedSet<Double> extremos=new TreeSet<>();
        double simps1,simps2,fIntI,fIntD;
        double[] aux=new double[8];                         // Array auxiliar para guardar datos.
        double[] fIzq=new double[tam];
        double[] fCen=new double[tam];
        double[] fDer=new double[tam];
        double[] extIzq=new double[tam];
        double[] h=new double[tam];
        double[] simpson=new double[tam];
        double[] level=new double[tam];
        double[] tolerancia=new double[tam];
        tolerancia[i]=Tol*10;
        h[i]=(b-a)/(double)2;
        extIzq[i]=a;
        extremos.add(a);
        fIzq[i]=f.eval(a);
        fCen[i]=f.eval(a+h[i]);
        fDer[i]=f.eval(b);
        simpson[i]=h[i]*(fIzq[i]+4*fCen[i]+fDer[i])/(double)3;
        level[i]=1;
        while (i>0){
            fIntI=f.eval(extIzq[i]+h[i]/(double)2);
            fIntD=f.eval(extIzq[i]+3*h[i]/(double)2);
            simps1=h[i]*(fIzq[i]+4*fIntI+fCen[i])/(double)6;
            simps2=h[i]*(fCen[i]+4*fIntD+fDer[i])/(double)6;
            aux[0]=extIzq[i];
            aux[1]=fIzq[i];
            aux[2]=fCen[i];
            aux[3]=fDer[i];
            aux[4]=h[i];
            aux[5]=tolerancia[i];
            aux[6]=simpson[i];
            aux[7]=level[i];
            i--;
            if (Math.abs(simps1+simps2-aux[6])<aux[5])
                resultado+=simps1+simps2;
            else{
                if (aux[7]>=N)
                    throw new ExcepcionAdaptativo("Se ha alcanzado la profundidad máxima y no se ha podido obtener la aproximación.");
                else{
                    i++;
                    extIzq[i]=aux[0]+aux[4];
                    extremos.add(extIzq[i]);
                    fIzq[i]=aux[2];
                    fCen[i]=fIntD;
                    fDer[i]=aux[3];
                    h[i]=aux[4]/(double)2;
                    tolerancia[i]=aux[5]/(double)2;
                    simpson[i]=simps2;
                    level[i]=aux[7]+1;
                    
                    i++;
                    extIzq[i]=aux[0];
                    extremos.add(extIzq[i]);
                    fIzq[i]=aux[1];
                    fCen[i]=fIntI;
                    fDer[i]=aux[2];
                    h[i]=h[i-1];
                    tolerancia[i]=tolerancia[i-1];
                    simpson[i]=simps1;
                    level[i]=level[i-1];
                }
            }
        }
        extremos.add(b);
        double[] tabla=new double[extremos.size()+1];
        tabla[0]=resultado;
        int j=1;
        for (double elemento:extremos){
            tabla[j]=elemento;
            j++;
        }
         return tabla;
    }  
      
    // El mismo método pero usando listas en lugar de arrays.
    
    public static double[] IntegralAdaptativaItB(Funcion f, double a,double b, double Tol,int N)throws ExcepcionAdaptativo{
        double resultado=0;
        int i=0;
        SortedSet<Double> extremos=new TreeSet<>();
        double simps1,simps2,fIntI,fIntD;
        double[] aux=new double[8];                         // Array auxiliar para guardar datos.
        List<Double> fIzq=new LinkedList<>();
        List<Double> fCen=new LinkedList<>();
        List<Double> fDer=new LinkedList<>();
        List<Double> extIzq=new LinkedList<>();
        List<Double> h=new LinkedList<>();
        List<Double> simpson=new LinkedList<>();
        List<Double> level=new LinkedList<>();
        List<Double> tolerancia=new LinkedList<>();
        tolerancia.add(i,Tol*10);
        h.add(i,(b-a)/(double)2);
        extIzq.add(i,a);
        extremos.add(a);
        fIzq.add(i,f.eval(a));
        fCen.add(i,f.eval(a+h.get(i)));
        fDer.add(i,f.eval(b));
        simpson.add(i,h.get(i)*(fIzq.get(i)+4*fCen.get(i)+fDer.get(i))/(double)3);
        level.add(i,1.);
        while (i>-1){
            fIntI=f.eval(extIzq.get(i)+h.get(i)/(double)2);
            fIntD=f.eval(extIzq.get(i)+3*h.get(i)/(double)2);
            simps1=h.get(i)*(fIzq.get(i)+4*fIntI+fCen.get(i))/(double)6;
            simps2=h.get(i)*(fCen.get(i)+4*fIntD+fDer.get(i))/(double)6;
            aux[0]=extIzq.get(i);
            aux[1]=fIzq.get(i);
            aux[2]=fCen.get(i);
            aux[3]=fDer.get(i);
            aux[4]=h.get(i);
            aux[5]=tolerancia.get(i);
            aux[6]=simpson.get(i);
            aux[7]=level.get(i);
            i--;
            if (Math.abs(simps1+simps2-aux[6])<aux[5])
                resultado+=simps1+simps2;
            else{
                if (aux[7]>=N)
                    throw new ExcepcionAdaptativo("Se ha alcanzado la profundidad máxima y no se ha podido obtener la aproximación.");
                else{
                    i++;
                    extIzq.add(i,aux[0]+aux[4]);
                    extremos.add(extIzq.get(i));
                    fIzq.add(i,aux[2]);
                    fCen.add(i,fIntD);
                    fDer.add(i,aux[3]);
                    h.add(i,aux[4]/(double)2);
                    tolerancia.add(i,aux[5]/(double)2);
                    simpson.add(i,simps2);
                    level.add(i,aux[7]+1);
                    
                    i++;
                    extIzq.add(i,aux[0]);
                    extremos.add(extIzq.get(i));
                    fIzq.add(i,aux[1]);
                    fCen.add(i,fIntI);
                    fDer.add(i,aux[2]);
                    h.add(i,h.get(i-1));
                    tolerancia.add(i,tolerancia.get(i-1));
                    simpson.add(i,simps1);
                    level.add(i,level.get(i-1));
                }
            }
        }
        extremos.add(b);
        double[] tabla=new double[extremos.size()+1];
        tabla[0]=resultado;
        int j=1;
        for (double elemento:extremos){
            tabla[j]=elemento;
            j++;
        }
        return tabla;
    }
    
    
}
