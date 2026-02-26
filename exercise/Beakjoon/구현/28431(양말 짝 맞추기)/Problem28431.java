import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem28431 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] arr = new int[5];
        for (int i = 0; i < 5; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        bw.write(new Solver(arr).solve());
        bw.flush();
        bw.close();
    }

    static class Solver {
        private boolean[] socks;
        private int[] numbers;

        public Solver(int[] numbers) {
            this.socks = new boolean[10];
            this.numbers = numbers;
        }

        public String solve() {
            for (int i = 0; i < 5; i++) {
                socks[numbers[i]] = (socks[numbers[i]]) ? false : true;
            }

            int left = -1;
            for (int i = 0; i < 10; i++) {
                if(socks[i]) {
                    left = i;
                    break;
                }
            }

            return String.valueOf(left);
        }
    }
}
