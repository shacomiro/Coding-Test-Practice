import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Solution13300 {
    private int k;
    private int[][] students;

    public Solution13300(int k, int[][] students) {
        this.k = k;
        this.students = students;
    }

    public String solve() {
        int roomCount = 0;

        for(int y = 1; y <= 6; y++) {
            roomCount += (students[y][0] / k) + ((students[y][0] % k > 0) ? 1 : 0);
            roomCount += (students[y][1] / k) + ((students[y][1] % k > 0) ? 1 : 0);
        }

        return String.valueOf(roomCount);
    }
}

public class Problem13300 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] arr = new int[7][2];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            arr[y][s]++;
        }

        bw.write(new Solution13300(k, arr).solve());
        bw.flush();
        bw.close();
    }
}
