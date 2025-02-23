import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

class Solution1759 {
    private int l;
    private int c;
    private char[] chars;
    private Set<Character> vowels;
    private StringBuilder sb;

    public Solution1759(int l, int c, char[] chars) {
        this.l = l;
        this.c = c;
        this.chars = chars;
        this.vowels = new HashSet<>() {{
            add('a');
            add('e');
            add('i');
            add('o');
            add('u');
        }};
        this.sb = new StringBuilder();
    }

    public String solve() {
        Arrays.sort(chars);
        next(new StringBuilder(), 0, 0, 0);

        return sb.toString();
    }

    private void next(StringBuilder pw, int vCnt, int cCnt, int start) {
        if(pw.length() == l) {
            if(vCnt >= 1 && cCnt >= 2) {
                sb.append(pw).append("\n");
            }

            return;
        }

        for(int i = start; i < c; i++) {
            int nvCnt = vCnt;
            int ncCnt = cCnt;

            if(vowels.contains(chars[i])) {
                nvCnt += 1;
            } else {
                ncCnt += 1;
            }

            pw.append(chars[i]);
            next(pw, nvCnt, ncCnt, i + 1);
            pw.deleteCharAt(pw.length() - 1);
        }
    }
}

public class Problem1759 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int l = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        char[] arr = new char[c];
        for(int i = 0; i < c; i++) {
            arr[i] = st.nextToken().charAt(0);
        }

        bw.write(new Solution1759(l, c, arr).solve());
        bw.flush();
        bw.close();
    }
}
