import java.util.ArrayList;
import java.util.Random;;

class KnapSackProblem {
    private ArrayList<Integer> items = new ArrayList<Integer>();
    Random rand = new Random(42);


    KnapSackProblem(int numberOfItems, int minValue, int maxValue) {
        for (int i = 0; i<numberOfItems; i++) {
            items.add(rand.nextInt(minValue, maxValue));
        }
        
    }

    public String toString() {
        String toBeReturned = "item : value\n";
        for (int i = 0; i<items.size(); i++) {
           toBeReturned += i + " : " + items.get(i) + "\n";
        }

        return toBeReturned;
    }

}
