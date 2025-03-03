import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

class Solution28279 {
    private List<String> commands;
    private Deque deque;

    public Solution28279(List<String> commands) {
        this.commands = commands;
        this.deque = new Deque();
    }

    public String solve() {
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        for(String command : commands) {
            st = new StringTokenizer(command);
            String order = st.nextToken();

            switch (order) {
                case "1":
                    deque.pushFirst(Integer.parseInt(st.nextToken()));
                    break;
                case "2":
                    deque.pushLast(Integer.parseInt(st.nextToken()));
                    break;
                case "3":
                    sb.append(deque.pollFirst()).append("\n");
                    break;
                case "4":
                    sb.append(deque.pollLast()).append("\n");
                    break;
                case "5":
                    sb.append(deque.size()).append("\n");
                    break;
                case "6":
                    sb.append(deque.isEmpty()).append("\n");
                    break;
                case "7":
                    sb.append(deque.peekFirst()).append("\n");
                    break;
                case "8":
                    sb.append(deque.peekLast()).append("\n");
                    break;
            }
        }

        return sb.toString();
    }

    static class Deque {
        private LinkedList<Integer> list;

        public Deque() {
            this.list = new LinkedList<>();
        }

        public void pushFirst(int x) {
            list.addFirst(x);
        }

        public void pushLast(int x) {
            list.addLast(x);
        }

        public int pollFirst() {
            if(isEmpty() == 1) {
                return -1;
            }

            int x = list.getFirst();
            list.removeFirst();

            return x;
        }

        public int pollLast() {
            if(isEmpty() == 1) {
                return -1;
            }

            int x = list.getLast();
            list.removeLast();

            return x;
        }

        public int size() {
            return list.size();
        }

        public int isEmpty() {
            return list.isEmpty() ? 1 : 0;
        }

        public int peekFirst() {
            return (isEmpty() == 1) ? -1 : list.getFirst();
        }

        public int peekLast() {
            return (isEmpty() == 1) ? -1 : list.getLast();
        }
    }
}

public class Problem28279 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        List<String> list = new ArrayList<>(n);
        for(int i = 0; i < n; i++) {
            list.add(br.readLine());
        }

        bw.write(new Solution28279(list).solve());
        bw.flush();
        bw.close();
    }
}
