package ejerciciosTaller;

public class FilaMayor {
    
    public static void main(String[] args) {
        FilaMayor filaMayor = new FilaMayor();
        int[][] matriz = { {1,2000,3}, {4,7,9}, {1,100,1}};
        System.out.println(filaMayor.mayorPublic(matriz));
    }

    public int mayorPublic(int[][] matriz){
        return mayorPrivate(matriz, -1, 0, 0, 0, 0);
    }

    private int mayorPrivate(int[][] matriz, int fila, int x, int y, int sumaActual, int sumaMayor){
        sumaActual+=matriz[x][y];
        if(sumaMayor< sumaActual && y == matriz[x].length - 1){
            fila = x;
            sumaMayor = sumaActual;
        }
        if(x + 1 <matriz.length && y==matriz[x].length-1){
            return mayorPrivate(matriz, fila, x + 1, 0, 0, sumaMayor);
        }
        if(y + 1 <matriz[x].length){
            return mayorPrivate(matriz, fila, x, y + 1, sumaActual, sumaMayor);
        }
        if(y==matriz[x].length-1 && x==matriz.length-1){
            return fila;
        }
        return mayorPrivate(matriz, fila, x, y, sumaActual, sumaMayor);
    }
}
