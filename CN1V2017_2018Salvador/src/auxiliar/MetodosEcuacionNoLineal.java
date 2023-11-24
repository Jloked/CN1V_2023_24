package auxiliar;

/**
 * <p>
 * Title: Ejemplos MetodosEcuacionesLineales</p>
 * <p>
 * Description: </p>
 * <p>
 * Copyright: Copyright (c) 2013</p>
 * <p>
 * Company: </p>
 *
 * @author APALL
 * @version 2009.0
 */
public class MetodosEcuacionNoLineal {

    /**
     * Metodo para aproximar ceros de una funcion f tal que f(a)*f(b)<0.
     *
     * @param f
     * @param a
     * @param b
     * @param precision para condicion de parada
     * @param nmaxiter numero maximo de iteradas
     * @return una aproximacion de un cero de f o un mensaje de error si se
     * excede el numero maximo de iteraciones
     * @throws auxiliar.MetodosEcuacionNoLineal.ERROR
     */
    public static double biseccion(Funcion f, double a, double b, double precision,
            int nmaxiter) throws ERROR {
        double aa = a, bb = b;
        double h;
        double u = f.eval(aa), v = f.eval(bb);
        double c;
        double w;

        if (Math.abs(u) < precision) {
            System.out.println("BISECCION: raiz en a=" + a + " f(a)=" + u + " en " + 0 + " pasos");
            return a;
        }
        if (Math.abs(v) < precision) {
            System.out.println("BISECCION: raiz en b=" + b + " f(b)=" + v + " en " + 0 + " pasos");
            return b;
        }

        if (u * v > 0) {
            System.out.println("Biseccion: no hay cambio de signo de f");
            throw new ERROR();
        }
        for (int k = 1; k <= nmaxiter; k++) {
            h = 0.5 * (bb - aa);
            c = aa + h;
            System.out.println(" k= " + k + "&aa= " + aa + "&bb= " + bb + "& u=" + u + "& v=" + v + "\\\\");
            w = f.eval(c);
            if ((h < precision) && (Math.abs(w) < precision)) {
                System.out.println("BISECCION: raiz en c=" + c + " f(c)=" + w + " en " + k + " pasos");
                System.out.println("Error en la raiz menor que "+ h);
                return c;
            }
            if (w * u > 0) {
                aa = c;
                u = w;
            } else {
                bb = c;
                v = w;
            }
        }
        System.out.println("Bolzano: No hay convergencia en " + nmaxiter + " iteraciones");
        throw new ERROR();
    }

    /*
     public static double regulaFalsi(Funcion f, double a, double b, double precision,
     int nmaxiter) throws ERROR {
     double aa = a;
     double bb = b;
     double h;
     double u = f.eval(aa);
     double v = f.eval(bb);
     double c;
     double w;

     if (u * v >= 0) {
     System.out.println("regula Falsi: no hay cambio de signo de f");
     throw new ERROR();
     }

     for (int k = 1; k <= nmaxiter; k++) {
     h = -u * (bb - aa) / (v - u);
     c = aa + h;
     // System.out.println(" k= "+k+"&aa= "+aa+"&bb= "+bb+  "& u="+ u +"& v="+v+"\\\\");
     w = f.eval(c);
     if (Math.abs(w) < precision) {
     System.out.println("REGULA FALSI: raiz en c=" + c + " f(c)=" + w + " en " + k + " pasos");
     return c;
     }
     if (w * u > 0) {
     aa = c;
     u = w;
     } else {
     bb = c;
     v = w;
     }
     }
     System.out.println("Regula Falsi: No hay convergencia en " + nmaxiter + " iteraciones");
     throw new ERROR();
     }
     */
    /*
     public static double regulaFalsiModificado(Funcion f, double a, double b, double precision,
     int nmaxiter) throws ERROR {
     double aa = a;
     double bb = b;
     double h;
     double u = f.eval(aa);
     double v = f.eval(bb);
     // Modificacion: guardamos memoria del valor de f ultimo punto de corte, empezando con aa
     double w1 = u;
     double c2;
     double w2;

     if (u * v >= 0) {
     System.out.println("regula Falsi Modificado: no hay cambio de signo de f");
     throw new ERROR();
     }

     for (int k = 1; k <= nmaxiter; k++) {
     h = -u * (bb - aa) / (v - u);
     c2 = aa + h;
     //  System.out.println("c="+c+ " k="+k+ " u="+ u +" v="+v);
     w2 = f.eval(c2);
     if (Math.abs(w2) < precision) {
     System.out.println("REGULA FALSI MOD: raiz en c=" + c2 + " f(c)=" + w2 + " en " + k + " pasos");
     return c2;
     }
     if (w2 * u > 0) {
     aa = c2;
     u = w2;
     if (w1 * w2 > 0) {
     v = 0.5 * v;
     }
     w1 = w2;
     } else {
     bb = c2;
     v = w2;
     if (w1 * w2 > 0) {
     u = 0.5 * u;
     }
     w1 = w2;
     }
     }
     System.out.println("Regula Falsi Modificado: No hay convergencia en " + nmaxiter + " iteraciones");
     throw new ERROR();
     }
     */
    
    /**
     * Metodo de Newton para aproximar ceros de la funcion f empezando con
     * una aproximacion inicial x
     * @param f  Funcion derivable
     * @param x  aproximacion inicial
     * @param precision para condicion de parada
     * @param nmaxiter numero maximo de iteraciones
     * @return
     * @throws auxiliar.MetodosEcuacionNoLineal.ERROR 
     */
    public static double newton(FuncionDeriv f, double x, double precision,
            int nmaxiter) throws ERROR {
        double xx = x;
        double h;
        double u = f.eval(xx);
        double du = f.derivada(xx);

        for (int k = 1; k <= nmaxiter; k++) {
            if (Math.abs(u) < precision) {
                System.out.println("NEWTON: raiz en c=" + xx + " f(c)=" + u + " en " + k + " pasos");
                return xx;
            }
            if (Math.abs(du) < precision) {
                System.out.println("Newton: Derivada nula en x");
                throw new ERROR();
            }
            h = -u / du;
            xx = xx + h;
            u = f.eval(xx);
            du = f.derivada(xx);
            if (Math.abs(h) < precision) {
                System.out.println("NEWTON: raiz en c=" + xx + " f(c)=" + u + " en " + k + " pasos");
                return xx;
            }
        }
        System.out.println("Newton: No hay convergencia en " + nmaxiter + " iteraciones");
        throw new ERROR();
    }

    /**
     * Metodo quasi-newton donde se sustituye la evaluacion de la derivada por una aproximacion
     * usando la formula de aproximacion con tres puntos
     * @param f
     * @param x
     * @param precision
     * @param nmaxiter
     * @return
     * @throws auxiliar.MetodosEcuacionNoLineal.ERROR 
     */
    public static double newtonAprox(Funcion f, double x, double precision,
            int nmaxiter) throws ERROR {
        double xx = x;
        double h;
        double u = f.eval(xx);
        MetodosFunciones.derivada3puntos df = new MetodosFunciones.derivada3puntos(f, Math.pow(precision, 0.34));
        double du = df.eval(xx);

        for (int k = 1; k <= nmaxiter; k++) {
            if (Math.abs(u) < precision) {
                System.out.println("NEWTON: raiz en c=" + xx + " f(c)=" + u + " en " + k + " pasos");
                return xx;
            }
            if (Math.abs(du) < precision) {
                System.out.println("Newton: Derivada nula en x");
                throw new ERROR();
            }
            h = -u / du;
            xx = xx + h;
            u = f.eval(xx);
            du = df.eval(xx);
            if (Math.abs(h) < precision) {
                System.out.println("NEWTON: raiz en c=" + xx + " f(c)=" + u + " en " + k + " pasos");
                return xx;
            }
        }
        System.out.println("Newton: No hay convergencia en " + nmaxiter + " iteraciones");
        throw new ERROR();
    }

    /**
     * Metodo de la secante para aproximar ceros de funciones a partir de dos aproximaciones iniciales
     * @param f
     * @param x0 aproximacion inicial
     * @param x1 aproximacion inicial
     * @param precision
     * @param nmaxiter
     * @return
     * @throws auxiliar.MetodosEcuacionNoLineal.ERROR 
     */
    public static double secante(Funcion f, double x0, double x1,
            double precision, int nmaxiter) throws ERROR {
        double xx0 = x0;
        double xx1 = x1;
        double h;
        double u = f.eval(xx0);
        double v = f.eval(xx1);
        if (Math.abs(u) < precision) {
            System.out.println("Raiz en c = " + xx0 + "; f(c) = " + u);
            return xx0;
        }
        if (Math.abs(v) < precision) {
            System.out.println("SECANTE: Raiz en c = " + xx1 + "; f(c) = " + v);
            return xx1;
        }
        if (Math.abs(xx0 - xx1) < precision) {
            System.out.println(
                    "Secante: error en las condiciones iniciales.");
            throw new ERROR();
        }
        for (int k = 1; k <= nmaxiter; k++) {
            if (Math.abs(u - v) < precision) {
                System.out.println(
                        "Secante: secante horizontal en el paso " + k + ".");
                throw new ERROR();
            }
            h = -v * (xx1 - xx0) / (v - u);
            xx0 = xx1;
            u = v;
            xx1 = xx1 + h;
            v = f.eval(xx1);
            if (Math.abs(v) < precision) {
                System.out.println("SECANTE: Raiz en c = " + xx1 + "; f(c) = " + v + " en " + k + " pasos.");
                return xx1;
            }
        }
        System.out.println("Secante: no hay convergencia en " + nmaxiter + " iteraciones.");
        throw new ERROR();
    }

    /**
     * Metodo de Muller para aproximar ceros de funciones a partir de tres aproximaciones iniciales
     * 
     * @param f
     * @param x0
     * @param x1
     * @param x2
     * @param precision
     * @param nmaxiter
     * @return
     * @throws auxiliar.MetodosEcuacionNoLineal.ERROR 
     */
    public static double Muller(Funcion f, double x0, double x1, double x2,
            double precision, int nmaxiter) throws ERROR {
        double xx0 = x0, xx1 = x1, xx2 = x2;
        double f0 = f.eval(x0), f1 = f.eval(x1), f2 = f.eval(x2);
        if ((Math.abs(x0 - x1) < precision) || (Math.abs(x0 - x2) < precision) || (Math.abs(x1 - x2) < precision)) {
            System.out.println("Parada Muller: nodos iniciales iguales");
            throw new ERROR();
        }
        double f01 = (f0 - f1) / (xx0 - xx1);
        double f02, f12;
        double h = 1. + precision;
        for (int i = 0; i < nmaxiter; i++) {
            if ((Math.abs(f2) < precision) || (Math.abs(h) < precision)) {
                System.out.println("MULLER:  raiz en " + xx2 + " con f(" + xx2 + ")= " + f2 + " en  " + i + " iteraciones");
                return xx2;
            }
            f02 = (f0 - f2) / (xx0 - xx2);
            f12 = (f1 - f2) / (xx1 - xx2);
            double f012 = (f01 - f12) / (xx0 - xx2);
            double W = f12 + f02 - f01;
            double aux = W * W - 4 * f2 * f012;
            if (aux < 0) {
                System.out.println("Parada Muller: Salimos de la recta real");
                throw new ERROR();
            }
            aux = Math.sqrt(aux);
            if ((Math.abs(W) < precision) && (Math.abs(f012) < precision)) {
                System.out.println("Parada Muller: polinomio interpolador constante");
                throw new ERROR();
            }
            double denom1 = W + aux;
            double denom2 = W - aux;
            if (Math.abs(denom1) > Math.abs(denom2)) {
                h = -2 * f2 / denom1;
            } else {
                h = -2 * f2 / denom2;
            }
            xx0 = xx1;
            f0 = f1;
            xx1 = xx2;
            f1 = f2;
            f01 = f12;
            xx2 = xx2 + h;
            f2 = f.eval(xx2);
        }

        System.out.println("Parada Muller: no hay convergencia en " + nmaxiter + "iteraciones");
        throw new ERROR();
    }

public static double interpInver3p(Funcion f,double x0, double x1,double x2,double prec, int nmaxit) 
                throws ERROR {
        double xx0=x0;
        double xx1=x1;
        double xx2=x2;
        double f0=f.eval(xx0);
        double f1=f.eval(xx1); 
        double f2=f.eval(xx2);
        double g01,g12,g012;
        double h;
        
        if ((Math.abs(x0 - x1) < prec) || (Math.abs(x0 - x2) < prec) || (Math.abs(x1 - x2) < prec)) {
            System.out.println("Parada interpolación inversa 3p: nodos iniciales iguales");
            throw new ERROR();
        }
        g01=(xx1-xx0)/(f1-f0);
        for (int i = 1; i <= nmaxit; i++) {
//            if (Math.abs(f2) < prec*1E-5) {
//                System.out.println("Interpolación inversa 3p:  raiz en c=" + xx2 + " con f(c)=" + f2 + " en  " + (i-1) + " iteraciones");
//                return xx2;
//            }
        g12=(xx2-xx1)/(f2-f1);
        g012=(g12-g01)/(f2-f0);
        h=-g12*f2+g012*f2*f1;
//           System.out.println("h="+h+" f2="+f2+" f1="+f1+" g12="+g12+" g012="+g012);
        xx0=xx1;
        xx1=xx2;
        f0=f1;
        f1=f2;
        g01=g12;
//        System.out.println("Iterada "+i+" : "+xx2);
        xx2=xx2+h;        
        if (Math.abs(h)<prec){
                System.out.println("Incremento Interpolación inversa 3p="+h);
                System.out.println("Interpolación inversa 3p:  raiz en c=" + xx2 + " con f(c)=" + f2 + " en  " + (i-1) + " iteraciones");
                return xx2;
            }
        f2=f.eval(xx2);
        }     
        System.out.println("Parada interpolación inversa 3p: no hay convergencia en " + nmaxit + "iteraciones");
        throw new ERROR();
    }

    /**
     * Implementacion del metodo de iteracion funcional para aproximar
     * puntos fijos de funciones
     * @param f
     * @param x
     * @param precision
     * @param nmaxiter
     * @return
     * @throws auxiliar.MetodosEcuacionNoLineal.ERROR 
     */
    public static double iteracionPF(Funcion f, double x, double precision, int nmaxiter)
            throws ERROR {
        double xx = x;
        double fx = f.eval(xx);
        for (int k = 1; k <= nmaxiter; k++) {
            if (Math.abs(fx - xx) < precision) {
                System.out.println("punto fijo en c=" + xx + " f(c)=" + fx + " en " + k + " pasos");
                return xx;
            }
            xx = fx;
            fx = f.eval(xx);
        }
        System.out.println("PuntoFijo: No hay convergencia en " + nmaxiter + " iteraciones");
        throw new ERROR();
    }

    
    /**
     * Metodo de iteracion de punto fijo con aceleracion de Aitken
     * @param f
     * @param x
     * @param precision
     * @param nmaxiter
     * @return
     * @throws auxiliar.MetodosEcuacionNoLineal.ERROR 
     */
    public static double iteracionPFacelerada(Funcion f, double x, double precision, int nmaxiter)
            throws ERROR {
        double xx = x;
        double fx = f.eval(xx);
        double ffx;
        double xxacelerado;
        for (int k = 1; k <= nmaxiter; k++) {
            if (Math.abs(fx - xx) < precision) {
                System.out.println("punto fijo en c=" + xx + " f(c)=" + fx + " en " + k + " pasos");
                return xx;
            }
            ffx = f.eval(fx);
            xxacelerado = xx - ((fx - xx) * (fx - xx)) / (ffx - 2 * fx + xx);
            if (Math.abs(f.eval(xxacelerado) - xxacelerado) < precision) {
                System.out.println("punto fijo en c=" + xxacelerado + " f(c)=" + f.eval(xxacelerado) + " en " + k + " pasos");
                return xxacelerado;
            }
            xx = fx;
            fx = f.eval(xx);
        }
        System.out.println("PuntoFijo: No hay convergencia en " + nmaxiter + " iteraciones");
        throw new ERROR();
    }

    /**
     * Metodo de iteracion de Steffensen para aproximar Puntos Fijos de funciones
     * @param f
     * @param x
     * @param precision
     * @param nmaxiter
     * @return
     * @throws auxiliar.MetodosEcuacionNoLineal.ERROR 
     */
    public static double steffensenPF(Funcion f, double x, double precision,
            int nmaxiter) throws ERROR {
        double xx = x;
        double fx = f.eval(xx);
        double ffx = f.eval(fx);

        for (int k = 1; k <= nmaxiter; k++) {
            if (Math.abs(fx - xx) < precision) {
                System.out.println("Punto fijo en c = " + xx + "; f(c) = " + fx
                        + " en " + k + " pasos.");
                return xx;
            }
            xx = xx - ((fx - xx) * (fx - xx)) / (ffx - 2 * fx + xx);
            fx = f.eval(xx);
            ffx = f.eval(fx);
        }
        System.out.println("Steffensen: no hay convergencia en " + nmaxiter
                + " iteraciones.");
        throw new ERROR();
    }



    // Excepcion ERROR para ser devuelta por los metodos de la clase
    public static class ERROR extends Exception {

        ERROR() {
            super("Error al aproximar raices");
        }
    }
}
