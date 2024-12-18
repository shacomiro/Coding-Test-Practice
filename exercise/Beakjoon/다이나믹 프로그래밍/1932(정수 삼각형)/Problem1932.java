import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Solution1932 {
    private int n;
    private List<List<Integer>> triangle;
    private List<List<Integer>> dp;

    public Solution1932(int n, List<List<Integer>> triangle) {
        this.n = n;
        this.triangle = triangle;
        this.dp = new ArrayList<>(n);

        for(int i = 0; i < n; i++) {
            dp.add(new ArrayList<>(i + 1));
        }
    }

    public String solve() {
        for(int depth = 0; depth < n; depth++) {
            dp.get(n - 1).add(triangle.get(n - 1).get(depth));
        }

        for(int depth = n - 1; depth > 0; depth--) {
            int nextDepth = depth - 1;

            for(int i = 0; i < dp.get(depth).size() - 1; i++) {
                int left = dp.get(depth).get(i);
                int right = dp.get(depth).get(i + 1);
                int mid = triangle.get(nextDepth).get(i);

                dp.get(nextDepth).add(i, mid + Math.max(left, right));
            }
        }

        return String.valueOf(dp.get(0).get(0));
    }
}

public class Problem1932 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        List<List<Integer>> list = new ArrayList<>(n);
        for(int i = 0; i < n; i++) {
            list.add(new ArrayList<>(i + 1));
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j <= i; j++) {
                list.get(i).add(Integer.parseInt(st.nextToken()));
            }
        }

        bw.write(new Solution1932(n, list).solve());
        bw.flush();
        bw.close();
    }
}
