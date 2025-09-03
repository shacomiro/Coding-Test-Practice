import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem2576 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] arr = new int[7];
        for (int i = 0; i < 7; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        bw.write(new Solver(arr).solve());
        bw.flush();
        bw.close();
    }

    static class Solver {
        private int[] numbers;

        public Solver(int[] numbers) {
            this.numbers = numbers;
        }

        public String solve() {
            boolean isExistOdd = false;
            int sum = 0;
            int min = Integer.MAX_VALUE;

            for (int n : numbers) {
                if (n % 2 == 1) {
                    isExistOdd = true;
                    sum += n;
                    min = Math.min(min, n);
                }
            }

            return isExistOdd ? sum + "\n" + min : "-1";
        }
    }
}
