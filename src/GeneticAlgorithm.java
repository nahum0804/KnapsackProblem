import java.util.List;
public class GeneticAlgorithm {
    public static void run(List<Object> elements, int maxWeight) {
        System.out.println("Genetic Algorithm!");

        for (Object element : elements) {
            System.out.println(element.getName());
        }
    }
}
