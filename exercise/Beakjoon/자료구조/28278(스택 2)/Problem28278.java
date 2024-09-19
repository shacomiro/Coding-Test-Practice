import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Solution28278 {
    private List<String> commands;
    private Stack stack;

    public Solution28278(List<String> commands) {
        this.commands = commands;
        this.stack = new Stack();
    }

    public String solve() {
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        for(String commend : commands) {
            st = new StringTokenizer(commend);

            switch (st.nextToken()) {
                case "1":
                    stack.push(Integer.parseInt(st.nextToken()));
                    break;
                case "2":
                    sb.append(stack.pop()).append("\n");
                    break;
                case "3":
                    sb.append(stack.size()).append("\n");
                    break;
                case "4":
                    sb.append(stack.isEmpty()).append("\n");
                    break;
                case "5":
                    sb.append(stack.peek()).append("\n");
                    break;
            }
        }

        return sb.toString();
    }

    static class Stack {
        private ArrayList<Integer> list;
        private int top;

        public Stack() {
            this.list = new ArrayList<>();
            this.top = -1;
        }

        public void push(int element) {
            list.add(++top,element);
        }

        public int pop() {
            if(top == -1) {
                return -1;
            }

            int element = list.get(top);
            list.remove(top--);

            return element;
        }

        public int peek() {
            return top == -1 ? -1 : list.get(top);
        }

        public int size() {
            return list.size();
        }

        public int isEmpty() {
            return top == -1 ? 1 : 0;
        }
    }
}

public class Problem28278 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        List<String> list = new ArrayList<>(n);
        for(int i = 0; i < n; i++) {
            list.add(br.readLine());
        }

        bw.write(new Solution28278(list).solve());
        bw.flush();
        bw.close();
    }
}
