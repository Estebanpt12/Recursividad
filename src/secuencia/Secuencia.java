package secuencia;

import java.util.ArrayList;

public class Secuencia {
    
    public static void main(String[] args) {
        Secuencia secuencia = new Secuencia();
        String[] secuencia1 = { "REDRT", "FPUIH", "AYMIH", "PUHNO","PUIHS"};
        secuencia.encontrar1(secuencia1);
    }

    public void encontrar1(String[] secuencia){
        ArrayList<Character> lista = new ArrayList<>();
        if(encontrarValorDiagonal(secuencia, 0, lista)){
            System.out.println("La sentencia cumple");
        }else {
            System.out.println("La sentencia no cumple");
        }
    }

    private boolean encontrarValorDiagonal(String[] secuencia,int index,ArrayList<Character> lista){
        lista.add(secuencia[index].charAt(index));
        if(secuencia.length-1 == index){
            return validarCantidad(lista, 0, ' ', 0);
        }
        return encontrarValorDiagonal(secuencia,index + 1, lista);
    }

    private boolean validarCantidad(ArrayList<Character> lista, int i, char valor, int conteo){
        if(i==0){
            valor = lista.get(0);
        }
        if(lista.get(i) == valor){
            conteo += 1;
        }
        if(conteo == 4){
            return true;
        }
        if(i+1<lista.size()){
            return validarCantidad(lista, i + 1, valor, conteo);
        }
        if(conteo==1 && i == lista.size()-1 && lista.indexOf(valor) == 0){
            valor = lista.get(1);
            return validarCantidad(lista, 1, valor, 0);
        }
        return false;
    }
}
