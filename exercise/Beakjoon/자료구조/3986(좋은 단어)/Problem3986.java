import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class Solution3986 {
    private Deque<Character> stack;
    private List<String> words;

    public Solution3986(List<String> words) {
        this.stack = new ArrayDeque<>();
        this.words = words;
    }

    public String solve() {
        int count = 0;

        for(String word : words) {
            for(char c : word.toCharArray()) {
                if(!stack.isEmpty() && c == stack.peek()) {
                    stack.poll();
                } else {
                    stack.push(c);
                }
            }

            if(stack.size() == 0) {
                count++;
            } else {
                stack.clear();
            }
        }

        return String.valueOf(count);
    }
}

public class Problem3986 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        List<String> list = new ArrayList<>(n);
        for(int i = 0; i < n; i++) {
            list.add(br.readLine());
        }

        bw.write(new Solution3986(list).solve());
        bw.flush();
        bw.close();
    }
}
