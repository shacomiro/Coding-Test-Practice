import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Solution30979 {
    private int time;
    private int[] candies;

    public Solution30979(int time, int[] candies) {
        this.time = time;
        this.candies = candies;
    }

    public String solve() {
        for(int candy : candies) {
            time -= candy;

            if(time <= 0) {
                break;
            }
        }

        if(time <= 0) {
            return "Padaeng_i Happy";
        } else {
            return "Padaeng_i Cry";
        }
    }
}

public class Problem30979 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        bw.write(new Solution30979(t, arr).solve());
        bw.flush();
        bw.close();
    }
}
