import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Solution1384 {
    private int group;
    private int n;
    private String[] names;
    private boolean[][] isPositiveMsg;

    public Solution1384(int group, int n, String[] names, boolean[][] isPositiveMsg) {
        this.group = group;
        this.n = n;
        this.names = names;
        this.isPositiveMsg = isPositiveMsg;
    }

    public String solve() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (!isPositiveMsg[i][j]) {
                    sb.append(names[(i + ((n - 1) - j)) % n]).append(" was nasty about ").append(names[i]).append("\n");
                }
            }
        }

        return "Group " + group + "\n" + (sb.length() == 0 ? "Nobody was nasty\n" : sb.toString());
    }
}

public class Problem1384 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        String input;
        int group = 0;

        while (!(input = br.readLine()).equals("0")) {
            group++;
            int n = Integer.parseInt(input);
            String[] arr1 = new String[n];
            boolean[][] arr2 = new boolean[n][n - 1];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                arr1[i] = st.nextToken();
                for (int j = 0; j < n - 1; j++) {
                    arr2[i][j] = (st.nextToken().equals("P")) ? true : false;
                }
            }
            bw.write(new Solution1384(group, n, arr1, arr2).solve());
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}
