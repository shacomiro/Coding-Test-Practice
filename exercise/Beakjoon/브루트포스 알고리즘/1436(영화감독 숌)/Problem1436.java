import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Solution1436 {
    private int n;

    public Solution1436(int n) {
        this.n = n;
    }

    public String solve() {
        int number = 666;
        int count = 1;
        
        while(count < n) {
            number++;

            if(String.valueOf(number).contains("666")) {
                count++;
            }
        }

        return String.valueOf(number);
    }
}

public class Problem1436 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(new Solution1436(Integer.parseInt(br.readLine())).solve());
        bw.flush();
        bw.close();
    }
}
