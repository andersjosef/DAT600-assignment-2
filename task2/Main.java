public class Main {
    public static void main(String[] args) {
        KnapSackProblem ksProblem = new KnapSackProblem(10, 5, 8);
        System.out.println(ksProblem.toString());
        KnapSackSolver.BinaryKnapSack();
        KnapSackSolver.FractionalKnapSack();
    }
}
