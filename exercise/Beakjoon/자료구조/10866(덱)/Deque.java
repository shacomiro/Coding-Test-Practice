import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

class MyDeque {
    LinkedList<Integer> list;

    public MyDeque() {
        list = new LinkedList<>();
    }

    public void pushFront(int x) {
        list.addFirst(x);
    }

    public void pushBack(int x) {
        list.addLast(x);
    }

    public int popFront() {
        if(list.isEmpty()) {
            return -1;
        }

        int x = list.getFirst();
        list.removeFirst();

        return x;
    }

    public int popBack() {
        if(list.isEmpty()) {
            return -1;
        }

        int x = list.getLast();
        list.removeLast();

        return x;
    }

    public int size() {
        return list.size();
    }

    public int empty() {
        if(list.isEmpty()) {
            return 1;
        } else {
            return 0;
        }
    }

    public int front() {
        if(list.isEmpty()) {
            return -1;
        }

        return list.getFirst();
    }

    public int back() {
        if(list.isEmpty()) {
            return -1;
        }

        return list.getLast();
    }
}

public class Deque {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        MyDeque myDeque = new MyDeque();
        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String order = st.nextToken();

            switch (order) {
                case "push_front":
                    myDeque.pushFront(Integer.parseInt(st.nextToken()));
                    break;
                case "push_back":
                    myDeque.pushBack(Integer.parseInt(st.nextToken()));
                    break;
                case "pop_front":
                    bw.write(String.valueOf(myDeque.popFront()));
                    bw.newLine();
                    break;
                case "pop_back":
                    bw.write(String.valueOf(myDeque.popBack()));
                    bw.newLine();
                    break;
                case "size":
                    bw.write(String.valueOf(myDeque.size()));
                    bw.newLine();
                    break;
                case "empty":
                    bw.write(String.valueOf(myDeque.empty()));
                    bw.newLine();
                    break;
                case "front":
                    bw.write(String.valueOf(myDeque.front()));
                    bw.newLine();
                    break;
                case "back":
                    bw.write(String.valueOf(myDeque.back()));
                    bw.newLine();
                    break;
            }
        }

        bw.flush();
        bw.close();
    }
}
