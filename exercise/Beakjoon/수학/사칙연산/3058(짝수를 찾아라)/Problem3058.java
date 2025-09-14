import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Problem3058 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int[] arr = new int[7];
            for (int j = 0; j < 7; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            bw.write(new Solver(arr).solve());
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }

    static class Solver {
        private int[] numbers;

        public Solver(int[] numbers) {
            this.numbers = numbers;
        }

        public String solve() {
            int sum = 0;
            int min = Integer.MAX_VALUE;

            for (int num : numbers) {
                if (num % 2 == 0) {
                    sum += num;
                    min = Math.min(num, min);
                }
            }

            return sum + " " + min;
        }
    }
}
