package secuencia;

public class Secuencia {
    public String[] secuencia = { "ASFD", "WAEW", "EWAR", "WERA"};
    
    public static void main(String[] args) {
        Secuencia secuencia = new Secuencia();
        secuencia.encontrar1();
    }

    public void encontrar1(){
        if(encontrarValorDiagonal(0, 'a')){
            System.out.println("La sentencia cumple");
        }else {
            System.out.println("La sentencia no cumple");
        }
    }

    private boolean encontrarValorDiagonal(int index, char valor){
        if(index == 0){
            valor = secuencia[index].charAt(index);
            return encontrarValorDiagonal(index + 1, valor);
        }
        if(secuencia[index].charAt(index) != valor){
            return false;
        }
        if(index == secuencia.length - 1){
            return true;
        }
        return encontrarValorDiagonal(index + 1, valor);
    }
}
