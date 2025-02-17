public class Main {
    public static void main(String[] args) {

        final int bagSize = 7;


        // Create Knapsack problem
        System.out.println("--- FRACTIONAL ---");
        KnapSackProblem ksProblem = new KnapSackProblem(5, 1, 10, 1, 10); // Generate problem
        System.out.println(ksProblem); 


        // Fractional
        LootBag fractionalLooot = KnapSackSolver.FractionalKnapSack(bagSize, ksProblem); // Fractional solution
        System.out.println(fractionalLooot);

        // Generate KnapsackProblem
        System.out.println("--- BINARY ---");
        ksProblem = new KnapSackProblem(5, 1, 10, 1, 10); // Generate problem
        System.out.println(ksProblem); 

        // Binary
        LootBag binaryLoot = KnapSackSolver.BinaryKnapSack(bagSize, ksProblem);
        System.out.println(binaryLoot);


    }
}
