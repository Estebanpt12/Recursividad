package ejerciciosTaller;

public class NumeroMayor {

    public static void main(String[] args) {
        NumeroMayor numeroMayor = new NumeroMayor();
        int[] arr = {2,5000,8,43,434,356,565,5,34};
        System.out.println(numeroMayor.buscarMayor(arr, 0, 0));
    }

    public int buscarMayor(int arreglo[], int mayor, int indice){
        if(arreglo[indice] > mayor){
            mayor = arreglo[indice]; 
        }
        if(indice + 1 < arreglo.length){
            mayor = buscarMayor(arreglo, mayor, indice + 1);
        }
        return mayor;
    }
}
