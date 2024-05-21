import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Main class
 */
public class Main {

    private static List<String> objects;

    /**
     * List of objects with different lengths
     */
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
     * Generate initial list of objects with 5 elements
     * @return
     */
    private static List<Object> firstList() {
        List<Object> list = new ArrayList<>();
        list.add(new Object("Bloqueador", 3, 10));
        list.add(new Object("Ropa", 5, 10));
        list.add(new Object("Sombrilla", 2, 7));
        list.add(new Object("Desodorante", 3, 10));
        list.add(new Object("Cepillo Dental", 2, 10));
        return list;
    }

    /**
     * Generate a list of objects with a specific length
     * @param length
     * @return
     */
    private static List<Object> generateObjects(int length) {
        length = length - 5;
        List<Object> list = firstList();

        int k = 6;
        for (int i = 0; i < length; i++) {
            /**
             * Prototype of the object to add to the list randomly
             */
            Random random = new Random();
            int value = random.nextInt(50) + 1;
            int weight = random.nextInt(50) + 1;
            Object object = new Object("Object " + k, weight, value);
            k++;
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

        fiveElements = firstList();
        tenElements = generateObjects(10);

        /**
         * Genetic Algorithm execution
         */
        GeneticAlgorithm geneticAlgorithm = new GeneticAlgorithm();
        geneticAlgorithm.run(tenElements, 10);

        System.out.println("\n\n");

        /**
         * Dinamic Algorithm execution
         */
        DinamicAlgorithm dinamicAlgorithm = new DinamicAlgorithm();
        dinamicAlgorithm.run(tenElements, 10);
    }
}