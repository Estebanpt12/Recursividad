package ejerciciosTaller;

public class CalcularPotencia {
    
    public static void main(String[] args) {
        CalcularPotencia calcularPotencia = new CalcularPotencia();
        //System.out.println(calcularPotencia.potenciaPublico(16, 2));
        System.out.println(calcularPotencia.calcularPotenciaTradicional(2, 3));
    }

    public boolean potenciaPublico(int n, int b){
        return potenciaPrivado(b, n);
    }

    private boolean potenciaPrivado(int numeroBase, int numeroPotencia){
        if(numeroBase == numeroPotencia){
            return true; 
        }
        if(numeroBase>numeroPotencia){
            return false;
        }
        numeroPotencia /= numeroBase;
        return potenciaPrivado(numeroBase, numeroPotencia);
    }

    public int calcularPotenciaTradicional(int base, int potencia){
        int resultado = 1;
        if(potencia == 0){
            return resultado;
        }
        resultado *= base;
        resultado*=calcularPotenciaTradicional(base, potencia - 1);
        return resultado;
    }
}
