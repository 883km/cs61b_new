package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeSLList {
    private static void printTimingTable(AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < Ns.size(); i += 1) {
            int N = Ns.get(i);
            double time = times.get(i);
            int opCount = opCounts.get(i);
            double timePerOp = time / opCount * 1e6;
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
    }

    public static void main(String[] args) {
        timeGetLast();
    }

    public static void timeGetLast() {
        int[] nList = new int[]{1000, 2000, 4000, 8000, 16000, 32000, 64000, 128000};
        AList<Integer> Ns = new AList<>();
        AList<Double> times = new AList<>();
        double time; //to be updated.

        for (int i : nList){
            Ns.addLast(i);
            time = SpeedTestSLList(i); //to be updated.
            times.addLast(time); //to be updated.
        }
        AList<Integer> opCounts = Ns;
        printTimingTable(Ns, times, opCounts);
    }

    private static double SpeedTestSLList(int n) {
        SLList<Integer> L = new SLList<>();
        addToSLList(n, L);
        Stopwatch sw = new Stopwatch();
        for (int i = 0; i < 10000; i++) {
            L.getLast();
        }
        return sw.elapsedTime();
    }

    /** Add n items to a SLList. */
    private static void addToSLList(int n, SLList L) {
        for (int i = 0; i < n; i++) {
            L.addLast(i);
        }
    }
}
