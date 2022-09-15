package ejerciciosTaller;

public class SumarElementosMatriz {
    

    public static void main(String[] args) {
        SumarElementosMatriz sumarElementosMatriz = new SumarElementosMatriz();
        int[][] matriz = {{1,2,3},{4,5,6},{7,8,10}};
        System.out.println(sumarElementosMatriz.sumarPublico(matriz));
    }

    public int sumarPublico(int[][] matriz){
        if(matriz!=null){
            return sumarR(matriz, 0, matriz[0].length-1);
        }

        return 0;
    }

    private int sumarR(int[][] matriz, int i, int j){
        int conteo = 0;
        conteo += matriz[i][j];
        if(j - 1 >= 0){
            conteo += sumarR(matriz, i, j-1);
        }
        if(i+1 < matriz.length && j==0){
            conteo += sumarR(matriz, i+1, matriz[i+1].length-1);
        }
        return conteo;
    }
}
