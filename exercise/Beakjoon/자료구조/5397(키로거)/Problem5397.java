import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;

class Solution5397 {
    private String keylog;
    private Deque<Character> leftStack;
    private Deque<Character> rightStack;

    public Solution5397(String keylog) {
        this.keylog = keylog;
        this.leftStack = new ArrayDeque<>(keylog.length());
        this.rightStack = new ArrayDeque<>(keylog.length());
    }

    public String solve() {
        for(char key : keylog.toCharArray()) {
            switch (key) {
                case '-':
                    if(!leftStack.isEmpty()) {
                        leftStack.pop();
                    }
                    break;
                case '<':
                    if(!leftStack.isEmpty()) {
                        rightStack.push(leftStack.pop());
                    }
                    break;
                case '>':
                    if(!rightStack.isEmpty()) {
                        leftStack.push(rightStack.pop());
                    }
                    break;
                default:
                    leftStack.push(key);
                    break;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        while(!leftStack.isEmpty()) {
            rightStack.push(leftStack.pop());
        }
        while(!rightStack.isEmpty()) {
            sb.append(rightStack.pop());
        }

        return sb.toString();
    }
}

public class Problem5397 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        for(int i = 0; i < t; i++) {
            String str = br.readLine();
            bw.write(new Solution5397(str).solve());
            bw.newLine();
        }

        bw.flush();
        bw.close();
    }
}
