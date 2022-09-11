package ejerciciosTaller;

public class SumarCifrasNumero {
    
    public static void main(String[] args) {
        SumarCifrasNumero sumarCifrasNumero = new SumarCifrasNumero();
        System.out.println(sumarCifrasNumero.sumarPublico(2459));
    }

    public int sumarPublico(int numero){
        return sumarPrivado(numero, 0);
    }

    private int sumarPrivado(int numero, int resultado){
        if(numero == 0){
            return resultado;
        }
        resultado += numero%10;
        numero/=10;
        return sumarPrivado(numero, resultado);
    }
}
