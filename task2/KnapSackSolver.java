import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class KnapSackSolver {
    
    // Binary Knapsack, needs dynamic
    public static void BinaryKnapSack(int bagSize, KnapSackProblem ksProblem) {
        System.out.println("Im the binary version");
        System.out.println("Bagsize: " + bagSize);
        System.out.println("Problem: \n" + ksProblem);
    }

    // Factional Knapsack, can be done greedy
    public static LootBag FractionalKnapSack(int bagSize, KnapSackProblem ksProblem) {
        // Bag to be filled with loot
        LootBag lootBag = new LootBag(bagSize); 
        
        // Sort entries from knapsackProblem by value to weight ratio
        ArrayList<BagEntry> sortedEntries = ksProblem.getItems();
        Collections.sort(sortedEntries, Comparator.comparingDouble(BagEntry::getValueByWeight));

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
