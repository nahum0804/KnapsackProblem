import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

/**
 * Genetic Algorithm
 */
public class GeneticAlgorithm {

    public static int a = 0; // Asignaciones
    public static int c = 0; // Comparaciones

    public static int m = 0; //Memoria

    /**
     * Generate initial population of chromosomes
     * @param items
     * @param maxWeight
     * @return
     */
    private static List<List<Integer>> initialPopulation(List<Object> items, int maxWeight) {
        List<List<Integer>> population = new ArrayList<>();
        //m += ??;
        int n = items.size();
        m += 32;
        int initialPopulationSize;
        m += 32;
        Random random = new Random();
        //m += ??;

        a += 3;

        if(items.size() == 5){
            initialPopulationSize = 3;
            a++;
        } else {
            initialPopulationSize = items.size();
            a++;
        }
        c++;

        while (population.size() < initialPopulationSize) {
            c++;
            List<Integer> chromosome = new ArrayList<>();
            //m += ??;
            a++;
            for (int j = 0; j < n; j++) {
                c++;
                chromosome.add(random.nextInt(2));
                a++;
            }
            if (getWeight(chromosome, items) <= maxWeight) {
                population.add(chromosome);
                a++;
            }
            c++;
        }
        return population;
    }

    /**
     * Generate a new population of chromosomes
     * @param population
     * @param items
     * @param maxWeight
     * @param isFirstGeneration
     * @return
     */
    private static List<List<Integer>> newPopulation(List<List<Integer>> population, List<Object> items, int maxWeight, boolean isFirstGeneration) {
        List<List<Integer>> newPopulation = new ArrayList<>();
        //m += ??;
        Random random = new Random();
        //m += ??;
        int targetSize = isFirstGeneration ? population.size() * 2 : population.size();
        m += 32;
        a += 3;

        while (newPopulation.size() < targetSize) {
            c++;
            List<Integer> parent1 = tournamentSelection(population, items, maxWeight);
            //m += ??;
            List<Integer> parent2 = tournamentSelection(population, items, maxWeight);
            //m += ??;

            int parent1Fitness = fitness(parent1, items, maxWeight);
            m += 32;
            int parent2Fitness = fitness(parent2, items, maxWeight);
            m += 32;

            List<Integer> child1 = crossover(parent1, parent2);
            //m += ??;
            List<Integer> child2 = crossover(parent2, parent1);
            //m += ??;
            a += 6;

            if (random.nextInt(100) < 10) {
                List<Integer> originalChild1 = new ArrayList<>(child1);
                //m += ??;
                child1 = mutation(child1);
                int mutationChild1Fitness = fitness(child1, items, maxWeight);
                m += 32;
                a += 3;
                System.out.println("Individuo 1: " + originalChild1 + " - Puntuación: " + fitness(originalChild1, items, maxWeight));
                System.out.println("Mutación: " + child1 + " - Puntuación: " + mutationChild1Fitness);
                System.out.println();
            }
            c++;

            if (random.nextInt(100) < 10) {
                List<Integer> originalChild2 = new ArrayList<>(child2);
                //m += ??;
                child2 = mutation(child2);
                int mutationChild2Fitness = fitness(child2, items, maxWeight);
                m += 32;
                a += 3;
                System.out.println("Individuo 2: " + originalChild2 + " - Puntuación: " + fitness(originalChild2, items, maxWeight));
                System.out.println("Mutación: " + child2 + " - Puntuación: " + mutationChild2Fitness);
                System.out.println();
            }
            c++;

            if (getWeight(child1, items) <= maxWeight) {
                newPopulation.add(child1);
                a++;
            }
            if (getWeight(child2, items) <= maxWeight) {
                newPopulation.add(child2);
                a++;
            }
            c += 2;

            int child1Fitness = fitness(child1, items, maxWeight);
            m += 32;
            int child2Fitness = fitness(child2, items, maxWeight);
            m += 32;

            a += 2;

            // Print crossover and fitness information
            System.out.println("Padre 1: " + parent1 + " - Puntuación: " + parent1Fitness);
            System.out.println("Padre 2: " + parent2 + " - Puntuación: " + parent2Fitness);
            System.out.println("Hijo 1: " + child1 + " - Puntuación: " + child1Fitness);
            System.out.println("Hijo 2: " + child2 + " - Puntuación: " + child2Fitness);
            System.out.println();
        }

        return newPopulation;
    }

    /**
     * Tournament selection of the best chromosome
     * @param population
     * @param items
     * @param maxWeight
     * @return
     */
    private static List<Integer> tournamentSelection(List<List<Integer>> population, List<Object> items, int maxWeight) {
        Random random = new Random();
        //m += ??;
        List<Integer> bestChromosome = null;
        //m += ??;
        int bestFitness = -1;
        m += 32;
        a += 3;

        for (int i = 0; i < 3; i++) {
            c++;
            List<Integer> chromosome = population.get(random.nextInt(population.size()));
            //m += ??;
            int fitness = fitness(chromosome, items, maxWeight);
            m += 32;
            a += 2;
            if (fitness > bestFitness) {
                bestFitness = fitness;
                bestChromosome = chromosome;
                a += 2;
            }
            c++;
        }

        return bestChromosome;
    }

    /**
     * Fitness function to evaluate a chromosome
     * @param chromosome
     * @param items
     * @param maxWeight
     * @return
     */
    private static int fitness(List<Integer> chromosome, List<Object> items, int maxWeight) {
        int value = 0;
        m += 32;
        int weight = 0;
        m += 32;
        a += 2;
        for (int i = 0; i < chromosome.size(); i++) {
            c++;
            if (chromosome.get(i) == 1) {
                value += items.get(i).getValue();
                weight += items.get(i).getWeight();
                a += 2;
            }
            c++;
        }
        if (weight > maxWeight) {
            return 0;
        }
        c++;
        return value;
    }

    /**
     * Crossover of two parent chromosomes to create a child chromosome
     * @param parent1
     * @param parent2
     * @return
     */
    private static List<Integer> crossover(List<Integer> parent1, List<Integer> parent2) {
        List<Integer> child = new ArrayList<>();
        //m += ??;
        Random random = new Random();
        //m += ??;
        int crossoverPoint = random.nextInt(parent1.size());
        m += 32;
        a += 3;
        for (int i = 0; i <= crossoverPoint; i++) {
            c++;
            child.add(parent1.get(i));
            a++;
        }
        for (int i = crossoverPoint + 1; i < parent2.size(); i++) {
            c++;
            child.add(parent2.get(i));
            a++;
        }
        return child;
    }

    /**
     * Mutation of a chromosome
     * @param chromosome
     * @return
     */
    private static List<Integer> mutation(List<Integer> chromosome) {
        Random random = new Random();
        //m += ??;
        int mutationPoint = random.nextInt(chromosome.size());
        m += 32;
        a += 2;
        chromosome.set(mutationPoint, 1 - chromosome.get(mutationPoint));
        return chromosome;
    }

    /**
     * Get the weight of a chromosome
     * @param chromosome
     * @param items
     * @return
     */
    private static int getWeight(List<Integer> chromosome, List<Object> items) {
        int weight = 0;
        m += 32;
        a++;
        for (int i = 0; i < chromosome.size(); i++) {
            c++;
            if (chromosome.get(i) == 1) {
                weight += items.get(i).getWeight();
                a++;
            }
            c++;
        }
        return weight;
    }

    /**
     * Run the generations of the genetic algorithm
     * @param population
     * @param items
     * @param maxWeight
     * @param generations
     */
    private static void runGenerations(List<List<Integer>> population, List<Object> items, int maxWeight, int generations) {
        boolean isFirstGeneration = true;
        m += 1;
        a++;

        for (int i = 0; i < generations; i++) {
            c++;
            System.out.println("\nGeneration " + i + " is done!");
            population = newPopulation(population, items, maxWeight, isFirstGeneration);
            isFirstGeneration = false;
            a += 2;
        }

        System.out.println("Last generation: ");
        for (List<Integer> chromosome : population) {
            c++;
            System.out.println(chromosome + " - Value: " + fitness(chromosome, items, maxWeight) + " - Weight: " + getWeight(chromosome, items));
        }

        // Sort population by fitness in descending order
        population.sort(Comparator.comparingInt(c -> -fitness(c, items, maxWeight)));

        // Print the top 5 chromosomes
        System.out.println("\nTop 5 chromosomes:");
        for (int i = 0; i < Math.min(5, population.size()); i++) {
            c++;
            List<Integer> chromosome = population.get(i);
            //m += ??;
            int value = fitness(chromosome, items, maxWeight);
            m += 32;
            int weight = getWeight(chromosome, items);
            m += 32;
            a += 3;
            System.out.println("Chromosome " + (i + 1) + ": " + chromosome + " - Value: " + value + " - Weight: " + weight);
        }

        // Best chromosome
        List<Integer> bestChromosome = population.get(0);
        //m += ??;
        int bestValue = fitness(bestChromosome, items, maxWeight);
        m += 32;
        a += 2;

        // Print the best solution
        System.out.println("\nBest chromosome: " + bestChromosome);
        System.out.println("Selected objects:");
        int totalWeight = 0;
        m += 32;
        int totalValue = 0;
        m += 32;
        a += 2;
        for (int i = 0; i < bestChromosome.size(); i++) {
            c++;
            if (bestChromosome.get(i) == 1) {
                Object item = items.get(i);
                //m += ??;
                System.out.println(item.getName() + " - Value: " + item.getValue() + " - Weight: " + item.getWeight());
                totalWeight += item.getWeight();
                totalValue += item.getValue();
                a += 3;
            }
            c++;
        }
        System.out.println("Total weight: " + totalWeight);
        System.out.println("Total value: " + totalValue);
    }

    /**
     * Run the genetic algorithm
     * @param elements
     * @param maxWeight
     */
    public static void run(List<Object> elements, int maxWeight) {
        List<List<Integer>> initialPopulation = initialPopulation(elements, maxWeight);
        //m += ??;

        System.out.println("Initial population: ");
        for (List<Integer> chromosome : initialPopulation) {
            System.out.println(chromosome + " - Value: " + fitness(chromosome, elements, maxWeight) + " - Weight: " + getWeight(chromosome, elements));
        }

        runGenerations(initialPopulation, elements, maxWeight, 10);

        System.out.println("\nMediciones: ---------------------------------");
        System.out.println("Asignaciones: " + a);
        System.out.println("Comparaciones: " + c);
        System.out.println("Tiempo: ");
        System.out.println("Memoria: " + m + " bits");
    }
}
