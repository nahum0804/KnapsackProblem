import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Main class
 */
public class Main {
    private static List<Object> fiveElements;
    private static List<Object> tenElements;
    private static List<Object> twentyElements;
    private static List<Object> thirtyElements;
    private static List<Object> fortyElements;
    private static List<Object> fiftyElements;

    /**
     * Generate a list of objects
     * @param length
     * @return
     */
    private static List<Object> generateList(int length) {
        List<Object> list = new ArrayList<>();

        for (int i = 0; i < length; i++) {
            /**
             * Prototype of the object to add to the list randomly
             */
            Random random = new Random();
            int value = random.nextInt(50) + 1;
            int weight = random.nextInt(50) + 1;
            Object object = new Object("Object " + i, weight, value);
            list.add(object);
            /**
             * ---------------------------------------------------
             */
        }
        return list;
    }

    /**
     * Main method
     * @param args
     */
    public static void main(String[] args) {

        fiveElements = new ArrayList<>();
        fiveElements.add(new Object("Bloqueador", 3, 10));
        fiveElements.add(new Object("Ropa", 5, 10));
        fiveElements.add(new Object("Sombrilla", 2, 7));
        fiveElements.add(new Object("Desodorante", 3, 10));
        fiveElements.add(new Object("Cepillo Dental", 2, 10));

        //Randon between 1 and 50
        Random random = new Random();
        int value = random.nextInt(50) + 1;
        int weight = random.nextInt(50) + 1;

        System.out.println("Value: " + value + " Weight: " + weight);

        /**
         * Genetic Algorithm execution
         */
        GeneticAlgorithm geneticAlgorithm = new GeneticAlgorithm();
        geneticAlgorithm.run(fiveElements, 10);

        System.out.println("\n\n");

        /**
         * Dinamic Algorithm execution
         */
        DinamicAlgorithm dinamicAlgorithm = new DinamicAlgorithm();
        dinamicAlgorithm.run(fiveElements, 10);
    }
}