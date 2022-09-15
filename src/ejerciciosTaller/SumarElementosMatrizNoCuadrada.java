package ejerciciosTaller;

public class SumarElementosMatrizNoCuadrada {
    
    public static void main(String[] args) {
        SumarElementosMatrizNoCuadrada sCuadrada = new SumarElementosMatrizNoCuadrada();
        int[][] matriz = {{1,2,3,4},{5,6,7,8}};
        System.out.println(sCuadrada.sumarMatriz(matriz));
    }

    public int sumarMatriz(int[][] matriz){
        if(matriz!=null){
            return sumarMatrizPrivada(matriz, 0, 0);
        }
        return 0;
    }

    private int sumarMatrizPrivada(int[][] matriz, int i, int j){
        int sumatoria = 0;
        sumatoria += matriz[i][j];
        if(i+1<matriz.length && j==matriz[i].length-1){
            sumatoria += sumarMatrizPrivada(matriz, i + 1, 0);
        }
        if(j+1<matriz[i].length){
            sumatoria += sumarMatrizPrivada(matriz, i, j+1);
        }
        return sumatoria;
    }
}
