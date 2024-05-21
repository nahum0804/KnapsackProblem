import java.util.List;

/**
 * Genetic Algorithm
 */
public class GeneticAlgorithm {

    /**
     * Algorithm for filling the rucksack
     * @param elements
     * @param maxValue
     */
    private static void mochila(List<Object> elements, int maxValue) {
        System.out.println("Genetic Algorithm!");

        for (Object element : elements) {
            String weight = String.valueOf(element.getWeight());
            String value = String.valueOf(element.getValue());
            System.out.println(element.getName() + " - " + weight + " - " + value);
        }
    }

    /**
     * Run the algorithm
     * @param elements
     * @param maxValue
     */
    public static void run(List<Object> elements, int maxValue) {
        mochila(elements, maxValue);
    }
}
