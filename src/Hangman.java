import java.util.Scanner;

public class Hangman {
    public static void main(String[] args) throws Exception {

        // Clase scanner para leer la entrada del usuario
        Scanner sc = new Scanner(System.in);

        // Declaraciones y asignacion de variables
        String palabraSecreta = "PROGRAMACION";
        int intentosMaximos = 10;
        int intentosActuales = 0;
        boolean palabraAdivinada = false;

        // Arreglo de caracteres para guardar las letras adivinadas
        char[] letrasAdivinadas = new char[palabraSecreta.length()];

        // Mensaje de bienvenida
        System.out.println("¡Bienvenido al juego del ahorcado!");
        System.out.println("Adivina la palabra secreta. La palabra tiene " + palabraSecreta.length() + " letras.");
        System.out.println("");

        // Estructura de control iterativa
        for (int i = 0; i < letrasAdivinadas.length; i++) {
            letrasAdivinadas[i] = '_';
        }

        // Estructura de control iterativa
        while (!palabraAdivinada && intentosActuales < intentosMaximos) {
            System.out.println("Intentos restantes: " + (intentosMaximos - intentosActuales));
            System.out.println("palabra a adivinar: " + String.valueOf(letrasAdivinadas));

            char letra = Character.toUpperCase(sc.next().charAt(0));
            boolean letraCorrecta = false;

            // Estructura de control iterativa y condicional de letra correcta
            for (int i = 0; i < palabraSecreta.length(); i++) {
                if (palabraSecreta.charAt(i) == letra) {
                    letrasAdivinadas[i] = letra;
                    letraCorrecta = true;
                }
            }

            // Estructura condicional de letra correcta
            if (letraCorrecta) {
                System.out.println("¡Correcto!");
                letrasAdivinadas.toString();
            } else {
                System.out.println("¡Incorrecto!");
                intentosActuales++;
            }

            // Estructura condicional de juego ganado
            if (String.valueOf(letrasAdivinadas).equals(palabraSecreta)) {
                palabraAdivinada = true;
                System.out.println("Felicidades, has adivinado la palabra secreta! " + palabraSecreta);
            }
        }

        // Estructura condicional de juego perdido 
        if (!palabraAdivinada) {
            System.out.println("Lo siento, has agotado tus intentos. La palabra secreta era: " + palabraSecreta);
        }

        System.out.println("Fin del juego");

        sc.close(); // Importante cerrar el scanner
    }
}
