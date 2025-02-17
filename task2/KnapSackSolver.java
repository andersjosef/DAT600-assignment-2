import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class KnapSackSolver {
    // Binary Knapsack, needs dynamic
    public static LootBag BinaryKnapSack(int bagSize, KnapSackProblem ksProblem) {

        // Pluss 1 for completely empty bag and no items
        // Y = items X = bagsize
        LootBag cache[][] = new LootBag[ksProblem.getItems().size() + 1][bagSize + 1];
        Arrays.fill(cache[0], new LootBag(bagSize));

        for (int y = 0; y < cache.length; y++) {
            for (int x = 0; x <cache[0].length; x++) {

            }

        }

        // Return the absolute last value in cache
        return cache[cache.length - 1][cache[0].length - 1]; 
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
