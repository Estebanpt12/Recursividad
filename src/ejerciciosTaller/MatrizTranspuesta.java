package ejerciciosTaller;

public class MatrizTranspuesta {

    public static void mostrarMatriz(int[][] M) {
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[i].length; j++) {
                System.out.print("\t" + M[i][j]);
            }
            System.out.println();
        }
    }
    
    public static void main(String[] args) {
        MatrizTranspuesta matrizTranspuesta = new MatrizTranspuesta();
        int[][] matriz = { {1,3}, {2,4}, {5,6}};
        mostrarMatriz(matrizTranspuesta.transpuestaPublic(matriz));
    }

    public int[][] transpuestaPublic(int[][] matriz){
        int[][] nuevaMatriz = new int[matriz[0].length][matriz.length];
        return transpuestaPrivate(matriz, nuevaMatriz, 0, 0);
    }

    private int[][] transpuestaPrivate(int[][]matriz, int[][] nuevaMatriz, int x, int y){
        if(x== matriz.length - 1 && y==matriz[x].length - 1){
            nuevaMatriz[y][x] = matriz[x][y];
            return nuevaMatriz;
        }
        nuevaMatriz[y][x] = matriz[x][y];
        if(y + 1 < matriz[x].length){
            return transpuestaPrivate(matriz, nuevaMatriz, x, y + 1);
        }
        if(x + 1 < matriz.length && y == matriz[x].length-1){
            return transpuestaPrivate(matriz, nuevaMatriz, x + 1, 0);
        }
        return transpuestaPrivate(matriz, nuevaMatriz, x, y);
    }
}
