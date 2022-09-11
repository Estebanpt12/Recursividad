package backtracking;

import java.util.ArrayList;

public class LaberintoHospital {
    
    private char[][] laberinto = { 
        {' ', ' ', ' ', ' ', ' ', '1', ' ', ' '},
	    {' ', '1', '1', ' ', '1', '1', ' ', '1'},
	    {' ', ' ', '1', ' ', ' ', ' ', ' ', ' '},
	    {'1', ' ', ' ', ' ', ' ', '1', '1', ' '},
	    {'1', ' ', '1', '1', ' ', '1' ,'1', ' '},
	    {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
	    {'1', ' ', '1', ' ', '1', '1', ' ', '1'}
    };
    private ArrayList<String> solucionesLaberinto =  new ArrayList<>(); 

    public static void main(String[] args) {
        LaberintoHospital laberintoHospital = new LaberintoHospital();
        laberintoHospital.laberinto[6][6] = 'X';
        laberintoHospital.resolverLaberintoP(0, 0);
        for(String solucion: laberintoHospital.solucionesLaberinto){
            System.out.println(solucion);
        }
    }

    public void resolverLaberintoP(int x, int y){
        if(laberinto!=null){
            resolverLaberinto(x, y);
        }
    }

    private void resolverLaberinto(int x, int y){
        if(laberinto[x][y]=='X'){
            laberinto[0][0] = 'S';
            solucionesLaberinto.add(imprimirLaberinto());
            return;
        }

        if(laberinto[x][y]=='1' || laberinto[x][y]=='V'){
            return;
        }

        laberinto[x][y]='V';

        if(y-1>=0){
            resolverLaberinto(x, y-1);
        }
        if(x-1>=0){
            resolverLaberinto(x-1, y);
        }
        if(x+1<laberinto.length){
            resolverLaberinto(x+1, y);
        }
        if(y+1<laberinto[0].length){
            resolverLaberinto(x, y+1);
        }

        laberinto[x][y]=' ';
        return;
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
