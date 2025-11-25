public class SumaSubconjuntos {
    private int[] conjunto = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
    private int objetivo = 14;

    public SumaSubconjuntos() {
    }

    public void resolver(int sumatoria, int cursor, String incluido) {
        // Caso base llega al final del conjunto
        if (cursor == conjunto.length) {
            // Si la sumatoria de todos los elementos que eligio coincide con el objetivo,
            // imprime la concatenacion de todos esos enteros
            if (sumatoria == objetivo) {
                System.out.println("Solución: " + incluido);
            }
            // Sino, pues no hace nada, se devuelve :P
            return;
        }

        // Aqui incluye un numero si no se pasa del objetivo
        if (sumatoria + conjunto[cursor] <= objetivo) {
            resolver(sumatoria + conjunto[cursor], cursor + 1,
                    (incluido + conjunto[cursor]) + " "); // En este paso concatena los enteros y los convierte a strings
        }

        // Otro camino, no lo incluye, este lo toma siempre
        resolver(sumatoria, cursor + 1, incluido);
    }


    public static void main(String[] args) {

        SumaSubconjuntos s = new SumaSubconjuntos();
        s.resolver(0, 0, "");
    }
}
