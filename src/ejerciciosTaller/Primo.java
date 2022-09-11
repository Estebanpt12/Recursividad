package ejerciciosTaller;

public class Primo {
    
    public static void main(String[] args) {
        Primo primo = new Primo();
        System.out.println(primo.primoPublico(1));
    }

    public boolean primoPublico(int numero){
        if(numero>0){
            return primoPrivate(numero, 2);
        }
        return false;
    }

    private boolean primoPrivate(int numero, int divisor){
        if(numero == 1){
            return true;
        }
        if(numero%divisor == 0){
            return false;
        }
        if(divisor == numero/2){
            return true;
        }
        return primoPrivate(numero, divisor + 1);
    }
}
