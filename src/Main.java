import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        MovieQuery movieQuery = new MovieQuery();

        boolean validInput = false;
        while (!validInput) {
            System.out.println("Escribe el número de la Película del 1 al 7, de Star Wars: ");

            try {
                var movieNumber = Integer.valueOf(teclado.nextLine());

                // Verificar el número válido
                if (movieNumber < 1 || movieNumber > 7) {
                    System.out.println("Número no válido. Debe estar entre 1 y 7.");
                } else {
                    Movie movie = movieQuery.searchMovie(movieNumber);
                    System.out.println(movie);
                    validInput = true; // Establecer validInput a true si el número es válido
                    FileGenerator generator = new FileGenerator();
                    generator.saveJson(movie);
                }
            } catch (Exception e) {
                System.out.println("Entrada no válida. Por favor, ingresa un número entero entre 1 y 7.");
            }
        }
        System.out.println("¡Gracias por usar la aplicación! ¡Que la Fuerza te acompañe en cada paso que des!");
        teclado.close();
    }
}

