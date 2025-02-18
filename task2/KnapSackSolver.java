import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class KnapSackSolver {
    // Binary Knapsack, needs dynamic
    public static LootBag BinaryKnapSack(int bagSize, KnapSackProblem ksProblem) {

        // Pluss 1 for completely empty bag and no items
        // Y = items X = bagsize
        ArrayList<BagEntry> items = ksProblem.getItems();
        LootBag[][] cache = new LootBag[items.size() + 1][bagSize + 1];
        Arrays.fill(cache[0], new LootBag(bagSize));

        // Starts on the first item
        for (int y = 1; y < cache.length; y++) {
            for (int x = 0; x <cache[0].length; x++) {
                // Option one previous above pluss current item
                int prevY = y-1;
                int weightOfLastItem = y-1 >=0 ? items.get(prevY).getWeight() : 0;
                int option1 = (int)items.get(y-1).getValue();
                boolean isOOB = isOutOfRangeX(x-weightOfLastItem, y, cache);
                option1 += isOOB ?  0: cache[y-1][x-weightOfLastItem].getTotalValue();

                int option2 = cache[prevY][x].getTotalValue();

                LootBag thisLootBag = new LootBag(bagSize);
                if (option1 > option2) {
                    if (!isOOB) {
                    thisLootBag.addItems(cache[y-1][x-weightOfLastItem].getItems());
                    }
                    thisLootBag.addToLoot(items.get(y));
                } else {
                    thisLootBag.addItems(items);
                }
                cache[y][x] = thisLootBag;
            }

        }

        // Return the absolute last value in cache
        return cache[cache.length - 1][cache[0].length - 1]; 
    }

    private static boolean isOutOfRangeX(int x, int y, LootBag[][] cache) {
        if (x < 0 || x >= cache[0].length) {
            return true;
        }
        return false;
    }

    private static boolean isOutOfRangeY(int x, int y, LootBag[][] cache) {
        if (y < 0 || y >= cache.length) {
            return true;
        }
        return false;
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
