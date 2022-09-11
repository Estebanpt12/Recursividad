package ejerciciosTaller;

public class InvertirPalabra {

    public static void main(String[] args) {
        InvertirPalabra invertirPalabra = new InvertirPalabra();
        System.out.println(invertirPalabra.inv("monom", 4));
    }

    public String inv(String palabra, int index){
        String palabraInvertida = new String();
        if(index >= 0){
            palabraInvertida += String.valueOf(palabra.charAt(index));
            palabraInvertida += inv(palabra, index-1);
        }
        return palabraInvertida;
    }
}
