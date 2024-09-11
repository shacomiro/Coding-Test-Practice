import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Solution2577 {
    private int[] count;
    private int a;
    private int b;
    private int c;

    public Solution2577(int a, int b, int c) {
        this.count = new int[10];
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public String solve() {
        int abc = a * b * c;
        
        while(abc > 0) {
            count[abc % 10]++;
            abc /= 10;
        }

        StringBuilder sb = new StringBuilder();
        for(int c : count) {
            sb.append(c).append("\n");
        }

        return sb.toString();
    }
}

public class Problem2577 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(new Solution2577(Integer.parseInt(br.readLine()), Integer.parseInt(br.readLine()), Integer.parseInt(br.readLine())).solve());
        bw.flush();
        bw.close();
    }
}
