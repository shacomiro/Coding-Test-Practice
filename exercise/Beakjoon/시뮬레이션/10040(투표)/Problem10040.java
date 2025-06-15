import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Solution10040 {
    private int n;
    private int m;
    private int[] a;
    private int[] b;

    public Solution10040(int n, int m, int[] a, int[] b) {
        this.n = n;
        this.m = m;
        this.a = a;
        this.b = b;
    }

    public String solve() {
        int[] votes = new int[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (a[j] <= b[i]) {
                    votes[j]++;

                    break;
                }
            }
        }

        int max = -1;
        int id = -1;
        for (int i = 0; i < n; i++) {
            if (votes[i] > max) {
                max = votes[i];
                id = i + 1;
            }
        }

        return String.valueOf(id);
    }
}

public class Problem10040 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr1 = new int[n];
        for (int i = 0; i < n; i++) {
            arr1[i] = Integer.parseInt(br.readLine());
        }
        int[] arr2 = new int[m];
        for (int i = 0; i < m; i++) {
            arr2[i] = Integer.parseInt(br.readLine());
        }

        bw.write(new Solution10040(n, m, arr1, arr2).solve());
        bw.flush();
        bw.close();
    }
}
