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
     *
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
     *
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
     *
     * @param args
     */
    public static void main(String[] args) {

        fiveElements = firstList();
        tenElements = generateObjects(10);
        twentyElements = generateObjects(20);
        thirtyElements = generateObjects(30);
        fortyElements = generateObjects(40);
        fiftyElements = generateObjects(50);

        // 5 elements
        System.out.println("-----------------------------------------------------");
        System.out.println("5 elementos");
        System.out.println("-----------------------------------------------------");

        /**
         * Genetic Algorithm execution
         */
        System.out.println("-----------------------------------------------------");
        System.out.println("Algoritmo Genético **********************************");
        System.out.println("-----------------------------------------------------");
        GeneticAlgorithm geneticAlgorithm = new GeneticAlgorithm();
        geneticAlgorithm.run(fiveElements, 20);

        System.out.println("-----------------------------------------------------");
        System.out.println("*****************************************************");
        System.out.println("-----------------------------------------------------");
        System.out.println("\n\n");

        /**
         * Dinamic Algorithm execution
         */
        System.out.println("-----------------------------------------------------");
        System.out.println("Algoritmo de Programación Dinámica ******************");
        System.out.println("-----------------------------------------------------");
        DinamicAlgorithm dinamicAlgorithm = new DinamicAlgorithm();

        DinamicAlgorithm.Result result = dinamicAlgorithm.run(fiveElements, 20);
        System.out.println("\nEl valor máximo que se puede obtener es: " + result.getValorMax());
        System.out.println("Los objetos seleccionados son:");
        for (Object item : result.getItemsSelec()) {
            System.out.println(item.getName() + " (Peso: " + item.getWeight() + ", Valor: " + item.getValue() + ")");
        }
        System.out.println("-----------------------------------------------------");
        System.out.println("*****************************************************");
        System.out.println("-----------------------------------------------------\n");


        // 10 elements

        System.out.println("-----------------------------------------------------");
        System.out.println("10 elementos");
        System.out.println("-----------------------------------------------------");

        /**
         * Genetic Algorithm execution
         */
        System.out.println("-----------------------------------------------------");
        System.out.println("Algoritmo Genético **********************************");
        System.out.println("-----------------------------------------------------");
        GeneticAlgorithm geneticAlgorithm2 = new GeneticAlgorithm();
        geneticAlgorithm.run(tenElements, 30);

        System.out.println("-----------------------------------------------------");
        System.out.println("*****************************************************");
        System.out.println("-----------------------------------------------------");
        System.out.println("\n\n");

        /**
         * Dinamic Algorithm execution
         */
        System.out.println("-----------------------------------------------------");
        System.out.println("Algoritmo de Programación Dinámica ******************");
        System.out.println("-----------------------------------------------------");
        DinamicAlgorithm dinamicAlgorithm2 = new DinamicAlgorithm();

        DinamicAlgorithm.Result result2 = dinamicAlgorithm.run(tenElements, 10);
        System.out.println("\nEl valor máximo que se puede obtener es: " + result.getValorMax());
        System.out.println("Los objetos seleccionados son:");
        for (Object item : result.getItemsSelec()) {
            System.out.println(item.getName() + " (Peso: " + item.getWeight() + ", Valor: " + item.getValue() + ")");
        }
        System.out.println("-----------------------------------------------------");
        System.out.println("*****************************************************");
        System.out.println("-----------------------------------------------------\n");



        // 20 elements

        System.out.println("-----------------------------------------------------");
        System.out.println("20 elementos");
        System.out.println("-----------------------------------------------------");

        /**
         * Genetic Algorithm execution
         */
        System.out.println("-----------------------------------------------------");
        System.out.println("Algoritmo Genético **********************************");
        System.out.println("-----------------------------------------------------");
        GeneticAlgorithm geneticAlgorithm3 = new GeneticAlgorithm();
        geneticAlgorithm.run(twentyElements, 40);

        System.out.println("-----------------------------------------------------");
        System.out.println("*****************************************************");
        System.out.println("-----------------------------------------------------");

        System.out.println("\n\n");

        /**
         * Dinamic Algorithm execution
         */
        System.out.println("-----------------------------------------------------");
        System.out.println("Algoritmo de Programación Dinámica ******************");
        System.out.println("-----------------------------------------------------");
        DinamicAlgorithm dinamicAlgorithm3 = new DinamicAlgorithm();

        DinamicAlgorithm.Result result3 = dinamicAlgorithm.run(twentyElements, 40);
        System.out.println("\nEl valor máximo que se puede obtener es: " + result.getValorMax());
        System.out.println("Los objetos seleccionados son:");
        for (Object item : result.getItemsSelec()) {
            System.out.println(item.getName() + " (Peso: " + item.getWeight() + ", Valor: " + item.getValue() + ")");
        }
        System.out.println("-----------------------------------------------------");
        System.out.println("*****************************************************");
        System.out.println("-----------------------------------------------------\n");


        // 30 elements

        System.out.println("-----------------------------------------------------");
        System.out.println("30 elementos");
        System.out.println("-----------------------------------------------------");

        /**
         * Genetic Algorithm execution
         */
        System.out.println("-----------------------------------------------------");
        System.out.println("Algoritmo Genético **********************************");
        System.out.println("-----------------------------------------------------");
        GeneticAlgorithm geneticAlgorithm4 = new GeneticAlgorithm();
        geneticAlgorithm.run(thirtyElements, 50);

        System.out.println("-----------------------------------------------------");
        System.out.println("*****************************************************");
        System.out.println("-----------------------------------------------------");

        System.out.println("\n\n");

        /**
         * Dinamic Algorithm execution
         */
        System.out.println("-----------------------------------------------------");
        System.out.println("Algoritmo de Programación Dinámica ******************");
        System.out.println("-----------------------------------------------------");
        DinamicAlgorithm dinamicAlgorithm4 = new DinamicAlgorithm();

        DinamicAlgorithm.Result result4 = dinamicAlgorithm.run(thirtyElements, 50);
        System.out.println("\nEl valor máximo que se puede obtener es: " + result.getValorMax());
        System.out.println("Los objetos seleccionados son:");
        for (Object item : result.getItemsSelec()) {
            System.out.println(item.getName() + " (Peso: " + item.getWeight() + ", Valor: " + item.getValue() + ")");
        }

        System.out.println("-----------------------------------------------------");
        System.out.println("*****************************************************");
        System.out.println("-----------------------------------------------------\n");


        // 40 elements

        System.out.println("-----------------------------------------------------");
        System.out.println("40 elementos");
        System.out.println("-----------------------------------------------------");

        /**
         * Genetic Algorithm execution
         */
        System.out.println("-----------------------------------------------------");
        System.out.println("Algoritmo Genético **********************************");
        System.out.println("-----------------------------------------------------");
        GeneticAlgorithm geneticAlgorithm5 = new GeneticAlgorithm();
        geneticAlgorithm.run(fortyElements, 60);

        System.out.println("-----------------------------------------------------");
        System.out.println("*****************************************************");
        System.out.println("-----------------------------------------------------");

        System.out.println("\n\n");

        /**
         * Dinamic Algorithm execution
         */
        System.out.println("-----------------------------------------------------");
        System.out.println("Algoritmo de Programación Dinámica ******************");
        System.out.println("-----------------------------------------------------");
        DinamicAlgorithm dinamicAlgorithm5 = new DinamicAlgorithm();

        DinamicAlgorithm.Result result5 = dinamicAlgorithm.run(fortyElements, 60);
        System.out.println("\nEl valor máximo que se puede obtener es: " + result.getValorMax());
        System.out.println("Los objetos seleccionados son:");
        for (Object item : result.getItemsSelec()) {
            System.out.println(item.getName() + " (Peso: " + item.getWeight() + ", Valor: " + item.getValue() + ")");
        }

        System.out.println("-----------------------------------------------------");
        System.out.println("*****************************************************");
        System.out.println("-----------------------------------------------------\n");


        // 50 elements

        System.out.println("-----------------------------------------------------");
        System.out.println("50 elementos");
        System.out.println("-----------------------------------------------------");

        /**
         * Genetic Algorithm execution
         */
        System.out.println("-----------------------------------------------------");
        System.out.println("Algoritmo Genético **********************************");
        System.out.println("-----------------------------------------------------");
        GeneticAlgorithm geneticAlgorithm6 = new GeneticAlgorithm();
        geneticAlgorithm.run(fiftyElements, 70);

        System.out.println("-----------------------------------------------------");
        System.out.println("*****************************************************");
        System.out.println("-----------------------------------------------------");

        System.out.println("\n\n");

        /**
         * Dinamic Algorithm execution
         */
        System.out.println("-----------------------------------------------------");
        System.out.println("Algoritmo de Programación Dinámica ******************");
        System.out.println("-----------------------------------------------------");
        DinamicAlgorithm dinamicAlgorithm6 = new DinamicAlgorithm();

        DinamicAlgorithm.Result result6 = dinamicAlgorithm.run(fiftyElements, 70);
        System.out.println("\nEl valor máximo que se puede obtener es: " + result.getValorMax());
        System.out.println("Los objetos seleccionados son:");
        for (Object item : result.getItemsSelec()) {
            System.out.println(item.getName() + " (Peso: " + item.getWeight() + ", Valor: " + item.getValue() + ")");
        }

        System.out.println("-----------------------------------------------------");
        System.out.println("*****************************************************");
        System.out.println("-----------------------------------------------------\n");
    }
}