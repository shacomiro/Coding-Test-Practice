import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

class Solution22993 {
    private int n;
    private int[] a;

    public Solution22993(int n, int[] a) {
        this.n = n;
        this.a = a;
    }

    public String solve() {
        long ap = a[0];
        int count = 0;

        Arrays.sort(a, 1, n);

        for (int i = 1; i < n; i++) {
            if (a[i] >= ap) {
                break;
            }

            ap += a[i];
            count++;
        }

        return (count == n - 1) ? "Yes" : "No";
    }
}

public class Problem22993 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        bw.write(new Solution22993(n, arr).solve());
        bw.flush();
        bw.close();
    }
}
