public class Main {
    public static void main(String[] args) {

        final int bagSize = 7;


        KnapSackProblem ksProblem = new KnapSackProblem(5, 1, 10, 1, 10); // Generate problem
        System.out.println(ksProblem); // Print problem
        // KnapSackSolver.BinaryKnapSack(bagSize, ksProblem);

        LootBag fractionalLooot = KnapSackSolver.FractionalKnapSack(bagSize, ksProblem); // Fractional solution
        System.out.println(fractionalLooot);
    }
}
