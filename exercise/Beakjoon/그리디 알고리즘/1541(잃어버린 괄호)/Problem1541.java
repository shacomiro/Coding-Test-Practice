import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Solution1541 {
    private String expression;
    private int sum;
    

    public Solution1541(String expression) {
        this.expression = expression;
        this.sum = Integer.MAX_VALUE;
    }

    public String solve() {
        StringTokenizer subs = new StringTokenizer(expression, "-");
        while(subs.hasMoreTokens()) {
            StringTokenizer adds = new StringTokenizer(subs.nextToken(), "+");
            int temp = 0;

            while(adds.hasMoreTokens()) {
                temp += Integer.parseInt(adds.nextToken());
            }

            
            if(sum != Integer.MAX_VALUE) {
                sum -= temp;
            } else {
                sum = temp;
            }
            
        }

        return String.valueOf(sum);
    }
}

public class Problem1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(new Solution1541(br.readLine()).solve());
        bw.flush();
        bw.close();
    }
}