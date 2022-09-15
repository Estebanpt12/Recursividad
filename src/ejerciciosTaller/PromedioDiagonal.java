package ejerciciosTaller;

public class PromedioDiagonal {
    
    public static void main(String[] args) {
        PromedioDiagonal promedioDiagonal = new PromedioDiagonal();
        int[][] matriz = {{9,2,3}, {4,6,6}, {7,8,10}};
        System.out.println(promedioDiagonal.calcularPromedio(matriz));
    }

    public float calcularPromedio(int[][] matriz){
        if(matriz!=null){
            return calcularPromedioPrivado(matriz, 0, 0);
        }
        return 0;
    }

    private float calcularPromedioPrivado(int[][] matriz, int i, float promedio){
        if(i== matriz.length){
            return promedio / i;
        }
        promedio += matriz[i][i];
        return calcularPromedioPrivado(matriz, i + 1, promedio);
    }
}
