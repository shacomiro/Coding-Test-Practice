import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Solution14916 {
    private int change;

    public Solution14916(int change) {
        this.change = change;
    }

    public String solve() {
        int count = 0;

        while(change >= 2) {
            if(change % 5 == 0) {
                count++;
                change -= 5;
            } else {
                count++;
                change -= 2;
            }
        }

        return String.valueOf((change == 0) ? count : -1);
    }
}

public class Problem14916 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(new Solution14916(Integer.parseInt(br.readLine())).solve());
        bw.flush();
        bw.close();
    }
}
