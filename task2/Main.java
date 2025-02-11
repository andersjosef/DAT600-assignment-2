public class Main {
    public static void main(String[] args) {

        final int bagSize = 7;


        // Create Knapsack problem
        KnapSackProblem ksProblem = new KnapSackProblem(5, 1, 10, 1, 10); // Generate problem
        System.out.println(ksProblem); 


        // Fractional
        LootBag fractionalLooot = KnapSackSolver.FractionalKnapSack(bagSize, ksProblem); // Fractional solution
        System.out.println(fractionalLooot);

        // Generate KnapsackProblem
        ksProblem = new KnapSackProblem(5, 1, 10, 1, 10); // Generate problem

        // Binary
        KnapSackSolver.BinaryKnapSack(bagSize, ksProblem);
    }
}
