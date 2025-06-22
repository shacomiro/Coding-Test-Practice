import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

class Solution6996 {
    private String word1;
    private String word2;

    public Solution6996(String word1, String word2) {
        this.word1 = word1;
        this.word2 = word2;
    }

    public String solve() {
        char[] chars1 = word1.toCharArray();
        char[] chars2 = word2.toCharArray();
        Arrays.sort(chars1);
        Arrays.sort(chars2);

        boolean isAnagram = String.valueOf(chars1).equals(String.valueOf(chars2));

        return word1 + " & " + word2 + ((isAnagram) ? " are anagrams." : " are NOT anagrams.");
    }
}

public class Problem6996 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            bw.write(new Solution6996(st.nextToken(), st.nextToken()).solve());
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}
