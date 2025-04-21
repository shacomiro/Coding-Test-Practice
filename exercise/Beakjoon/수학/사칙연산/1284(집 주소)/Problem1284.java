import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Solution1284 {
    private int n;

    public Solution1284(int n) {
        this.n = n;
    }

    public String solve() {
        int width = 2;

        while(n > 0) {
            int number = n % 10;
            
            if(number == 0) {
                width += 4;
            } else if(number == 1) {
                width += 2;
            } else {
                width += 3;
            }

            if(n >= 10) {
                width += 1;
            }
            
            n /= 10;
        }

        return String.valueOf(width);
    }
}

public class Problem1284 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input;
        while(!(input = br.readLine()).equals("0")) {
            bw.write(new Solution1284(Integer.parseInt(input)).solve());
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}
