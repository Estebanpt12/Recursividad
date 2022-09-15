package ejerciciosTaller;

public class BusquedasBinaria {

    public static void main(String[] args) {
        BusquedasBinaria busquedasBinaria = new BusquedasBinaria();
        int[] arreglo = {1,2,3,4,5,6,7,8,9,14};
        busquedasBinaria.encontrarValorP(arreglo, 8);
    }

    public void encontrarValorP(int[] arreglo, int valor){
        encontrarValor(arreglo, valor, 0, arreglo.length - 1);
    }

    private void encontrarValor(int[] arreglo, int valor, int inicio, int fin){
        int mitad = (inicio + fin)/2;
        if(arreglo[mitad] == valor){
            System.out.println("El elemento ha sido encontrado en la posicion " + (mitad +1));
        }else{
            if(inicio == fin){
                System.out.println("Elemento no encontrado");
            }else{
                if(valor < arreglo [mitad]){
                    encontrarValor(arreglo, valor, inicio, mitad);
                }else{
                    if(valor > arreglo [mitad]){
                        encontrarValor(arreglo, valor, mitad + 1, fin);
                    }
                }
            }
        }
    }

}
