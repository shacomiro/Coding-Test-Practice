import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Solution1731 {
    private int n;
    private int[] sequence;

    public Solution1731(int n, int[] sequence) {
        this.n = n;
        this.sequence = sequence;
    }

    public String solve() {
        int plus = 0;
        int multi = 0;
        boolean isPlus = true;

        for(int i = 0; i < n - 1; i++) {
            int curr = sequence[i];
            int next = sequence[i + 1];

            int tPlus = next - curr;
            int tMulti = next / curr;

            if(plus == 0) {
                plus = tPlus;
            } else if(plus == tPlus) {
                break;
            }

            if(multi == 0) {
                multi = tMulti;
            } else if(multi == tMulti) {
                isPlus = false;
                break;
            }
        }

        return String.valueOf(isPlus ? sequence[n - 1] + plus : sequence[n - 1] * multi);
    }
}

public class Problem1731 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        bw.write(new Solution1731(n, arr).solve());
        bw.flush();
        bw.close();
    }
}
