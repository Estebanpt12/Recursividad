import busquedaBinaria.BusquedaBinaria;
import recursivo.MatrizEspiral;
import recursivo.Recursivo;

public class App {

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

    public static void mostrarMatriz(int[][] M, int f, int c) {
        for (int i = 0; i <= f; i++) {
            for (int j = 0; j <= c; j++) {
                System.out.print("\t" + M[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws Exception {

        MatrizEspiral matrizEspiral = new MatrizEspiral();
        //int[][] matriz = {{1,2,3}, {8,9,4}, {7,6,5}};

        int[] array = new int[6];
        for(int i = 0; i<6; i++){
            array[i] = i+1;
        }
        mostrarMatriz(printSpiralOrder(array, 2, 3), 1, 2);
        matrizEspiral.recorrerEspiralHorario(printSpiralOrder(array, 2, 3));





        /*Recursivo recursivo = new Recursivo();
        //int[][] matriz = {{1,2,3}, {8,9,4}, {7,6,5}};
        int[][] matriz = {{1,2,3,4}, {12,13,14,5}, {11,16,15,6}, {10,9,8,7}};
        matriz = recursivo.rotacionesMatriz(matriz, true, 1);/*BusquedaBinaria busquedaBinaria = new BusquedaBinaria();
        int numero = 496;
        busquedaBinaria.validarPerfecto(numero);*/
        //System.out.println(recursivo.recursivoConsonantes("esternoncleidomastoideo", 0));
        //int[][] aux = {{76,2, 10, 30, 26}, {1,2,42}};
        //System.out.println(busquedaBinaria.sumaElementosMatriz(aux, 0, 0));
        //busquedaBinaria.encontrarValorP(aux, 60);
        //System.out.println(busquedaBinaria.calcularNorma(aux, 0));
        //System.out.println(busquedaBinaria.buscarMayor(aux, 0, 0));
    }
}
