package ejerciciosTaller;

public class SumaMatrices {
    
    public static void mostrarMatriz(int[][] M) {
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j <M[i].length; j++) {
                System.out.print("\t" + M[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        SumaMatrices sumaMatrices= new SumaMatrices();
        int[][] matriz = { {1,2,3}, {4,5,6}, {7,8,9} }, matriz1 = { {1,2,3}, {4,5,6}, {7,8,9} };
        mostrarMatriz(sumaMatrices.sumarMatrices(matriz, matriz1, 0, 0));

    }

    public int[][] sumarMatrices(int[][] matriz, int[][] matriz1, int i, int j){
        matriz[i][j] = matriz[i][j] + matriz1[i][j];
        if(i + 1 < matriz.length && j == matriz.length-1){
            return sumarMatrices(matriz, matriz1, i+1, 0);
        }
        if(j + 1 < matriz.length){            
            return sumarMatrices(matriz, matriz1, i, j + 1);
        }
        return matriz;
    }
}
