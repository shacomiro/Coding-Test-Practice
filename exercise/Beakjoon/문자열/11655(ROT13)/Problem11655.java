import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Solution11655 {
    private char[] chars;
    private int step;

    public Solution11655(String str, int step) {
        this.chars = str.toCharArray();
        this.step = step;
    }

    public String solve() {
        for(int i = 0; i < chars.length; i++) {
            char c = chars[i];

            if(isAlphabet(c)) {
                chars[i] = rotate(c, step);
            }
        }

        return String.valueOf(chars);
    }

    private char rotate(char alphabet, int step) {
        return ('a' <= alphabet && alphabet <= 'z') ?
                (char) ('a' + (alphabet - 'a' + step) % 26) :
                (char) ('A' + (alphabet - 'A' + step) % 26);
    }

    private boolean isAlphabet(char c) {
        return (('a' <= c && c <= 'z') || ('A' <= c && c <= 'Z')) ? true : false;
    }
}

public class Problem11655 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(new Solution11655(br.readLine(), 13).solve());
        bw.flush();
        bw.close();
    }
}
