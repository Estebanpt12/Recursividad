package ejerciciosTaller;

public class NumeroMenor {
    
    public static void main(String[] args) {
        NumeroMenor numeroMenor= new NumeroMenor();
        int[] vector = {1,2,-300,4,-5,6,7,-2};
        System.out.println(numeroMenor.EncontrarPublico(vector));
    }

    public int EncontrarPublico(int[] vector){
        if(vector!= null){
            return EncontrarPrivado(vector, 999999999, 0);
        }
        return 0;
    }

    private int EncontrarPrivado(int[] vector, int valor, int indice){
        if(vector[indice]<valor){
            valor = vector[indice];
        }
        if(indice + 1 <vector.length){
            valor = EncontrarPrivado(vector, valor, indice+1);
        }
        return valor;
    }
}
