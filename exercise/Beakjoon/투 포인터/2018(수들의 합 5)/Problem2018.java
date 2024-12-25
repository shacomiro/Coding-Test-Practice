import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Solution2018 {
    private int n;

    public Solution2018(int n) {
        this.n = n;
    }

    public String solve() {
        int count = 0;
        int sum = 0;
        int lt = 1;
        int rt = 1;

        while(true) {
            if(rt <= n && sum < n) {
                sum += rt++;
            } else if(lt <= n && sum >= n) {
                sum -= lt++;
            } else {
                break;
            }

            if(sum == n) {
                count++;
            }
        }

        return String.valueOf(count);
    }
}

public class Problem2018 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(new Solution2018(Integer.parseInt(br.readLine())).solve());
        bw.flush();
        bw.close();
    }
}
