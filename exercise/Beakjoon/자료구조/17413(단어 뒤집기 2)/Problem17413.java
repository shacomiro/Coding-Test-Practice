import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;

class Solution17413 {
    private String str;
    private Deque<Character> stack;
    private StringBuilder sb;

    public Solution17413(String str) {
        this.str = str + " ";
        this.stack = new ArrayDeque<>();
        this.sb = new StringBuilder(str.length());
    }

    public String solve() {
        char[] chars = str.toCharArray();
        boolean isTag = false;

        for(char c : chars) {
            switch (c) {
                case ' ':
                    if(!isTag) {
                        flashStack();
                    }
                    sb.append(c);
                    break;
                case '<':
                    if(!isTag) {
                        flashStack();
                    }
                    isTag = true;
                    sb.append(c);
                    break;
                case '>':
                    isTag = false;
                    sb.append(c);
                    break;
                default:
                    if(isTag) {
                        sb.append(c);
                    } else {
                        stack.push(c);
                    }
                    break;
            }
        }

        return sb.toString();
    }

    private void flashStack() {
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }
    }
}

public class Problem17413 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(new Solution17413(br.readLine()).solve());
        bw.flush();
        bw.close();
    }
}