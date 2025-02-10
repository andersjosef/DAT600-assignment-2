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
                rand.nextInt(minValue, maxValue),
                i + 1
            );
            items.add(newBagEntry);
        }
    }

    public ArrayList<BagEntry> getItems() {
        return this.items;
    }

    public String toString() {
        String toBeReturned = "id : weight : value\n";
        for (int i = 0; i<items.size(); i++) {
           toBeReturned += items.get(i) + "\n";
        }

        return toBeReturned;
    }
}
