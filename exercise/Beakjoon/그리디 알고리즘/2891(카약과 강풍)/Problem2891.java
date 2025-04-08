import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Solution2891 {
    private static int MAX_TEAM_NUMBER = 10;
    private int n;
    private int s;
    private int r;
    private boolean[] isBorken;
    private boolean[] hasSpare;

    public Solution2891(int n, int s, int r, int[] broken, int[] spare) {
        this.n = n;
        this.s = s;
        this.r = r;
        this.isBorken = new boolean[MAX_TEAM_NUMBER + 1];
        this.hasSpare = new boolean[MAX_TEAM_NUMBER + 1];

        init(broken, spare);
    }

    private void init(int[] broken, int[] spare) {
        for(int i = 0; i < s; i++) {
            isBorken[broken[i]] = true;
        }
        for(int i = 0; i < r; i++) {
            hasSpare[spare[i]] = true;
        }
    }

    public String solve() {
        int brokenCount = 0;
        for(int curr = 1; curr <= n; curr++) {
            int prev = curr - 1;
            int next = curr + 1;

            if(isBorken[curr]) {
                if(hasSpare[curr]) {
                    isBorken[curr] = false;
                    hasSpare[curr] = false;
                } else if(prev >= 1 && hasSpare[prev] && !isBorken[prev]) {
                    isBorken[curr] = false;
                    hasSpare[prev] = false;
                } else if(next <= n && hasSpare[next] && !isBorken[next]) {
                    isBorken[curr] = false;
                    hasSpare[next] = false;
                } else {
                    brokenCount++;
                }
            }
        }

        return String.valueOf(brokenCount);
    }
}

public class Problem2891 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr1 = new int[s];
        for(int i = 0; i < s; i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int[] arr2 = new int[r];
        for(int i = 0; i < r; i++) {
            arr2[i] = Integer.parseInt(st.nextToken());
        }

        bw.write(new Solution2891(n, s, r, arr1, arr2).solve());
        bw.flush();
        bw.close();
    }
}
