package backtracking;

import java.util.ArrayList;

public class Laberinto{
    
    public static int index = 0;
    public static ArrayList<String> soluciones = new ArrayList<>();
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
		Laberinto m = new Laberinto(); 												// construimos un objeto de la clase Laberinto por defecto
		m.laberinto[1][1] = 'X'; 													// introducimos en este caso, la salida (X) en las coordenadas (1,1)
		m.laberinto[8][1] = 'S';
        m.resolver(8, 1);	
		System.out.println("Cantidad de soluciones encontradas: "+index);													// ahora, introducimos la entrada (S) en las coordenadas (8,1) y llamamos al algoritmo
		//System.out.println(m.imprimirLaberinto()); 								    // imprimimos el laberinto ya resuelto (si tiene solución)
	}

    
    
    
    /* ----------------- IMPLEMENTACIÓN DEL ALGORITMO ----------------- */
    public void resuelve(int x, int y){ 				// permite introducir unas coordenadas (x, y) 
        if (paso(x, y)) { 								// intentará resolver el laberinto en estas coordenadas
            laberinto[x][y] = 'S'; 						// introduce en las coordenadas (x, y) la entrada
	    }
    }
    
    public boolean paso(int x, int y) 
    {

    	 if (laberinto[x][y]=='X'){ // si hemos llegado a X quiere decir que hemos encontrado solución
            return true; // luego, el algoritmo termina
    	 }
    	 
    	 
    	 if (laberinto[x][y]=='#'||laberinto[x][y]=='*' ||laberinto[x][y]=='f') { // si llegamos a una pared o al mismo punto,
    		 return false; // entonces el laberinto no puede resolverse y termina.
    	 }
    	 
    	 // si no se cumple ninguna de estas dos situaciones, quiere decir que nos encontramos en un
    	 // caso intermedio, por lo tanto, que empezamos a recorrer o todavía no hemos llegado a nada
    	 laberinto[x][y]='*'; // marcamos la posición como visitada (si es la primera, en las coordenadas x e y 
    	 
    	 boolean result; // se coloca S de START)

    	 result=paso(x-1, y); // intentamos ir hacia ARRIBA. Segunda llamada recursiva
    	 if (result) System.out.print(imprimirLaberinto()); // si el resultado es el final, entonces el algoritmo termina

    	 result=paso(x, y-1); // intentamos ir hacia la IZQUIERDA. Tercera llamada recursiva
    	 if (result) System.out.print(imprimirLaberinto()); // si el resultado es el final, entonces el algoritmo termina
    	 
    	 result=paso(x, y+1); // intentamos ir hacia la DERECHA. Primera llamada recursiva
    	 if (result) System.out.print(imprimirLaberinto()); // si el resultado es el final, entonces el algoritmo termina

    	 result=paso(x+1, y); // intentamos ir hacia ABAJO. Cuarta llamada recursiva
    	 if (result) System.out.print(imprimirLaberinto()); // si el resultado es el final, entonces el algoritmo termina
    	 
    	 // si no hemos encontrado la solución en estos cuatros movimientos, volvemos atrás, aunque hay que
    	 // considerar que en este punto, todas las llamadas recursivas han finalizado. Si en ninguna de ellas
    	 // se ha conseguido el éxito, entonces el algoritmo termina y devuelve false.
    	 laberinto[x][y]='f'; // en el caso de no ser el resultado, se marca con +. Ya fue pisado
    	 return false; // vuelta atrás si la solución no se encuentra aquí

       
    }

    public void resolver(int x, int y) 
    {

    	 if (laberinto[x][y]=='X'){ // si hemos llegado a X quiere decir que hemos encontrado solución
            System.out.print(imprimirLaberinto() +" \n"); // luego, el algoritmo termina
			soluciones.add(imprimirLaberinto());
			index += 1;
			return;
    	 }
    	 
    	 
    	 if (laberinto[x][y]=='#'||laberinto[x][y]=='*') { // si llegamos a una pared o al mismo punto,
    		 return; // entonces el laberinto no puede resolverse y termina.
    	 }
    	 
    	 // si no se cumple ninguna de estas dos situaciones, quiere decir que nos encontramos en un
    	 // caso intermedio, por lo tanto, que empezamos a recorrer o todavía no hemos llegado a nada
    	 laberinto[x][y]='*'; // marcamos la posición como visitada (si es la primera, en las coordenadas x e y 
    	  // se coloca S de START)

    	 resolver(x-1, y); // intentamos ir hacia ARRIBA. Segunda llamada recursiva
    	  // si el resultado es el final, entonces el algoritmo termina

		resolver(x, y-1); // intentamos ir hacia la IZQUIERDA. Tercera llamada recursiva
    	 // si el resultado es el final, entonces el algoritmo termina
    	 
    	 resolver(x, y+1); // intentamos ir hacia la DERECHA. Primera llamada recursiva
    	 // si el resultado es el final, entonces el algoritmo termina

    	 resolver(x+1, y); // intentamos ir hacia ABAJO. Cuarta llamada recursiva
    	 // si el resultado es el final, entonces el algoritmo termina
    	 
    	 // si no hemos encontrado la solución en estos cuatros movimientos, volvemos atrás, aunque hay que
    	 // considerar que en este punto, todas las llamadas recursivas han finalizado. Si en ninguna de ellas
    	 // se ha conseguido el éxito, entonces el algoritmo termina y devuelve false.
    	 laberinto[x][y]=' '; // en el caso de no ser el resultado, se marca con +. Ya fue pisado
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
