import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

class Solution6230 {
    private int n;
    private int m;
    private int[] hqhs;
    private int[] lqhs;

    public Solution6230(int n, int m, int[] hqhs, int[] lqhs) {
        this.n = n;
        this.m = m;
        this.hqhs = hqhs;
        this.lqhs = lqhs;
    }

    public String solve() {
        Arrays.sort(hqhs);
        Arrays.sort(lqhs);
        
        int hPt = n - 1;
        int lPt = m - 1;
        int cnt = 0;

        while(hPt >= 0) {
            while(lPt >= 0 && hqhs[hPt] <= lqhs[lPt]) {
                lPt--;
            }

            if(lPt >= 0) {
                cnt++;
                lPt--;
            }
            cnt++;
            hPt--;
        }

        return String.valueOf(cnt);
    }
}

public class Problem6230 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr1 = new int[n];
        for(int i = 0; i < n; i++) {
            arr1[i] = Integer.parseInt(br.readLine());
        }
        int[] arr2 = new int[m];
        for(int i = 0; i < m; i++) {
            arr2[i] = Integer.parseInt(br.readLine());
        }

        bw.write(new Solution6230(n, m, arr1, arr2).solve());
        bw.flush();
        bw.close();
    }
}
