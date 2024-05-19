public class Object {
    int weight;
    int value;
    String name;

public Object(String name, int weight, int value) {
        this.name = name;
        this.weight = weight;
        this.value = value;
    }

    // Getters
    public int getWeight() {
        return weight;
    }

    public int getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    // Setters

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setName(String name) {
        this.name = name;
    }
}
