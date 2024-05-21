import java.util.ArrayList;
import java.util.List;

/**
 * Dinamic Algorithm
 */
public class DinamicAlgorithm {

    /**
     * Algorithm for filling the rucksack
     * @param elements
     * @param maxValue
     */
    private static void mochila(List<Object> elements, int maxValue) {
        List<List<Object>> matrix = new ArrayList<>();

        System.out.println("Dinamic Algorithm!");

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
