package recursivo;

public class MatrizEspiral {
    
    public void recorrerEspiralHorario(int[][] matriz){
        if(matriz != null){
            espiralHorario(matriz, 0, 0, 0, matriz[0].length-1);
        }
    }

    private void espiralHorario(int[][] matriz, int i, int j, int inicio, int fin){
        if(i == inicio && j < fin){
            System.out.println(matriz[i][j]);
            espiralHorario(matriz, i, j + 1, inicio, fin);
        }
        if(j == fin && i < fin){
            System.out.println(matriz[i][j]);
            espiralHorario(matriz, i+1, j, inicio, fin);
        }
        if(i == fin && j > inicio){
            System.out.println(matriz[i][j]);
            espiralHorario(matriz, i, j-1, inicio, fin);
        }
        if(j==inicio && i> inicio){
            System.out.println(matriz[i][j]);
            if(i!= inicio+1){
                espiralHorario(matriz, i-1, j, inicio, fin);
            }     
        }
        if((i<=matriz.length/2)  && (j == inicio && i == inicio + 1)){
            espiralHorario(matriz, i, j+1, inicio+1, fin-1);
        }
        if(inicio == fin){
            System.out.println(matriz[i][j]);
        }
    }
}
