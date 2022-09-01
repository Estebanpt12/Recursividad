package busquedaBinaria;

public class BusquedaBinaria {
    public void encontrarValorP(int[] arreglo, int valor){
        encontrarValor(arreglo, valor, 0, arreglo.length - 1);
    }

    private void encontrarValor(int[] arreglo, int valor, int inicio, int fin){
        int mitad = (inicio + fin)/2;
        if(arreglo[mitad] == valor){
            System.out.println("El elemento ha sido encontrado en la posicion " + (mitad +1));
        }else{
            if(inicio == fin){
                System.out.println("Elemento no encontrado");
            }else{
                if(valor < arreglo [mitad]){
                    encontrarValor(arreglo, valor, inicio, mitad);
                }else{
                    if(valor > arreglo [mitad]){
                        encontrarValor(arreglo, valor, mitad + 1, fin);
                    }
                }
            }
        }
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

    public int buscarMayor(int arreglo[], int mayor, int indice){
        if(arreglo[indice] > mayor){
            mayor = arreglo[indice]; 
        }
        if(indice + 1 < arreglo.length){
            mayor = buscarMayor(arreglo, mayor, indice + 1);
        }
        return mayor;
    }

    public int sumaElementosMatriz(int[][] matriz, int fila, int columna){
        int sumaTotal = 0;
        if(fila + 1 < matriz.length && columna == 0){
            sumaTotal += sumaElementosMatriz(matriz, fila+1, columna);
        }
        if(columna + 1 < matriz[fila].length){
            sumaTotal += sumaElementosMatriz(matriz, fila, columna+1);
        }
        sumaTotal += matriz[fila][columna];
        return sumaTotal;
    }

    public void validarPerfecto(int numero){
        if(numeroPerfecto(numero, 0, 1) == numero){
            System.out.println("El numero es perfecto");
        }else{
            System.out.println("El numero no es perfecto");
        }
    }

    private int numeroPerfecto(int numero, int suma, int divisor){
        if(numero % divisor == 0){
            suma += divisor;
        }
        divisor++;
        if(numero != divisor){
            suma += numeroPerfecto(numero, 0, divisor);
        }
        return suma;

    }
}
