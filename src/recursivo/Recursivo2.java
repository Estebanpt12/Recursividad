package recursivo;

public class Recursivo2{

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
                matriz = rotarMatriz(matriz, i + 1, j, movimiento);
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
                matriz = rotarMatriz(matriz, i + 1, j, movimiento);
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