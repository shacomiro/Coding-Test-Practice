import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Solution2525 {
    private int[] time;
    private int cookingTime;

    public Solution2525(int[] time, int cookingTime) {
        this.time = time;
        this.cookingTime = cookingTime;
    }

    public String solve() {
        time[1] += cookingTime;
        time[0] += time[1] / 60;
        time[1] = time[1] % 60;
        time[0] = time[0] % 24;

        return String.valueOf(time[0] + " " + time[1]);
    }
}

public class Problem2525 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[2];
        arr[0] = Integer.parseInt(st.nextToken());
        arr[1] = Integer.parseInt(st.nextToken());
        int cTime = Integer.parseInt(br.readLine());

        bw.write(new Solution2525(arr, cTime).solve());
        bw.flush();
        bw.close();
    }
}
