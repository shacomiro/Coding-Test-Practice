import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Solution18311 {
    private int n;
    private long k;
    private int[] courses;

    public Solution18311(int n, long k, int[] courses) {
        this.n = n;
        this.k = k;
        this.courses = courses;
    }

    public String solve() {
        long move = 0;

        for(int i = 0; i < n; i++) {
            move += courses[i];

            if(k < move) {
                return String.valueOf(i + 1);
            }
        }

        for(int i = n - 1; i >= 0; i--) {
            move += courses[i];

            if(k < move) {
                return String.valueOf(i + 1);
            }
        }

        return String.valueOf(1);
    }
}

public class Problem18311 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        long k = Long.parseLong(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        bw.write(new Solution18311(n, k, arr).solve());
        bw.flush();
        bw.close();
    }
}
