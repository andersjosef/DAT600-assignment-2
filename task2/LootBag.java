import java.util.ArrayList;



public class LootBag {
    private int maxCapacity;
    private int totalWeight;
    private int totalValue;
    private ArrayList<BagEntry> lootedItems = new ArrayList<BagEntry>();

    LootBag(int maxCapacity) {
        this.totalWeight = 0;
        this.totalValue = 0;
        this.maxCapacity = maxCapacity;
    }
    
    public void addToLoot(BagEntry bagEntry) {
        // Total values
        this.totalWeight += bagEntry.getWeight();
        this.totalValue += bagEntry.getValue();

        lootedItems.add(bagEntry);
    }

    public int getTotalWeight() {
        return this.totalWeight;
    }

    public int getTotalValue() {
        return this.totalValue;
    }

    public boolean isFull() {
        return this.totalWeight >= this.maxCapacity;
    }

    public boolean willMakeExceed(BagEntry entry) {
        return (this.totalWeight + entry.getWeight() > this.maxCapacity);
    }
    
    public int getRemainingSpace() {
        return this.maxCapacity - this.totalWeight;
    }

    public String toString() {
       String strToBeRet = "---Loot bag---\n\n";
       strToBeRet += "Total weight: " + this.totalWeight + "\n";
       strToBeRet += "Total Value: " + this.totalValue + "\n";
       strToBeRet += "\nLoot Content:\n";
       for (BagEntry bagEntry : this.lootedItems) {
         strToBeRet += bagEntry.toString() + "\n";
       }
       strToBeRet += "-------------";
       return strToBeRet;
    }
}
