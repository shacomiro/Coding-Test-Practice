import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Solution10409 {
    private int n;
    private int t;
    private int[] works;

    public Solution10409(int n, int t, int[] works) {
        this.n = n;
        this.t = t;
        this.works = works;
    }

    public String solve() {
        int cnt = 0;

        for(int work : works) {
            t -= work;

            if(t >= 0) {
                cnt++;
            } else {
                break;
            }
        }

        return String.valueOf(cnt);
    }
}

public class Problem10409 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        bw.write(new Solution10409(n, t, arr).solve());
        bw.flush();
        bw.close();
    }
}
