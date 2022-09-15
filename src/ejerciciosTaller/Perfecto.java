package ejerciciosTaller;

public class Perfecto {

    public static void main(String[] args) {
        Perfecto perfecto = new Perfecto();
        perfecto.validarPerfecto(29);
    }

    public void validarPerfecto(int numero){
        if(numeroPerfecto(numero, 0, 1) == numero){
            System.out.println("El numero es perfecto");
        }else{
            System.out.println("El numero no es perfecto");
        }
    }

    private int numeroPerfecto(int numero, int suma, int divisor){
        if(numero % divisor == 0){
            suma += divisor;
        }
        divisor++;
        if(numero != divisor){
            suma += numeroPerfecto(numero, 0, divisor);
        }
        return suma;

    }
}
