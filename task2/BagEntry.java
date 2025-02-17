// One entry with weight and value
public class BagEntry {
    private int id;
    private int weight;
    private double value;

    BagEntry(int weight, int value, int id) {
        this.weight = weight;
        this.value = value;
        this.id = id;
    }

    BagEntry(int weight, double value, int id) {
        this.weight = weight;
        this.value = value;
        this.id = id;
    }

    public int getWeight() {
        return this.weight;
    }

    public double getValue() {
        return this.value;
    }

    public void setWeight(int newWeight) {
        if (newWeight < 0) {
            throw new IllegalArgumentException("New weight of bag entry can not be below 0");
        }
        this.weight = newWeight;
    }

    public void setValue(int newValue) {
        if (newValue < 0) {
            throw new IllegalArgumentException("New value of bag entry can not be below 0");
        }
        this.value = newValue;
    }

    public double getValueByWeight() {
        return this.value / this.weight;
    }

    public int getId() {
        return this.id;
    }

    public String toString() {
        return this.id + " : " + this.weight + " : " + this.value;
    }
}
