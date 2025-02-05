import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

class Solution33257 {
    private int n;
    private int e;
    private int[] materials;

    public Solution33257(int n, int e, int[] materials) {
        this.n = n;
        this.e = e;
        this.materials = materials;
    }

    public String solve() {
        Arrays.sort(materials);

        int kinds = 1;
        for(int i = 0; i < n - 1; i++) {
            if(Math.abs(materials[i] - materials[i + 1]) >= e) {
                kinds++;
            }
        }

        return String.valueOf(kinds);
    }
}

public class Problem33257 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        bw.write(new Solution33257(n, e, arr).solve());
        bw.flush();
        bw.close();
    }
}
