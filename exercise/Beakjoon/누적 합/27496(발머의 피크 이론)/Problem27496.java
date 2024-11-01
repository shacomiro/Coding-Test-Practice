import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Solution27496 {
    private int endTime;
    private int limit;
    private int[] alchohol;

    public Solution27496(int endTime, int limit, int[] alchohol) {
        this.endTime = endTime;
        this.limit = limit;
        this.alchohol = alchohol;
    }

    public String solve() {
        int currTime = 0;
        int currAlchohol = 0;
        int pass = 0;

        while(currTime < endTime) {
            currAlchohol += alchohol[currTime] - ((0 <= currTime - limit) ? alchohol[currTime - limit] : 0);

            if(129 <= currAlchohol && currAlchohol <= 138) {
                pass++;
            }

            currTime++;
        }

        return String.valueOf(pass);
    }
}

public class Problem27496 {
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

        bw.write(new Solution27496(n, l, arr).solve());
        bw.flush();
        bw.close();
    }
}
