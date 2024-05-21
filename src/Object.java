/**
 * Object class that represents an object with a name, weight, and value.
 * This class is used to create objects that will be stored in the knapsack.
 */
public class Object {
    int weight;
    int value;
    String name;

    /**
     * Constructor
     * @param name
     * @param weight
     * @param value
     */
    public Object(String name, int weight, int value) {
            this.name = name;
            this.weight = weight;
            this.value = value;
        }

    // Getters

    /**
     * Get the weight of the object
     * @return
     */
    public int getWeight() {
        return weight;
    }

    /**
     * Get the value of the object
     * @return
     */
    public int getValue() {
        return value;
    }

    /**
     * Get the name of the object
     * @return
     */
    public String getName() {
        return name;
    }



    // Setters

    /**
     * Set the weight of the object
     * @param weight
     */
    public void setWeight(int weight) {
        this.weight = weight;
    }

    /**
     * Set the value of the object
     * @param value
     */
    public void setValue(int value) {
        this.value = value;
    }

    /**
     * Set the name of the object
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }
}
