import java.util.ArrayList;



public class LootBag {
    private int maxCapacity;
    private double totalWeight;
    private double totalValue;
    private ArrayList<BagEntry> lootedItems = new ArrayList<BagEntry>();

    LootBag(int maxCapacity) {
        this.totalWeight = 0;
        this.totalValue = 0;
        this.maxCapacity = maxCapacity;
    }
    
    public void addToLoot(BagEntry bagEntry) {
        this.totalWeight += bagEntry.getWeight();
        this.totalValue += bagEntry.getValue();

        lootedItems.add(bagEntry);
    }

    public int getTotalWeight() {
        return (int)this.totalWeight;
    }

    public int getTotalValue() {
        return (int)this.totalValue;
    }

    public ArrayList<BagEntry> getItems() {
        return this.lootedItems;
    }

    public void setItems(ArrayList<BagEntry> lootedItems) {
        this.lootedItems =lootedItems;
    }

    public void addItems(ArrayList<BagEntry> lootedItems) {
        this.lootedItems.addAll(lootedItems);
        for (BagEntry bagEntry : lootedItems) {
            this.totalWeight += bagEntry.getWeight();
            this.totalValue += bagEntry.getValue();
        }
    }

    public boolean isFull() {
        return this.totalWeight >= this.maxCapacity;
    }

    public boolean willMakeExceed(BagEntry entry) {
        return (this.totalWeight + entry.getWeight() > this.maxCapacity);
    }
    
    public int getRemainingSpace() {
        return (int)(this.maxCapacity - this.totalWeight);
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
