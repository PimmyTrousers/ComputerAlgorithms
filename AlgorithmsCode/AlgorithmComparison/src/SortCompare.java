/**
 * Created by Pim on 10/16/16.
 */
public class SortCompare {
    public static double time(String alg, Comparable[] a){
    Stopwatch timer = new Stopwatch();
    if (alg.equals("Insertion")) Insertion.sort(a);
    if (alg.equals("Selection")) Selection.sort(a);
    if (alg.equals("Shell"))     Shell.sort(a);
    return timer.elapsedTime();
    }
    public static double timeRandomInput(String alg, int N, int T){
        double total = 0.0;
        Double[] a = new Double[N];
        for(int t = 0; t < T; t++){
            for(int i = 0; i < N; i++){
                a[i] = StdRandom.uniform();
            }
            total += time(alg,a);
        }
        return total;
    }
    public static void main(String[] args){
        StdIn.readAll();
        String alg1 = args[0];
        String alg2 = args[1];
        int N = Integer.parseInt(args[2]);
        int T = Integer.parseInt(args[3]);
        double t1 = timeRandomInput(alg1, N, T);
        double t2 = timeRandomInput(alg2, N, T);
        StdOut.printf("for %d random Doubles\n %s is", N, alg1);
        StdOut.printf("%.lf times faster than %s\n", t2/t1, alg2);
    }
}
