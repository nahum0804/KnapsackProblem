import java.util.ArrayList;
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
     * Function to generate the chromosome
     * @param items
     * @param max
     * @return
     */
    private static List<Integer> chromosome(List<Object> items, int max){
        List<Integer> selected = new ArrayList<>();
        int n = items.size();
        int counterValue = 0;
        for(int i = 0; i < n; i++){
            Object item = items.get(i);
            if(counterValue + item.getValue() <= max){
                selected.add(1);
                counterValue += item.getValue();
            } else {
                selected.add(0);
            }
        }
        return selected;
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
