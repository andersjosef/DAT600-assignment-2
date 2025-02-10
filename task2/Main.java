public class Main {
    public static void main(String[] args) {

        final int bagSize = 40;


        KnapSackProblem ksProblem = new KnapSackProblem(10, 1, 10, 1, 10);
        // KnapSackSolver.BinaryKnapSack(bagSize, ksProblem);
        LootBag fractionalLooot = KnapSackSolver.FractionalKnapSack(bagSize, ksProblem);
        System.out.println(fractionalLooot);
    }
}
