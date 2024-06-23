import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

class Solution1406 {
    private Deque<Character> leftStack;
    private Deque<Character> rightStack;
    private List<String> commands;

    public Solution1406(String str, List<String> commands) {
        this.leftStack = new ArrayDeque<>();
        this.rightStack = new ArrayDeque<>();
        this.commands = commands;

        for(char c : str.toCharArray()) {
            leftStack.push(c);
        }
    }

    public String solve() {
        StringTokenizer st;

        for(String command : commands) {
            st = new StringTokenizer(command);
            
            switch (st.nextToken()) {
                case "L":
                    moveCursor(Direction.LEFT);
                    break;
                case "D":
                    moveCursor(Direction.RIGHT);
                    break;
                case "B":
                    removeCharacter();
                    break;
                case "P":
                    addCharacter(st.nextToken().charAt(0));
                    break;
                }
        }

        while(!leftStack.isEmpty()) {
            rightStack.push(leftStack.pop());
        }
        
        StringBuilder sb = new StringBuilder();
        for(char c : rightStack) {
            sb.append(c);
        }
        return sb.toString();
    }

    private void moveCursor(Direction direction) {
        switch (direction) {
            case LEFT:
                if(!leftStack.isEmpty()) {
                    rightStack.push(leftStack.pop());
                }
                break;
            case RIGHT:
                if(!rightStack.isEmpty()) {
                    leftStack.push(rightStack.pop());
                }
                break;
        }
    }

    private void removeCharacter() {
        if(!leftStack.isEmpty()) {
            leftStack.pop();
        }
    }

    private void addCharacter(char character) {
        leftStack.push(character);
    }

    static enum Direction {
        LEFT, RIGHT;
    }
}

public class Problem1406 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        int m = Integer.parseInt(br.readLine());
        List<String> list = new ArrayList<>();
        for(int i = 0; i < m; i++) {
            list.add(br.readLine());
        }

        bw.write(new Solution1406(str, list).solve());
        bw.flush();
        bw.close();
    }
}
