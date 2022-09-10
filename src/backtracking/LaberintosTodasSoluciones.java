package backtracking;

import java.util.ArrayList;

public class LaberintosTodasSoluciones {
    public static int index = 0;            //Variable para conteo de soluciones
    public static ArrayList<String> soluciones = new ArrayList<>();     //Variable donde se guardan todas las soluciones
    public char[][] laberinto={ 
        {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},
	    {'#', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', '#'},
	    {'#', ' ', '#', ' ', '#', '#', '#', '#', ' ', '#'},
	    {'#', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', '#'},
	    {'#', ' ', '#', ' ', ' ', ' ', '#', '#', '#', '#'},
	    {'#', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', '#'},
	    {'#', '#', '#', '#', '#', ' ', '#', '#', '#', '#'},
	    {'#', ' ', ' ', ' ', '#', ' ', '#', ' ', '#', '#'},
	    {'#', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', '#'},
	    {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},
    };
    
    
    /* --------------------- PRUEBA DEL ALGORITMO --------------------- */
	public static void main(String[] args) {
		LaberintosTodasSoluciones m = new LaberintosTodasSoluciones(); 												// construimos un objeto de la clase
		m.laberinto[1][1] = 'X'; 													// introducimos en este caso, el punto a encontrar (X) en las coordenadas (1,1)
        m.resolver(8, 1);	                                            //resolvemos el laberinto
        for(String solucion : soluciones){
            System.out.println(solucion);
        }
		System.out.println("Cantidad de soluciones encontradas: "+index);	//imprimimos la cantidad de soluciones
    }

    public void resolver(int x, int y) {
    	 if (laberinto[x][y]=='X'){ // si hemos llegado a X quiere decir que hemos encontrado una solución
            laberinto[8][1]='S';    //Damos valor al punto de salida 
			soluciones.add(imprimirLaberinto()); //Agregamos la solucion a la lista de soluciones
			index += 1;             //Sumamos uno a la cantidad de soluciones encontradas
			return;                 // retornamos a la llamada del metodo anterior para seguir con la busqueda de soluciones
    	 }
    	 
    	 
    	 if (laberinto[x][y]=='#'||laberinto[x][y]=='*') { // si llegamos a una pared o al mismo punto,
    		 return; // entonces el volvemos a la llamada anterior del metodo.
    	 }
    	 
    	 // si no se cumple ninguna de estas dos situaciones, quiere decir que nos encontramos en un
    	 // caso intermedio, por lo tanto, que empezamos a recorrer o todavía no hemos llegado a nada
    	 laberinto[x][y]='*'; // marcamos la posición como visitada (si es la primera, en las coordenadas x e y 
    	  // se coloca S de START)

    	 resolver(x-1, y); // intentamos ir hacia ARRIBA. Segunda llamada recursiva

		resolver(x, y-1); // intentamos ir hacia la IZQUIERDA. Tercera llamada recursiva
    	 
    	 resolver(x, y+1); // intentamos ir hacia la DERECHA. Primera llamada recursiva

    	 resolver(x+1, y); // intentamos ir hacia ABAJO. Cuarta llamada recursiva
    	 
    	 // si no hemos encontrado la solución en estos cuatros movimientos, volvemos atrás, aunque hay que
    	 // considerar que en este punto, todas las llamadas recursivas han finalizado. Si en ninguna de ellas
    	 // se ha conseguido el éxito, entonces el algoritmo termina y devuelve false.
    	 laberinto[x][y]=' '; // en el caso de no ser el resultado, se demarca la posicion actual
		 return;// vuelta atrás si la solución no se encuentra aquí
    }
	
    private String imprimirLaberinto() { // imprimiremos nuestra solución. Debido a que la clase Arrays no tiene implementado
        String salida = "";    // un método toString para arrays bidimensionales, lo programamos a mano
        for (int x=0; x<laberinto.length; x++) { // recorremos filas
            for (int y=0; y<laberinto[x].length; y++) { // recorremos columnas
                salida += laberinto[x][y] + " "; // output es nuestra variable que va almacenando los valores a imprimir
            }
            salida += "\n"; // devolvemos esta variable con un salto de línea
        }
        return salida;
    }
	
}
