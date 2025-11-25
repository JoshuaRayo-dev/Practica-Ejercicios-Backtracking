import java.util.Arrays;

public class ProblemaMochila 
{

    private int pesoMax = 10;
    private int[] valores = {3,5,2,1,6,9};
    private int[] pesos = {4,2,8,3,5,7};
    
    public ProblemaMochila()
    {
    }

    public int llenarMochila(int valorAcumulado, int pesoAcumulado, boolean[] seIncluye, int cursor)
    {
        int resultado;
        int camino1 = valorAcumulado;
        int camino2 = valorAcumulado;
        // En algun momento tiene que detenerse
        if (cursor == valores.length) {
            resultado = valorAcumulado;
        }
        else {
            // Si no se pasa del peso, toma la decision de incluirlo si o si
            if (!(pesoAcumulado + pesos[cursor] > this.pesoMax)) {
                seIncluye[cursor] = true;
                camino1 = llenarMochila(valorAcumulado + valores[cursor],
                                            pesoAcumulado + pesos[cursor],
                                            seIncluye,
                                            cursor + 1);
            }
            // Despues, toma el camino de no incluirlo, independientemente de si pudo incluirlo o no, este paso se da siempre.
            // Se supone que aqui sucede el backtrack, marca su paso como falso y toma el otro camino.
            seIncluye[cursor] = false;
            camino2 = llenarMochila(valorAcumulado,
                                        pesoAcumulado,
                                        seIncluye,
                                        cursor + 1);
            resultado = Math.max(camino1, camino2);
        }
        return resultado;

        // En algun momento tiene que validar que no se pase del pesoMax
        // Devuelve el valor maximo entre dos llamadas recursivas
        // Una que incluye al objeto en el que estamos iterando
        // Y otra que no lo incluye
    }
    
    public static void main(String args[])
    {

        // Cuando llamemos a llenarMochila, debe devolver 14
        // Si lo hicimos bien haciendo recursividad con backtracking y fuerza bruta,
        // podemos ser felices.
        // Esto vale 5 puntos (1 tarea)
        // Pero tienen 1 punto extra, si hacen Sudoku ademas.
        // Y ademas, tienen 1 punto extra mas, si hacen Suma de Subconjuntos.
        ProblemaMochila p = new ProblemaMochila();
        boolean[] seIncluye = {false, false, false, false, false, false};
        int resultado = p.llenarMochila(0, 0, seIncluye, 0);
        System.out.println("El maximo valor posible para este problema es: " + resultado);

    }
}