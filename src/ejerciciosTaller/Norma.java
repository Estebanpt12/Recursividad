package ejerciciosTaller;

public class Norma {

    public static void main(String[] args) {
        Norma norma =  new Norma();
        int[] vector = {1,2,3,4,5};
        System.out.println(norma.calcularNorma(vector, 0));
    }

    public double calcularNorma(int[] vector, int index){
        double norma = 0;
        if(index + 1 < vector.length){
            norma += calcularNorma(vector, index + 1);
        }
        norma += Math.pow(vector[index], 2);
        if(index == 0){
            norma = Math.sqrt(norma);
        }
        return norma;
    }
}
