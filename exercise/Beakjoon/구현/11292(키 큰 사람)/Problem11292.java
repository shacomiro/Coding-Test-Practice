import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Solution11292 {
    private int n;
    private String[] names;
    private double[] talls;

    public Solution11292(int n, String[] names, double[] talls) {
        this.n = n;
        this.names = names;
        this.talls = talls;
    }

    public String solve() {
        double max = 0;

        for (int i = 0; i < n; i++) {
            max = Math.max(max, talls[i]);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (talls[i] == max) {
                sb.append(names[i]).append(" ");
            }
        }

        return sb.toString();
    }
}

public class Problem11292 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n;

        while ((n = Integer.parseInt(br.readLine())) != 0) {
            String[] arr1 = new String[n];
            double[] arr2 = new double[n];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                arr1[i] = st.nextToken();
                arr2[i] = Double.parseDouble(st.nextToken());
            }
            bw.write(new Solution11292(n, arr1, arr2).solve());
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}
