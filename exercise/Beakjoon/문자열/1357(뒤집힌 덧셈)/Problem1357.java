import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Solution1357 {
    private int x;
    private int y;

    public Solution1357(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public String solve() {
        return String.valueOf(rev(rev(x) + rev(y)));
    }

    private int rev(int num) {
        return Integer.parseInt(new StringBuilder(String.valueOf(num)).reverse().toString());
    }
}

public class Problem1357 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        bw.write(new Solution1357(x, y).solve());
        bw.flush();
        bw.close();
    }
}
