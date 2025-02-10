public class KnapSackSolver {
    
    // Binary Knapsack, needs dynamic
    public static void BinaryKnapSack(int bagSize, KnapSackProblem ksProblem) {
        System.out.println("Im the binary version");
        System.out.println("Bagsize: " + bagSize);
        System.out.println("Problem: \n" + ksProblem);
    }

    // Factional Knapsack, can be done greedy
    public static void FractionalKnapSack(int bagSize, KnapSackProblem ksProblem) {
        System.out.println(ksProblem.getItems());
    }
}

