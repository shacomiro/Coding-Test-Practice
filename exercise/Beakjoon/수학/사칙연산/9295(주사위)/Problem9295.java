import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Solution9295 {
    private int id;
    private int number1;
    private int number2;

    public Solution9295(int id, int number1, int number2) {
        this.id = id;
        this.number1 = number1;
        this.number2 = number2;
    }

    public String solve() {
        return String.valueOf("Case " + id + ": " + (number1 + number2));
    }
}


public class Problem9295 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            bw.write(new Solution9295(i + 1, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())).solve());
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}
