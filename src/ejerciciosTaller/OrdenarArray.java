package ejerciciosTaller;

public class OrdenarArray {
    
    public static void mostrarVector(int[] vector) {
        for (int i = 0; i < vector.length; i++) {
            System.out.print("\t" + vector[i]);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        OrdenarArray ordenarvectoray = new OrdenarArray();
        int[] vector = {6,8,4,6};
        mostrarVector(ordenarvectoray.ordenarArrayDescendente(vector, 0, 0));
        mostrarVector(ordenarvectoray.ordenarArrayAscendente(vector, 0, 0));
    }

    public int[] ordenarArrayAscendente(int[] vector, int contador, int index){
        if(contador == vector.length-1){
            return vector;
        }
        if(index + 1 < vector.length){
            if(vector[index] > vector[index + 1]){
                int temp = vector[index];
                vector[index] = vector[index+1];
                vector[index+1] = temp;
            }
            ordenarArrayAscendente(vector, contador, index + 1);
        }
        return ordenarArrayAscendente(vector, contador + 1, index);
    }

    public int[] ordenarArrayDescendente(int[] vector, int contador, int index){
        if(contador == vector.length-1){
            return vector;
        }
        if(index + 1 < vector.length){
            if(vector[index] < vector[index + 1]){
                int temp = vector[index];
                vector[index] = vector[index+1];
                vector[index+1] = temp;
            }
            ordenarArrayDescendente(vector, contador, index + 1);
        }
        return ordenarArrayDescendente(vector, contador + 1, index);
    }
}
