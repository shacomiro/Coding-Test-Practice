import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Solution27111 {
    private int n;
    private int[][] accessLogs;
    private boolean[] status;
    private int curr;

    public Solution27111(int n, int[][] accessLogs) {
        this.n = n;
        this.accessLogs = accessLogs;
        this.status = new boolean[200001];
        this.curr = 0;
    }

    public String solve() {
        int missed = 0;

        for(int[] log : accessLogs) {
            int id = log[0];
            int move = log[1];

            if(move == 1) {
                if(status[id]) {
                    missed++;
                } else {
                    curr++;
                    status[id] = true;
                }
            } else {
                if(!status[id]) {
                    missed++;
                } else {
                    curr--;
                    status[id] = false;
                }
            }
        }

        return String.valueOf(missed + curr);
    }
}

public class Problem27111 {
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

        bw.write(new Solution27111(n, arr).solve());
        bw.flush();
        bw.close();
    }
}
