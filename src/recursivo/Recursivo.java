package recursivo;

public class Recursivo{

    public String recursivoConsonantes(String palabra, int index){
        palabra = palabra.toLowerCase();
        String consonantes = new String();
        if((palabra.charAt(index) != 'a' && palabra.charAt(index) != 'e' && palabra.charAt(index) != 'i' &&
                palabra.charAt(index) != 'o' && palabra.charAt(index) != 'u')){
            consonantes += Character.toString(palabra.charAt(index));
        }
        if(index + 1 < palabra.length()){
            consonantes += recursivoConsonantes(palabra, index + 1);
        }
        return consonantes;
    }
}