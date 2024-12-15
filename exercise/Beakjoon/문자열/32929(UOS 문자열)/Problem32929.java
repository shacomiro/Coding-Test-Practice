import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Solution32929 {
    private static final char[] uos = {'S', 'U', 'O'};
    private int x;
    
    public Solution32929(int x) {
        this.x = x;
    }
    
    public String solve() {
        return String.valueOf(uos[x % 3]);
    }
}

public class Problem32929 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(new Solution32929(Integer.parseInt(br.readLine())).solve());
        bw.flush();
        bw.close();
    }
}
