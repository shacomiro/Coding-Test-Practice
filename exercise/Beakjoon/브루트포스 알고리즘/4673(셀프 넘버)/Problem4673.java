import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

class Solution4673 {
    private boolean[] isGenerator;

    public Solution4673() {
        this.isGenerator = new boolean[100001];
    }

    public String solve() {
        for(int i = 1; i <= 10000; i++) {
            int n = d(i);

            if(n <= 10000) {
                isGenerator[n] = true;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= 10000; i++) {
            if(!isGenerator[i]) {
                sb.append(i).append("\n");
            }
        }

        return sb.toString();
    }

    private int d(int n) {
        int sum = n;

        while(n != 0) {
            sum += n % 10;    
            n /= 10;
        }

        return sum;
    }
}

public class Problem4673 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(new Solution4673().solve());
        bw.flush();
        bw.close();
    }
}
