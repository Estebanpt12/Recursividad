package ejerciciosTaller;

public class CifrasValor {
    public static void main(String[] args) {
        CifrasValor cifrasValor = new CifrasValor();
        System.out.println(cifrasValor.valorPublico(20000));
    }

    public int valorPublico(int valor){
        return valorPrivate(valor, 0);
    }

    private int valorPrivate(int valor, int cifras){
        if(valor == 0){
            return cifras;
        }
        valor = valor/10;
        return valorPrivate(valor, cifras+1);
    }
}
