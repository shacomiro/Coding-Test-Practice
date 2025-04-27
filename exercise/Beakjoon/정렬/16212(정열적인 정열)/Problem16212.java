import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

class Solution16212 {
    private int n;
    private int[] sequance;

    public Solution16212(int n, int[] sequance) {
        this.n = n;
        this.sequance = sequance;
    }

    public String solve() {
        Arrays.sort(sequance);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(sequance[i]).append(" ");
        }

        return sb.toString();
    }
}

public class Problem16212 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        bw.write(new Solution16212(n, arr).solve());
        bw.flush();
        bw.close();
    }
}
