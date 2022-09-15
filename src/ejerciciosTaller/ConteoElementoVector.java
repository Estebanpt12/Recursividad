package ejerciciosTaller;

public class ConteoElementoVector {

    public static void main(String[] args) {
        ConteoElementoVector conteoElementoVector = new ConteoElementoVector();
        int[] arr={1,4,2,7,1,8,4,6,1};
        System.out.println(conteoElementoVector.conteoPublico(arr,1));
    }

    
    public int conteoPublico(int[] vector, int elemento){
        if(vector!=null){
            return conteoPrivado(vector, 0, vector.length-1, elemento);
        }
        return 0;
    }

    private int conteoPrivado(int[] vector, int inicio, int fin, int elemento){
        int conteo = 0;
        if(vector[inicio] == elemento){
            conteo += 1;
        }
        if(inicio == fin){
            return conteo;
        }
        conteo += conteoPrivado(vector, inicio+1, fin, elemento);
        return conteo;
    }
}
