import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem30642 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        int k = Integer.parseInt(br.readLine());

        bw.write(new Solver(n, s, k).solve());
        bw.flush();
        bw.close();
    }

    static class Solver {
        private int n;
        private String mascot;
        private int k;

        public Solver(int n, String mascot, int k) {
            this.n = n;
            this.mascot = mascot;
            this.k = k;
        }

        public String solve() {
            int nearestFloor = -1;

            switch (mascot) {
                case "annyong":
                    if (k % 2 == 1) {
                        nearestFloor = k;
                    } else {
                        nearestFloor = (k + 1 <= n) ? k + 1 : k - 1;
                    }
                    break;
                case "induck":
                    if (k % 2 == 0) {
                        nearestFloor = k;
                    } else {
                        nearestFloor = (k + 1 <= n) ? k + 1 : k - 1;
                    }
                    break;
            }

            return String.valueOf(nearestFloor);
        }
    }
}