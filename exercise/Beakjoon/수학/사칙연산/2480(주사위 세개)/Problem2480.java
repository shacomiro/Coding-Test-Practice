import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Solution2480 {
    private int num1;
    private int num2;
    private int num3;

    public Solution2480(int num1, int num2, int num3) {
        this.num1 = num1;
        this.num2 = num2;
        this.num3 = num3;
    }

    public String solve() {
        int sameValue = 0;

        if(num1 == num2 && num2 == num3) {
            return String.valueOf(10000 + num1 * 1000);
        } else if(num1 == num2 || num1 == num3) {
            sameValue = num1;
        } else if(num2 == num3) {
            sameValue = num2;
        }
        
        if(sameValue != 0) {
            return String.valueOf(1000 + sameValue * 100);
        } else {
            return String.valueOf(Math.max(Math.max(num1, num2), num3) * 100);
        }
    }
}

public class Problem2480 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n1 = Integer.parseInt(st.nextToken());
        int n2 = Integer.parseInt(st.nextToken());
        int n3 = Integer.parseInt(st.nextToken());

        bw.write(new Solution2480(n1, n2, n3).solve());
        bw.flush();
        bw.close();
    }
}
