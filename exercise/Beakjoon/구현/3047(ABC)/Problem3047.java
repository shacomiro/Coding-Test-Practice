import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem3047 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[] { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
                Integer.parseInt(st.nextToken()) };
        String str = br.readLine();

        bw.write(new Solver(arr, str).solve());
        bw.flush();
        bw.close();
    }

    static class Solver {
        private int[] arr;
        private String order;

        public Solver(int[] arr, String order) {
            this.arr = arr;
            this.order = order;
        }

        public String solve() {
            Arrays.sort(arr);

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < order.length(); i++) {
                switch (order.charAt(i)) {
                    case 'A':
                        sb.append(arr[0]).append(" ");
                        break;
                    case 'B':
                        sb.append(arr[1]).append(" ");
                        break;
                    case 'C':
                        sb.append(arr[2]).append(" ");
                        break;
                }
            }

            return sb.toString();
        }
    }
}
