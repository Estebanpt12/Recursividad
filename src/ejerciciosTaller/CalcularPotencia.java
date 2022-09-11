package ejerciciosTaller;

public class CalcularPotencia {
    
    public static void main(String[] args) {
        CalcularPotencia calcularPotencia = new CalcularPotencia();
        System.out.println(calcularPotencia.potenciaPublico(16, 2));
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
}
