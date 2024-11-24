import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

class Solution17952 {
    private int n;
    private String[] assignments;
    private Deque<int[]> stack;

    public Solution17952(int n, String[] assignments) {
        this.n = n;
        this.assignments = assignments;
        this.stack = new ArrayDeque<>();
    }

    public String solve() {
        int time = 0;
        int score = 0;
        StringTokenizer st;

        while(time < n) {
            st = new StringTokenizer(assignments[time]);
            if(st.nextToken().equals("1")) {
                stack.push(new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
            }

            if(!stack.isEmpty() && --stack.peek()[1] == 0) {
                score += stack.pop()[0];
            }

            time++;
        }

        return String.valueOf(score);
    }
}

public class Problem17952 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String[] arr = new String[n];
        for(int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }

        bw.write(new Solution17952(n, arr).solve());
        bw.flush();
        bw.close();
    }
}
