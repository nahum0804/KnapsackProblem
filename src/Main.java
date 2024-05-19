import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Object> elements = new ArrayList<>();
        elements.add(new Object("Bloqueador", 5, 10));
        elements.add(new Object("Paño", 3, 5));
        elements.add(new Object("Sombrilla", 2, 7));
        elements.add(new Object("Sandalias", 4, 9));
        elements.add(new Object("Toalla", 3, 4));

        /**
         * Genetic Algorithm execution
         */
        GeneticAlgorithm geneticAlgorithm = new GeneticAlgorithm();
        geneticAlgorithm.run(elements, 10);

        System.out.println("\n\n");

        /**
         * Dinamic Algorithm execution
         */
        DinamicAlgorithm dinamicAlgorithm = new DinamicAlgorithm();
        dinamicAlgorithm.run(elements, 10);
    }
}