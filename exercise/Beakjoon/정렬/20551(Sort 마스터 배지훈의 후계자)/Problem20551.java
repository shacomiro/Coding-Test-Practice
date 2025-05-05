import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

class Solution20551 {
    private int n;
    private int m;
    private int[] a;
    private int[] d;

    public Solution20551(int n, int m, int[] a, int[] d) {
        this.n = n;
        this.m = m;
        this.a = a;
        this.d = d;
    }

    public String solve() {
        Arrays.sort(a);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            sb.append(binarySearch(d[i])).append("\n");
        }

        return sb.toString();
    }

    private int binarySearch(int element) {
        int lt = 0;
        int rt = n - 1;
        int found = -1;

        while (lt <= rt) {
            int mid = (lt + rt) / 2;

            if (a[mid] == element) {
                found = mid;
                rt = mid - 1;
            } else if (a[mid] > element) {
                rt = mid - 1;
            } else {
                lt = mid + 1;
            }
        }

        return found;
    }
}

public class Problem20551 {
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

        bw.write(new Solution20551(n, m, arr1, arr2).solve());
        bw.flush();
        bw.close();
    }
}
