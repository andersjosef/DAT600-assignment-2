import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class KnapSackSolver {
    // Binary Knapsack, needs dynamic
    public static LootBag BinaryKnapSack(int bagSize, KnapSackProblem ksProblem) {
        ArrayList<BagEntry> items = ksProblem.getItems();
        int n = items.size();
        
        // Create DP table
        LootBag[][] cache = new LootBag[n + 1][bagSize + 1];
        
        // Initialize DP table with empty LootBags
        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= bagSize; w++) {
                cache[i][w] = new LootBag(bagSize);
            }
        }

        // Dynamic Programming Bottom-Up Approach
        for (int i = 1; i <= n; i++) {
            BagEntry currentItem = items.get(i - 1);
            int itemWeight = currentItem.getWeight();

            for (int w = 0; w <= bagSize; w++) {
                // Option 1: Do not take the item
                LootBag withoutItem = cache[i - 1][w];

                // Option 2: Take the item (if it fits)
                LootBag withItem = new LootBag(bagSize);
                if (itemWeight <= w) {
                    withItem.addItems(cache[i - 1][w - itemWeight].getItems());
                    withItem.addToLoot(currentItem);
                }

                // Store the better option
                cache[i][w] = (withItem.getTotalValue() > withoutItem.getTotalValue()) ? withItem : withoutItem;
            }
        }

        // Return the optimal loot bag
        return cache[n][bagSize];
    }

    // Factional Knapsack, can be done greedy
    public static LootBag FractionalKnapSack(int bagSize, KnapSackProblem ksProblem) {
        // Bag to be filled with loot
        LootBag lootBag = new LootBag(bagSize); 
        
        // Sort entries from knapsackProblem by value to weight ratio
        ArrayList<BagEntry> sortedEntries = ksProblem.getItems();
        Collections.sort(sortedEntries, Comparator.comparingDouble(BagEntry::getValueByWeight));

        // While bag of loot is not full and there are still available items to take
        while (!lootBag.isFull() && sortedEntries.size() != 0) {
            // Pop last entry which is the one with highest value to weight ratio
            BagEntry currentMostValueable = sortedEntries.remove(sortedEntries.size()-1);

            if (lootBag.willMakeExceed(currentMostValueable)) { // Best loot is too big to fit, take fraction
                int remainingSpace = lootBag.getRemainingSpace();
                BagEntry fractionalEntry = new BagEntry(remainingSpace, remainingSpace * currentMostValueable.getValueByWeight(), currentMostValueable.getId());
                lootBag.addToLoot(fractionalEntry);
            } else { // Best loot fits, take whole
                lootBag.addToLoot(currentMostValueable);
            }

        }
    
        return lootBag;
    }
}
