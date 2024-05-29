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
     * @param maxWeight
     * @return
     */
    private static List<List<Integer>> initialPopulation(List<Object> items, int maxWeight) {
        List<List<Integer>> population = new ArrayList<>();
        int n = items.size();
        Random random = new Random();
        int initialPopulationSize = 10; // Adjust the population size as needed

        while (population.size() < initialPopulationSize) {
            List<Integer> chromosome = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                chromosome.add(random.nextInt(2));
            }
            if (getWeight(chromosome, items) <= maxWeight) {
                population.add(chromosome);
            }
        }
        return population;
    }

    /**
     * Generate a new population of chromosomes
     * @param population
     * @param items
     * @param maxWeight
     * @return
     */
    private static List<List<Integer>> newPopulation(List<List<Integer>> population, List<Object> items, int maxWeight) {
        List<List<Integer>> newPopulation = new ArrayList<>();
        Random random = new Random();

        while (newPopulation.size() < population.size()) {
            List<Integer> parent1 = tournamentSelection(population, items, maxWeight);
            List<Integer> parent2 = tournamentSelection(population, items, maxWeight);

            int parent1Fitness = fitness(parent1, items, maxWeight);
            int parent2Fitness = fitness(parent2, items, maxWeight);

            List<Integer> child1 = crossover(parent1, parent2);
            List<Integer> child2 = crossover(parent2, parent1);

            if (random.nextInt(100) < 10) {
                child1 = mutation(child1);
            }
            if (random.nextInt(100) < 10) {
                child2 = mutation(child2);
            }

            if (getWeight(child1, items) <= maxWeight) {
                newPopulation.add(child1);
            }
            if (getWeight(child2, items) <= maxWeight) {
                newPopulation.add(child2);
            }

            int child1Fitness = fitness(child1, items, maxWeight);
            int child2Fitness = fitness(child2, items, maxWeight);

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
        List<Integer> bestChromosome = null;
        int bestFitness = -1;

        for (int i = 0; i < 3; i++) {
            List<Integer> chromosome = population.get(random.nextInt(population.size()));
            int fitness = fitness(chromosome, items, maxWeight);
            if (fitness > bestFitness) {
                bestFitness = fitness;
                bestChromosome = chromosome;
            }
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
        int weight = 0;
        for (int i = 0; i < chromosome.size(); i++) {
            if (chromosome.get(i) == 1) {
                value += items.get(i).getValue();
                weight += items.get(i).getWeight();
            }
        }
        if (weight > maxWeight) {
            return 0;
        }
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
        Random random = new Random();
        int crossoverPoint = random.nextInt(parent1.size());
        for (int i = 0; i <= crossoverPoint; i++) {
            child.add(parent1.get(i));
        }
        for (int i = crossoverPoint + 1; i < parent2.size(); i++) {
            child.add(parent2.get(i));
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
        int mutationPoint = random.nextInt(chromosome.size());
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
        for (int i = 0; i < chromosome.size(); i++) {
            if (chromosome.get(i) == 1) {
                weight += items.get(i).getWeight();
            }
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
        for (int i = 0; i < generations; i++) {
            System.out.println("\nGeneration " + i + " is done!");
            population = newPopulation(population, items, maxWeight);
        }

        System.out.println("Last generation: ");
        for (List<Integer> chromosome : population) {
            System.out.println(chromosome + " - Value: " + fitness(chromosome, items, maxWeight) + " - Weight: " + getWeight(chromosome, items));
        }

        // Best 5 chromosomes
        List<List<Integer>> bestChromosomes = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            int bestValue = 0;
            int bestIndex = 0;
            for (int j = 0; j < population.size(); j++) {
                int value = fitness(population.get(j), items, maxWeight);
                if (value > bestValue) {
                    bestValue = value;
                    bestIndex = j;
                }
            }
            bestChromosomes.add(population.get(bestIndex));
            population.remove(bestIndex);
        }

        System.out.println("\nBest 5 chromosomes: ");
        for (List<Integer> chromosome : bestChromosomes) {
            System.out.println(chromosome + " - Value: " + fitness(chromosome, items, maxWeight) + " - Weight: " + getWeight(chromosome, items));
        }
    }

    /**
     * Run the genetic algorithm
     * @param elements
     * @param maxWeight
     */
    public static void run(List<Object> elements, int maxWeight) {
        List<List<Integer>> initialPopulation = initialPopulation(elements, maxWeight);

        System.out.println("Initial population: ");
        for (List<Integer> chromosome : initialPopulation) {
            System.out.println(chromosome + " - Value: " + fitness(chromosome, elements, maxWeight) + " - Weight: " + getWeight(chromosome, elements));
        }

        runGenerations(initialPopulation, elements, maxWeight, 10);
    }
}