import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Solution1157 {
    private char[] chars;
    private int[] count;

    public Solution1157(String word) {
        this.chars = word.toUpperCase().toCharArray();
        this.count = new int[26];
    }

    public String solve() {
        int maxCnt = 0;
        int maxIdx = -1;

        for(char c : chars) {
            int idx = c - 'A';
            count[idx]++;

            if(count[idx] > maxCnt) {
                maxCnt = count[idx];
                maxIdx = idx;
            } else if(count[idx] == maxCnt) {
                maxIdx = -1;
            }
        }

        return maxIdx != -1 ? String.valueOf((char) (maxIdx + 'A')) : "?";
    }
}

public class Problem1157 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(new Solution1157(br.readLine()).solve());
        bw.flush();
        bw.close();
    }
}
