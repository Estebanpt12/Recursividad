package ejerciciosTaller;

public class MatrizSimetrica {

    public static void main(String[] args) {
        MatrizSimetrica matrizSimetrica = new MatrizSimetrica();
        int[][] matriz = {{1,2,3},{2,3,4},{3,4,2}};
        System.out.println(matrizSimetrica.simetricaPublic(matriz));
    }

    public boolean simetricaPublic(int[][] matriz){
        return simetricaPrivada(matriz, 0, 1);
    }

    private boolean simetricaPrivada(int[][] matriz, int x, int y){
        if(y==matriz.length-1 && x==matriz.length-2){
            if(matriz[x][y] == matriz[y][x]){
                return true;
            }
        }
        if(matriz[x][y] != matriz[y][x]){
            return false;
        }
        if(y+1 < matriz.length){
            return simetricaPrivada(matriz, x, y + 1);
        }
        if(x + 1 < matriz.length && y == matriz.length){
            return simetricaPrivada(matriz, x + 1, x + 2);
        }
        return simetricaPrivada(matriz, x + 1, x + 2);
    }
}
