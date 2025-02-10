import java.util.ArrayList;
import java.util.Random;;

class KnapSackProblem {
    private ArrayList<BagEntry> items = new ArrayList<BagEntry>();
    // Seed random for consistency
    Random rand = new Random(42); 

    KnapSackProblem(int numberOfItems, int minValue, int maxValue, int minWeight, int maxWeight) {
        for (int i = 0; i<numberOfItems; i++) {
            // Generate new bagentry with weigth and value
            BagEntry newBagEntry = new BagEntry(
                rand.nextInt(minWeight, maxWeight),
                rand.nextInt(minValue, maxValue)
            );
            items.add(newBagEntry);
        }
    }

    public ArrayList<BagEntry> getItems() {
        return this.items;
    }

    public String toString() {
        String toBeReturned = "i : weight : value\n";
        for (int i = 0; i<items.size(); i++) {
           toBeReturned += i + " : " + items.get(i) + "\n";
        }

        return toBeReturned;
    }
}

// One entry with weight and value
class BagEntry {
    private int weight;
    private int value;

    BagEntry(int weight, int value) {
        this.weight = weight;
        this.value = value;

    }

    public int getWeight() {
        return this.weight;
    }

    public int getValue() {
        return this.value;
    }

    public double getValueByWeight() {
        return this.value / this.weight;
    }

    public String toString() {
        return this.weight + " : " + this.value;
    }
}
