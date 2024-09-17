import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Solution8958 {
    private String OX;

    public Solution8958(String OX) {
        this.OX = OX;
    }

    public String solve() {
        int point = 0;        
        int stack = 0;

        for(char c : OX.toCharArray()) {
            switch (c) {
                case 'O':
                    stack++;
                    point += stack;
                    break;
                case 'X':
                    stack = 0;
                    break;
            }
        }

        return String.valueOf(point);
    }
}

public class Problem8958 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        for(int i = 0; i < t; i++) {
            bw.write(new Solution8958(br.readLine()).solve());
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}
