import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

class Solution16435 {
    private int n;
    private int l;
    private int[] fruits;

    public Solution16435(int n, int l, int[] fruits) {
        this.n = n;
        this.l = l;
        this.fruits = fruits;
    }

    public String solve() {
        Arrays.sort(fruits);

        for(int i = 0; i < n; i++) {
            if(fruits[i] <= l) {
                l++;
            } else {
                break;
            }
        }

        return String.valueOf(l);
    }
}

public class Problem16435 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        bw.write(new Solution16435(n, l, arr).solve());
        bw.flush();
        bw.close();
    }
}
