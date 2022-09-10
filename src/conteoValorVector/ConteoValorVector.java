package conteoValorVector;

public class ConteoValorVector {

    public static void main(String[] args) {
        ConteoValorVector conteoValorVector = new ConteoValorVector();
        int[] vector = {2,0,0,3,5,0,3};
        conteoValorVector.dividePublico(vector);
        //System.out.println(conteoValorVector.conteoPublico(vector, 2));
    }

    public int conteoPublico(int[] vector, int valor){
        if(vector != null){
            return conteoPrivado(vector, valor, 0);
        }
        return 0;
    }

    private int conteoPrivado(int[] vector, int valor, int posicion){
        int conteo = 0;
        if(vector[posicion] == valor){
            conteo += 1;
        }
        if(vector.length == posicion + 1){
            return conteo;
        }
        conteo += conteoPrivado(vector, valor, posicion + 1);
        return conteo;
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
}
