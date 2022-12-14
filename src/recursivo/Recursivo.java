package recursivo;

public class Recursivo{

    public String recursivoConsonantes(String palabra, int index){
        palabra = palabra.toLowerCase();
        String consonantes = new String();
        if((palabra.charAt(index) != 'a' && palabra.charAt(index) != 'e' && palabra.charAt(index) != 'i' &&
                palabra.charAt(index) != 'o' && palabra.charAt(index) != 'u')){
            consonantes += Character.toString(palabra.charAt(index));
        }
        if(index + 1 < palabra.length()){
            consonantes += recursivoConsonantes(palabra, index + 1);
        }
        return consonantes;
    }

    public void p(int[][] matriz, int i, int j){
        if(i==matriz.length-1 && j==matriz[i].length-1){
            System.out.println(matriz[i][j]);
        }else{
            System.out.println(matriz[i][j]);
            if(j<matriz[i].length){
                p(matriz, i, j+1);
            }if (i < matriz.length) {
                p(matriz, i+1, 0);
            }
        }
    }

    public int sP(int[][] matriz){
        if(matriz.length == 0 && matriz[0].length == 0){
            return 0;
        }   
        return sPM(matriz, 0, matriz[0].length-1);
    }

    private int sPM(int[][] matriz, int i, int j){
        int suma = 0;
        if(i+1<matriz.length && j==matriz[i].length-1){
            suma += sPM(matriz, i+1, j);
        }
        if(j>0){
            suma += sPM(matriz, i, j-1);
        }
        suma += matriz[i][j];
        return suma;
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