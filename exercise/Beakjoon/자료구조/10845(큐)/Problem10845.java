import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

class MyQueue {
    private ArrayList<Integer> list;

    public MyQueue() {
        this.list = new ArrayList<>();
    }

    public void push(int x) {
        list.add(x);
    }

    public int pop() {
        if(size() == 0) {
            return -1;
        }
        int x = list.get(0);
        list.remove(0);

        return x;
    }

    public int size() {
        return list.size();
    }

    public int empty() {
        return size() == 0 ? 1 : 0;
    }

    public int front() {
        return empty() == 1 ? -1 : list.get(0);
    }

    public int back() {
        return empty() == 1 ? -1 : list.get(size() - 1);
    }
}

public class Problem10845 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        MyQueue myQueue = new MyQueue();

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String order = st.nextToken();

            switch (order) {
                case "push":
                    myQueue.push(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    bw.write(String.valueOf(myQueue.pop()));
                    bw.newLine();
                    break;
                case "size":
                    bw.write(String.valueOf(myQueue.size()));
                    bw.newLine();
                    break;                
                case "empty":
                    bw.write(String.valueOf(myQueue.empty()));
                    bw.newLine();
                    break;
                case "front":
                    bw.write(String.valueOf(myQueue.front()));
                    bw.newLine();
                    break;
                case "back":
                    bw.write(String.valueOf(myQueue.back()));
                    bw.newLine();
                    break;
            }
        }

        bw.flush();
        bw.close();
    }
}
