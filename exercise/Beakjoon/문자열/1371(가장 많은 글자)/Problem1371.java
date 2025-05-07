import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Solution1371 {
    private String article;
    private int[] alphabetsCount;

    public Solution1371(String article) {
        this.article = article;
        this.alphabetsCount = new int[26];
    }

    public String solve() {
        for (char c : article.toCharArray()) {
            if (c != ' ') {
                alphabetsCount[c - 97]++;
            }
        }

        StringBuilder sb = new StringBuilder();
        int topCnt = 0;
        for (int i = 0; i < 26; i++) {
            if (topCnt < alphabetsCount[i]) {
                topCnt = alphabetsCount[i];
                sb.delete(0, sb.length());
                sb.append(Character.toChars(i + 97));
            } else if (topCnt == alphabetsCount[i]) {
                sb.append(Character.toChars(i + 97));
            }
        }

        return sb.toString();
    }
}

public class Problem1371 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input;
        StringBuilder sb = new StringBuilder();

        while ((input = br.readLine()) != null) {
            sb.append(input).append(" ");
        }

        bw.write(new Solution1371(sb.toString()).solve());
        bw.flush();
        bw.close();
    }
}
