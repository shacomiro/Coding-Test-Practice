import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

class Solution32752 {
    private int n;
    private int l;
    private int r;
    private int[] sequence;

    public Solution32752(int n, int l, int r, int[] sequence) {
        this.n = n;
        this.l = l;
        this.r = r;
        this.sequence = sequence;
    }

    public String solve() {
        int[] subSequence = Arrays.copyOfRange(sequence, l - 1, r);
        Arrays.sort(subSequence);

        return ((l - 2 < 0 || sequence[l - 2] <= subSequence[0])
                && (r == n || subSequence[subSequence.length - 1] <= sequence[r])) ? "1" : "0";
    }
}

public class Problem32752 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        bw.write(new Solution32752(n, l, r, arr).solve());
        bw.flush();
        bw.close();
    }
}
