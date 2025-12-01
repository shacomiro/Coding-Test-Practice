import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem10984 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            int[] arr1 = new int[n];
            double[] arr2 = new double[n];
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                arr1[j] = Integer.parseInt(st.nextToken());
                arr2[j] = Double.parseDouble(st.nextToken());
            }
            bw.write(new Solver(n, arr1, arr2).solve());
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }

    static class Solver {
        private int n;
        private int[] credits;
        private double[] grades;

        public Solver(int n, int[] credits, double[] grades) {
            this.n = n;
            this.credits = credits;
            this.grades = grades;
        }

        public String solve() {
            int totalCredit = Arrays.stream(credits).sum();
            double gpa = 0;

            for (int i = 0; i < n; i++) {
                gpa += credits[i] * grades[i];
            }
            gpa /= totalCredit;

            return totalCredit + " " + String.format("%.1f", gpa);
        }
    }
}
