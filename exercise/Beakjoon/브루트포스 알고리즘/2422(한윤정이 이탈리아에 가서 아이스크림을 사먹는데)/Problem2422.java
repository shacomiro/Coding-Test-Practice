import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Solution2422 {
    private int n;
    private int m;
    private boolean[][] banCheck;

    public Solution2422(int n, int m, int[][] banned) {
        this.n = n;
        this.m = m;
        this.banCheck = new boolean[201][201];

        for(int[] b : banned) {
            banCheck[b[0]][b[1]] = true;
        }
    }

    public String solve() {
        int cnt = 0;

        for(int i = 1; i <= n; i++) {
            for(int j = i + 1; j <= n; j++) {
                if(banCheck[i][j] || banCheck[j][i]) {
                    continue;
                }

                for(int k = j + 1; k <= n; k++) {
                    if(banCheck[i][k] || banCheck[k][i] || banCheck[j][k] || banCheck[k][j]) {
                        continue;
                    }

                    cnt++;
                }
            }
        }


        return String.valueOf(cnt);
    }
}

public class Problem2422 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[m][2];
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        bw.write(new Solution2422(n, m, arr).solve());
        bw.flush();
        bw.close();
    }
}
