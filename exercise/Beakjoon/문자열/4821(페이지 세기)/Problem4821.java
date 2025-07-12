import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Solution4821 {
    private int n;
    private String pages;
    private boolean[] print;

    public Solution4821(int n, String pages) {
        this.n = n;
        this.pages = pages;
        this.print = new boolean[n + 1];
    }

    public String solve() {
        StringTokenizer st1 = new StringTokenizer(pages, ",");

        while (st1.hasMoreTokens()) {
            StringTokenizer st2 = new StringTokenizer(st1.nextToken(), "-");

            int low = Integer.parseInt(st2.nextToken());
            int high = -1;
            if (st2.hasMoreTokens()) {
                high = Integer.parseInt(st2.nextToken());
            }

            if (high == -1 && low <= n) {
                print[low] = true;
            } else if (low <= high) {
                for (int i = low; i <= Math.min(high, n); i++) {
                    print[i] = true;
                }
            }
        }

        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (print[i]) {
                count++;
            }
        }

        return String.valueOf(count);
    }
}

public class Problem4821 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input;

        while (!(input = br.readLine()).equals("0")) {
            bw.write(new Solution4821(Integer.parseInt(input), br.readLine()).solve());
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}
