import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;

class Solution25497 {
    private int n;
    private String skills;
    private Deque<Character> lr;
    private Deque<Character> sk;

    public Solution25497(int n, String skills) {
        this.n = n;
        this.skills = skills;
        this.lr = new ArrayDeque<>();
        this.sk = new ArrayDeque<>();
    }

    public String solve() {
        int cnt = 0;

        for(int i = 0; i < n; i++) {
            char skill = skills.charAt(i);

            if(skill == 'L') {
                lr.push(skill);
            } else if(skill == 'R') {
                if(lr.isEmpty()) {
                    break;
                } else if(lr.peek() == 'L') {
                    lr.pop();
                    cnt++;
                }
            } else if(skill == 'S') {
                sk.push(skill);
            } else if(skill == 'K') {
                if(sk.isEmpty()) {
                    break;
                } else if(sk.peek() == 'S') {
                    sk.pop();
                    cnt++;
                }
            } else {
                cnt++;
            }
        }

        return String.valueOf(cnt);
    }
}

public class Problem25497 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();

        bw.write(new Solution25497(n, str).solve());
        bw.flush();
        bw.close();
    }
}
