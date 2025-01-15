import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Solution25377 {
    private int n;
    private int[][] infos;

    public Solution25377(int n, int[][] infos) {
        this.n = n;
        this.infos = infos;
    }

    public String solve() {
        int min = 1001;

        for(int i = 0; i < n; i++) {
            if(infos[i][0] > infos[i][1]) {
                continue;
            }

            min = Math.min(infos[i][1], min);
        }

        return String.valueOf((min != 1001) ? min : -1);
    }
}

public class Problem25377 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        bw.write(new Solution25377(n, arr).solve());
        bw.flush();
        bw.close();
    }
}
