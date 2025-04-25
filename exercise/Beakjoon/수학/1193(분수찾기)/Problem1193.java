import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Solution1193 {
    private int x;

    public Solution1193(int x) {
        this.x = x;
    }

    public String solve() {
        int cross = 1;
        int count = 0;
        int big = 1;
        int small = 1;

        while (true) {
            if (x <= cross + count) {
                big = cross - (x - count) + 1;
                small = x - count;

                break;
            } else {
                count += cross++;
            }
        }

        return (cross % 2 == 0) ? small + "/" + big : big + "/" + small;
    }
}

public class Problem1193 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(new Solution1193(Integer.parseInt(br.readLine())).solve());
        bw.flush();
        bw.close();
    }
}
