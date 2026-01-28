import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Problem25285 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        int[] arr1 = new int[t];
        int[] arr2 = new int[t];
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            arr1[i] = Integer.parseInt(st.nextToken());
            arr2[i] = Integer.parseInt(st.nextToken());
        }

        bw.write(new Solver(t, arr1, arr2).solve());
        bw.flush();
        bw.close();
    }

    static class Solver {
        private int t;
        private int[] heights;
        private int[] weights;

        public Solver(int t, int[] heights, int[] weights) {
            this.t = t;
            this.heights = heights;
            this.weights = weights;
        }

        public String solve() {
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < t; i++) {
                if (heights[i] <= 140) {
                    sb.append(6);
                } else if (140 < heights[i] && heights[i] < 146) {
                    sb.append(5);
                } else if (146 <= heights[i] && heights[i] < 159) {
                    sb.append(4);
                } else if (159 <= heights[i] && heights[i] < 161) {
                    double bmi = weights[i] / Math.pow(heights[i] / 100.0, 2);
                    sb.append((16.0 <= bmi && bmi < 35.0) ? 3 : 4);
                } else if (161 <= heights[i] && heights[i] < 204) {
                    double bmi = weights[i] / Math.pow(heights[i] / 100.0, 2);
                    if (20.0 <= bmi && bmi < 25.0) {
                        sb.append(1);
                    } else if ((18.5 <= bmi && bmi < 20.0) || (25.0 <= bmi && bmi < 30.0)) {
                        sb.append(2);
                    } else if ((16.0 <= bmi && bmi < 18.5) || (30.0 <= bmi && bmi < 35.0)) {
                        sb.append(3);
                    } else {
                        sb.append(4);
                    }
                } else {
                    sb.append(4);
                }
                sb.append("\n");
            }

            return sb.toString();
        }
    }
}