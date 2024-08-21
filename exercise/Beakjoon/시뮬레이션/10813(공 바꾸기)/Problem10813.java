import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Solution10813 {
    private int[] baskets;
    private List<int[]> swaps;

    public Solution10813(int[] baskets, List<int[]> swaps) {
        this.baskets = baskets;
        this.swaps = swaps;
    }

    public String solve() {
        for(int[] swap : swaps) {
            int tmp = baskets[swap[0]];
            baskets[swap[0]] = baskets[swap[1]];
            baskets[swap[1]] = tmp;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i < baskets.length; i++) {
            sb.append(baskets[i]).append(" ");
        }

        return sb.toString();
    }
}

public class Problem10813 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n + 1];
        for(int i = 1; i <= n; i++) {
            arr[i] = i;
        }
        List<int[]> list = new ArrayList<>(m);
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            list.add(new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }

        bw.write(new Solution10813(arr, list).solve());
        bw.flush();
        bw.close();
    }
}
