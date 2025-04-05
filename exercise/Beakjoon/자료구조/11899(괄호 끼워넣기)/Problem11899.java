import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;

class Solution11899 {
    private Deque<Character> deque;
    private String brakets;

    public Solution11899(String brakets) {
        this.deque = new ArrayDeque<>();
        this.brakets = brakets;
    }

    public String solve() {
        int addCnt = 0;

        for(char b : brakets.toCharArray()) {
            if(b == ')') {
                if(deque.isEmpty()) {
                    addCnt++;
                } else {
                    deque.pop();
                }
            } else {
                deque.offer(b);
            }
        }
        addCnt += deque.size();

        return String.valueOf(addCnt);
    }
}

public class Problem11899 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(new Solution11899(br.readLine()).solve());
        bw.flush();
        bw.close();
    }
}
