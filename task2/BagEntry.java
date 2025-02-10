// One entry with weight and value
public class BagEntry {
    private int weight;
    private double value;

    BagEntry(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }

    BagEntry(int weight, double value) {
        this.weight = weight;
        this.value = value;
    }

    public int getWeight() {
        return this.weight;
    }

    public double getValue() {
        return this.value;
    }

    public double getValueByWeight() {
        return this.value / this.weight;
    }

    public String toString() {
        return this.weight + " : " + this.value;
    }
}