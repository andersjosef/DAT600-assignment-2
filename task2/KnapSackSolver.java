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
        System.out.println(ksProblem.getItems());
        LootBag lootBag = new LootBag(bagSize); // Bag to be filled with loot
        
        // Sort entries from ksProblem by value to weight ratio
        ArrayList<BagEntry> sortedEntries = ksProblem.getItems();
        Collections.sort(sortedEntries, Comparator.comparingDouble(BagEntry::getValueByWeight));
        System.out.println(sortedEntries);

        while (!lootBag.isFull()) {
            BagEntry currentMostValueable = sortedEntries.remove(sortedEntries.size()-1);
            if (lootBag.willMakeExceed(currentMostValueable)) { // Best loot is too big to fit, fraction
                int remainingSpace = lootBag.getRemainingSpace();
                BagEntry fractionalEntry = new BagEntry(remainingSpace, remainingSpace * currentMostValueable.getValueByWeight());
                lootBag.addToLoot(fractionalEntry);
            } else {
                lootBag.addToLoot(currentMostValueable);
            }

        }
    
        return lootBag;
    }
}
