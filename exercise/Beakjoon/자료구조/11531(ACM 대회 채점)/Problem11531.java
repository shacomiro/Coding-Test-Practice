import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Solution11531 {
    private List<String> logs;
    private int[] penalties;

    public Solution11531(List<String> logs) {
        this.logs = logs;
        this.penalties = new int[26];
    }

    public String solve() {
        int totalTime = 0;
        int rightCount = 0;

        for (String log : logs) {
            StringTokenizer st = new StringTokenizer(log);
            int time = Integer.parseInt(st.nextToken());
            Character problem = st.nextToken().charAt(0);
            boolean isRight = (st.nextToken().equals("right")) ? true : false;

            if (isRight) {
                totalTime += time + penalties[problem - 'A'];
                rightCount++;
            } else {
                penalties[problem - 'A'] += 20;
            }
        }

        return rightCount + " " + totalTime;
    }
}

public class Problem11531 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input;

        List<String> list = new ArrayList<>();
        while (!(input = br.readLine()).equals("-1")) {
            list.add(input);
        }

        bw.write(new Solution11531(list).solve());
        bw.flush();
        bw.close();
    }
}
