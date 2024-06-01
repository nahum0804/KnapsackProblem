import java.util.ArrayList;
import java.util.List;

/**
 * Dynamic Algorithm
 */
public class DinamicAlgorithm {

    public static int a = 0; // Assignments
    public static int c = 0; // Comparisons
    public static int m = 0; // Memory

    /**
     * Result class
     */
    public static class Result {
        int valorMax;
        int pesoTotal;
        List<Object> itemsSelec;

        /**
         * Constructor
         * @param valorMax
         * @param pesoTotal
         * @param itemsSelec
         */
        public Result(int valorMax, int pesoTotal, List<Object> itemsSelec) {
            this.valorMax = valorMax;
            m += 32;
            this.pesoTotal = pesoTotal;
            m += 32;
            this.itemsSelec = itemsSelec;
            //m += ??;
            a += 3;
        }

        /**
         * Getters
         */

        /**
         * Get the maximum value
         * @return
         */
        public int getValorMax() {
            return valorMax;
        }

        /**
         * Get the total weight
         * @return
         */
        public int getPesoTotal() {
            return pesoTotal;
        }

        /**
         * Get the selected items
         * @return
         */
        public List<Object> getItemsSelec() {
            return itemsSelec;
        }
    }

    /**
     * Algorithm for filling the rucksack
     * @param elements
     * @param maxValue
     */
    private static void mochila(List<Object> elements, int maxValue) {
        List<List<Object>> matrix = new ArrayList<>();
        //m += ??;
        a++;

        System.out.println("Dynamic Algorithm!");

        for (Object element : elements) {
            String weight = String.valueOf(element.getWeight());
            //m += ??;
            String value = String.valueOf(element.getValue());
            //m += ??;
            a += 2;
            System.out.println(element.getName() + " - " + weight + " - " + value);
        }
    }

    /**
     * Dynamic algorithm for filling the rucksack
     * @param items
     * @param maximo
     * @return
     */
    public static Result mochilaDinamica(List<Object> items, int maximo) {
        int n = items.size();
        m += 32;
        int[][] dp = new int[n + 1][maximo + 1];
        m += 32;
        a += 2;

        for (int i = 1; i <= n; i++) {
            c++;
            for (int w = 1; w <= maximo; w++) {
                c++;
                Object item = items.get(i - 1);
                //m += ??;
                a++;
                if (item.getWeight() <= w) {
                    dp[i][w] = Math.max(dp[i - 1][w], dp[i - 1][w - item.getWeight()] + item.getValue());
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
                c++;
                a++;
            }

            if (i % 5 == 0 || i == n) {
                System.out.println("Etapa " + i + ":");
                for (int k = 0; k <= maximo; k++) {
                    c++;
                    System.out.print(dp[i][k] + " ");
                }
                System.out.println();
            }
            c += 2;
        }

        List<Object> itemsSelec = new ArrayList<>();
        //m += ??;
        int w = maximo;
        m += 32;
        int pesoTotal = 0;
        m += 32;
        a += 3;

        for (int i = n; i > 0 && w > 0; i--) {
            c++;
            if (dp[i][w] != dp[i - 1][w]) {
                Object item = items.get(i - 1);
                //m += ??;
                itemsSelec.add(item);
                w -= item.getWeight();
                pesoTotal += item.getWeight();
            }
            c++;
        }

        return new Result(dp[n][maximo], pesoTotal, itemsSelec);
    }

    /**
     * Run the algorithm
     * @param elements
     * @param maxValue
     */
    public static Result run(List<Object> elements, int maxValue) {
        Result result = mochilaDinamica(elements, maxValue);
        //m += ??;
        a++;
        System.out.println("\n");
        System.out.println("Valor máximo: " + result.getValorMax());
        System.out.println("Peso total: " + result.getPesoTotal());
        System.out.println("\n");
        System.out.println("Objetos seleccionados:");
        for (Object item : result.getItemsSelec()) {
            System.out.println(item.getName() + " - Valor: " + item.getValue() + " - Peso: " + item.getWeight());
        }

        System.out.println("\nMediciones: ---------------------------------");
        System.out.println("Asignaciones: " + a);
        System.out.println("Comparaciones: " + c);
        System.out.println("Tiempo: ");
        System.out.println("Memoria: " + m + " bits");
        return result;
    }
}
