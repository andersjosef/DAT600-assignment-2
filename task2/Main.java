public class Main {
    public static void main(String[] args) {


        KnapSackProblem ksProblem = new KnapSackProblem(10, 5, 100, 1, 100);
        System.out.println(ksProblem.toString());
        KnapSackSolver.BinaryKnapSack();
        KnapSackSolver.FractionalKnapSack();
    }
}
