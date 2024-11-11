import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Solution1009 {
    private int a;
    private int b;

    public Solution1009(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public String solve() {
        int number = 1;

        for(int i = 0; i < b; i++) {
            number = number * a % 10;
        }
        
        if(number == 0) {
            number = 10;
        }

        return String.valueOf(number);
    }
}

public class Problem1009 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        for(int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            bw.write(new Solution1009(a, b).solve());
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}
