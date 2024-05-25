import java.util.ArrayList;
import java.util.List;

/**
 * Dinamic Algorithm
 */
public class DinamicAlgorithm {

    //Clase para almacenar el resultado
    public static class Result {
        int valorMax;
        List<Object> itemsSelec;

        public Result(int valorMax, List<Object> itemsSelec){
            this.valorMax = valorMax;
            this.itemsSelec = itemsSelec;
        }

        public int getValorMax(){
            return valorMax;
        }
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

        System.out.println("Dinamic Algorithm!");

        for (Object element : elements) {
            String weight = String.valueOf(element.getWeight());
            String value = String.valueOf(element.getValue());
            System.out.println(element.getName() + " - " + weight + " - " + value);
        }
    }

    public static Result mochilaDinamica(List<Object> items, int maximo){
        int n = items.size();
        int[][] dp = new int[n + 1][maximo + 1];

        for (int i = 1;i <= n;i++){
            for (int w = 1;w <= maximo; w++){
                Object item = items.get(i-1);
                if(item.getWeight() <= w){
                    dp[i][w] = Math.max(dp[i-1][w],dp[i-1][w-item.getWeight()]+item.getValue());
                }
                else{
                    dp[i][w] = dp[i-1][w];
                }
            }
        }
        List<Object> itemsSelec = new ArrayList<>();
        int w = maximo;
        for(int i = n;i>0&& w>0;i--){
            if(dp[i][w] != dp[i-1][w]){
                Object item = items.get(i-1);
                itemsSelec.add(item);
                w-= item.getWeight();
            }
        }
        return new Result(dp[n][maximo], itemsSelec);
    }

    /**
     * Run the algorithm
     * @param elements
     * @param maxValue
     */
    public static Result run(List<Object> elements, int maxValue) {
        Result result = mochilaDinamica(elements, maxValue);
        return result;
    }
}
