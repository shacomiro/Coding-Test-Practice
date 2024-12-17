import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Solution9063 {
    private int[][] jadeBeads;

    public Solution9063(int[][] jadeBeads) {
        this.jadeBeads = jadeBeads;
    }

    public String solve() {
        int minX = 100000;
        int minY = 100000;
        int maxX = -100000;
        int maxY = -100000;

        for(int[] jadeBead : jadeBeads) {
            int x = jadeBead[0];
            int y = jadeBead[1];

            minX = Math.min(minX, x);
            maxX = Math.max(maxX, x);
            minY = Math.min(minY, y);
            maxY = Math.max(maxY, y);
        }

        return String.valueOf((maxX - minX) * (maxY - minY));
    }
}

public class Problem9063 {
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


        bw.write(new Solution9063(arr).solve());
        bw.flush();
        bw.close();
    }
}
