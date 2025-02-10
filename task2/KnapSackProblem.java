import java.util.ArrayList;
import java.lang.Math;

class KnapSackProblem {
    private ArrayList<Integer> items = new ArrayList<Integer>();


    KnapSackProblem(int numberOfItems, int minValue, int maxValue) {
        int deltaValue = maxValue - minValue;
        for (int i = 0; i<numberOfItems; i++) {
            items.add(minValue + (int) (Math.random() * deltaValue));
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
