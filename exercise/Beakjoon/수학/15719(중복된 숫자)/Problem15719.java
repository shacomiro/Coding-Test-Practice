import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Solution15719 {
    private int n;
    private int[] sequence;

    public Solution15719(int n, int[] sequence) {
        this.n = n;
        this.sequence = sequence;
    }

    public String solve() {
        long sum = ((long) (n - 1) * n) / 2;
        for(int i = 0; i < n; i++) {
            sum -= sequence[i];
        }

        return String.valueOf(-sum);
    }
}

public class Problem15719 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        bw.write(new Solution15719(n, arr).solve());
        bw.flush();
        bw.close();
    }
}
