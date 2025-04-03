import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Solution20310 {
    private String str;

    public Solution20310(String str) {
        this.str = str;
    }

    public String solve() {
        char[] chars = str.toCharArray();
        int zeroCnt = 0;
        int oneCnt = 0;

        for(char c : chars) {
            switch (c) {
                case '0':
                    zeroCnt++;
                    break;
                case '1':
                    oneCnt++;
                    break;
            }
        }
        zeroCnt /= 2;
        oneCnt /= 2;

        int zi = chars.length - 1;
        while(zeroCnt > 0) {
            if(chars[zi] == '0') {
                chars[zi] = '#';
                zeroCnt--;
            }
            zi--;
        }

        int oi = 0;
        while(oneCnt > 0) {
            if(chars[oi] == '1') {
                chars[oi] = '#';
                oneCnt--;
            }
            oi++;
        }

        return String.valueOf(chars).replaceAll("#", "");
    }
}

public class Problem20310 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(new Solution20310(br.readLine()).solve());
        bw.flush();
        bw.close();
    }
}
