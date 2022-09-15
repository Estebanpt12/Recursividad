package recursivo;

public class Recursivo2{

    private static int[][] printSpiralOrder(int[] arr, int M, int N)
    {
        // caso base
        if (arr == null) {
            return null;
        }
 
        // construye una matriz `M × N`
        int[][] mat = new int[M][N];
 
        int top = 0, bottom = M - 1;
        int left = 0, right = N - 1;
 
        int index = 0;
 
        while (true)
        {
            if (left > right) {
                break;
            }
 
            // imprime la fila superior
            for (int i = left; i <= right; i++) {
                mat[top][i] = arr[index++];
            }
            top++;
 
            if (top > bottom) {
                break;
            }
 
            // imprime la columna derecha
            for (int i = top; i <= bottom; i++) {
                mat[i][right] = arr[index++];
            }
            right--;
 
            if (left > right) {
                break;
            }
 
            // imprime la fila inferior
            for (int i = right; i >= left; i--) {
                mat[bottom][i] = arr[index++];
            }
            bottom--;
 
            if (top > bottom) {
                break;
            }
 
            // imprime la columna izquierda
            for (int i = bottom; i >= top; i--) {
                mat[i][left] = arr[index++];
            }
            left++;
        }
        return mat;
    }

    public static void mostrarMatriz(int[][] M) {
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j <M[i].length; j++) {
                System.out.print("\t" + M[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws Exception {

        Recursivo2 recursivo2 = new Recursivo2();
        MatrizEspiral matrizEspiral = new MatrizEspiral();
        //int[][] matriz = {{1,2,3}, {8,9,4}, {7,6,5}};

        int[] array = new int[25];
        for(int i = 0; i<25; i++){
            array[i] = i+1;
        }
        mostrarMatriz(recursivo2.rotacionesMatriz(printSpiralOrder(array, 5, 5),
         true, 1));
    }

    public int[][] rotacionesMatriz(int[][] matriz, boolean derecha, int cantidadVueltas){
        if(matriz == null && matriz.length == 0){
            return null;
        }
        if(cantidadVueltas > 0){
            matriz = rotarMatriz(matriz, 0, 0, derecha);
            matriz = rotacionesMatriz(matriz, derecha, cantidadVueltas - 1);
        }
        return matriz;
    }

    private int[][] rotarMatriz(int[][] matriz, int i, int j, boolean movimiento){
        if(movimiento){
            if(i+1<matriz.length/2 && j == 0){
                matriz = rotarMatriz(matriz, i + 1, j + 1, movimiento);
            }
            if(j+1<matriz.length-i){
                int aux = matriz[i][j];
                matriz[i][j] = matriz[matriz.length-1-j][i];
                matriz[matriz.length-1-j][i] = matriz[matriz.length-1-i][matriz.length-1-j];
                matriz[matriz.length-1-i][matriz.length-1-j] = matriz[j][matriz.length-1-i];
                matriz[j][matriz.length-1-i] = aux;
                matriz = rotarMatriz(matriz, i, j + 1, movimiento);
            }
            return matriz;
        }else{
            if(i+1<matriz.length/2 && j == 0){
                matriz = rotarMatriz(matriz, i + 1, j + 1, movimiento);
            }
            if(j+1<matriz.length-i){
                int aux = matriz[matriz.length-j-1][i];
                matriz[matriz.length-1-j][i] = matriz[i][j];
                matriz[i][j] = matriz[j][matriz.length-1-i];
                matriz[j][matriz.length-1-i] = matriz[matriz.length-1-i][matriz.length-1-j];
                matriz[matriz.length-1-i][matriz.length-1-j] = aux;
                matriz = rotarMatriz(matriz, i, j + 1, movimiento);
            }
            return matriz;
        }
    }
}