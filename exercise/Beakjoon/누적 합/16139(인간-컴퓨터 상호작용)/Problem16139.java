import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Solution16139 {
    private int[][] dp;
    private String s;
    private List<Question> questions;

    public Solution16139(String s, List<Question> questions) {
        this.dp = new int[26][s.length()];
        this.s = s;
        this.questions = questions;
    }

    public String solve() {
        dp();

        StringBuilder sb = new StringBuilder();
        for(Question q : questions) {
            int fromCnt = q.getFrom() == 0 ? 0 : dp[q.getC() - 'a'][q.getFrom() - 1];
            int toCnt = dp[q.getC() - 'a'][q.getTo()];

            sb.append(toCnt - fromCnt).append("\n");
        }

        return sb.toString();
    }

    private void dp() {
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if(i > 0) {
                for(int j = 0; j < 26; j++) {
                    dp[j][i] = dp[j][i - 1];
                }
            }

            dp[c - 'a'][i]++;
        }
    }

    static class Question {
        private char c;
        private int from;
        private int to;

        public Question(char c, int from, int to) {
            this.c = c;
            this.from = from;
            this.to = to;
        }

        public char getC() {
            return c;
        }

        public int getFrom() {
            return from;
        }
        
        public int getTo() {
            return to;
        }
    }
}

public class Problem16139 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        String s = br.readLine();
        int q = Integer.parseInt(br.readLine());
        List<Solution16139.Question> list = new ArrayList<>(q);
        for(int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            list.add(new Solution16139.Question(st.nextToken().charAt(0), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        bw.write(new Solution16139(s, list).solve());
        bw.flush();
        bw.close();
    }
}
