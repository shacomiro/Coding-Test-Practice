import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

class Solution18258 {
    private List<String> commands;
    private Queue queue;

    public Solution18258(List<String> commands) {
        this.commands = commands;
        this.queue = new Queue();
    }

    public String solve() {
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        for(String command : commands) {
            st = new StringTokenizer(command);

            switch (st.nextToken()) {
                case "push":
                    queue.push(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    sb.append(queue.pop()).append("\n");
                    break;
                case "size":
                    sb.append(queue.size()).append("\n");
                    break;                
                case "empty":
                    sb.append(queue.empty()).append("\n");
                    break;
                case "front":
                    sb.append(queue.front()).append("\n");
                    break;
                case "back":
                    sb.append(queue.back()).append("\n");
                    break;
            }
        }

        return sb.toString();
    }

    static class Queue {
        private LinkedList<Integer> list;

        public Queue() {
            this.list = new LinkedList<>();
        }

        public void push(int x) {
            list.addLast(x);
        }

        public int pop() {
            if(size() == 0) {
                return -1;
            }
            int x = list.getFirst();
            list.removeFirst();

            return x;
        }

        public int size() {
            return list.size();
        }

        public int empty() {
            return (size() == 0) ? 1 : 0;
        }

        public int front() {
            return (empty() == 1) ? -1 : list.getFirst();
        }

        public int back() {
            return (empty() == 1) ? -1 : list.getLast();
        }
    }
}

public class Problem18258 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        List<String> list = new ArrayList<>(n);
        for(int i = 0; i < n; i++) {
            list.add(br.readLine());
        }

        bw.write(new Solution18258(list).solve());
        bw.flush();
        bw.close();
    }
}
