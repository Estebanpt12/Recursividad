package ejerciciosTaller;

public class ContarCeros {

    public static void main(String[] args) {
        ContarCeros contarCeros = new ContarCeros();
        int[] arr = {1,0,0,5,3,0};
        System.out.println(contarCeros.contarCerosNormal(arr, 0));
    }
    public void dividePublico(int[] vector){
        System.out.println(dividePrivado(vector, 0, vector.length-1));
    }

    private int dividePrivado(int[] vector, int inicio, int fin){
        int conteo = 0; 
        if(inicio == fin){
            if(vector[inicio] == 0){
                return 1;
            }else{
                return conteo;
            }
        }
        int aux = (inicio + fin)/2;
        conteo += dividePrivado(vector, aux + 1, fin);
        conteo += dividePrivado(vector, inicio, aux);
        return conteo;

    }

    public int contarCerosNormal(int[] vector, int i){
        int conteo = 0;
        if(vector[i]==0){
            conteo+=1;
        }
        if(i==vector.length-1){
            return conteo;
        }
        conteo += contarCerosNormal(vector, i+1);
        return conteo;
    }
}
