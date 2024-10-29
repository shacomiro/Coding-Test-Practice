import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Solution1439 {
    private char[] chars;

    public Solution1439(String str) {
        this.chars = str.toCharArray();
    }

    public String solve() {
        int cntZero = 0;
        int cntOne = 0;

        for(int i = 0; i < chars.length - 1; i++) {
            if(chars[i] != chars[i + 1]) {
                if(chars[i] == '0') {
                    cntZero++;
                } else {
                    cntOne++;
                }
            }
        }

        if(chars[chars.length - 1] == '0') {
            cntZero++;
        } else {
            cntOne++;
        }

        return String.valueOf(Math.min(cntZero, cntOne));
    }
}

public class Problem1439 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(new Solution1439(br.readLine()).solve());
        bw.flush();
        bw.close();
    }
}
