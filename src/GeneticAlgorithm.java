import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Genetic Algorithm
 */
public class GeneticAlgorithm {

    /**
     * Generate initial population of chromosomes
     * @param items
     * @return
     */
    private static List<List<Integer>> initialPopulation(List<Object> items){
        List<Integer> chromosome = new ArrayList<>();
        List<List<Integer>> population = new ArrayList<>();
        int n = items.size();
        Random random = new Random();
        int randomValue = 0;
        int initialPopulation;

        if(n == 5){
            initialPopulation = 3;

            for(int i = 0; i < initialPopulation; i++){
                for(int j = 0; j < n; j++){
                    randomValue = random.nextInt(2);
                    chromosome.add(randomValue);
                }
                population.add(chromosome);
                chromosome = new ArrayList<>();
            }

        } else{
            initialPopulation = n;
            for(int i = 0; i < initialPopulation; i++){
                for(int j = 0; j < n; j++){
                    randomValue = random.nextInt(2);
                    chromosome.add(randomValue);
                }
                population.add(chromosome);
                chromosome = new ArrayList<>();
            }
        }
        return population;
    }

    /**
     * New population of chromosomes
     * @param population
     * @param items
     * @param maxWeight
     * @return
     */
    private static List<List<Integer>> newPopulation(List<List<Integer>> population, List<Object> items, int maxWeight){
        List<List<Integer>> newPopulation = new ArrayList<>();
        List<Integer> parent1;
        List<Integer> parent2;

        System.out.println("\nCrossover: ");
        for(int i = 0; i < population.size(); i++){
            if(i == population.size() - 1){
                parent1 = population.get(i);
                parent2 = population.get(0);
            } else{
                parent1 = population.get(i);
                parent2 = population.get(i+1);
            }
            List<Integer> child = crossover(parent1, parent2);
            newPopulation.add(child);
        }

        System.out.println("\nMutation: ");
        for(int i = 0; i < newPopulation.size(); i++){
            Random random = new Random();
            int mutationValue = random.nextInt(100);
            if(mutationValue < 10){
                newPopulation.set(i, mutation(newPopulation.get(i)));
            }
        }

        System.out.println("Fitness function: ");
        for(int i = 0; i < newPopulation.size(); i++){
            System.out.println(newPopulation.get(i) + " - " + fitness(newPopulation.get(i), items, maxWeight));
        }

        return newPopulation;
    }

    /**
     * Fitness function
     * @param chromosome
     * @param items
     * @param maxWeight
     * @return
     */
    private static int fitness(List<Integer> chromosome, List<Object> items, int maxWeight){
        int value = 0;
        int weight = 0;
        for(int i = 0; i < chromosome.size(); i++){
            if(chromosome.get(i) == 1){
                value += items.get(i).getValue();
                weight += items.get(i).getWeight();
            }
        }
        if(weight > maxWeight){
            return 0;
        }
        return value;
    }


    /**
     * Crossover of the chromosomes
     * @param parent1
     * @param parent2
     * @return
     */
    private static List<Integer> crossover(List<Integer> parent1, List<Integer> parent2) {
        List<Integer> child = new ArrayList<>();
        Random random = new Random();
        int crossoverPoint = random.nextInt(parent1.size());
        for (int i = 0; i <= crossoverPoint; i++) { // Límite superior
            child.add(parent1.get(i));
        }
        for (int i = crossoverPoint + 1; i < parent2.size(); i++) { // Límite inferior
            child.add(parent2.get(i));
        }
        return child;
    }

    /**
     * Mutation of the chromosome
     * @param chromosome
     * @return
     */
    private static List<Integer> mutation(List<Integer> chromosome){
        Random random = new Random();
        int mutationPoint = random.nextInt(chromosome.size());
        if(chromosome.get(mutationPoint) == 0){
            chromosome.set(mutationPoint, 1);
        } else{
            chromosome.set(mutationPoint, 0);
        }
        return chromosome;
    }


    /**
     * Run the generations
     * @param population
     * @param items
     * @param maxWeight
     * @param generations
     */
    private static void runGenerations(List<List<Integer>> population, List<Object> items, int maxWeight, int generations){
        for(int i = 0; i < generations; i++){
            System.out.println("\nGeneration " + i);
            population = newPopulation(population, items, maxWeight);
        }

        System.out.println("Last generation: ");
        for(int i = 0; i < population.size(); i++){
            System.out.println(population.get(i));
        }
    }


    /**
     * Run the algorithm
     * @param elements
     * @param maxValue
     */
    public static void run(List<Object> elements, int maxValue) {
        List<List<Integer>> initialPopulation = initialPopulation(elements);

        System.out.println("Initial population: ");
        for(int i = 0; i < initialPopulation.size(); i++){
            System.out.println(initialPopulation.get(i));
        }

        runGenerations(initialPopulation, elements, maxValue, 2);
    }
}
