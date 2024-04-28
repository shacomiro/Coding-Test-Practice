import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

class MyStack {
    private ArrayList<Integer> list;
    private int top;

    public MyStack() {
        this.list = new ArrayList<>();
        top = -1;
    }

    public void push(int value) {
        list.add(++top, value);
    }

    public int pop() {
        if(top == -1) return -1;

        int value = list.get(top);
        list.remove(top--);

        return value;
    }

    public int size() {
        return list.size();
    }

    public int isEmpty() {
        return top == -1 ? 1 : 0;
    }

    public int top() {
        return top == -1 ? -1 : list.get(top);
    }
}

class Stack {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        MyStack myStack = new MyStack();
        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String order = st.nextToken();

            switch (order) {
                case "push":
                    myStack.push(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    bw.write(String.valueOf(myStack.pop()));
                    bw.newLine();
                    break;
                case "size":
                    bw.write(String.valueOf(myStack.size()));
                    bw.newLine();
                    break;                
                case "empty":
                    bw.write(String.valueOf(myStack.isEmpty()));
                    bw.newLine();
                    break;
                case "top":
                    bw.write(String.valueOf(myStack.top()));
                    bw.newLine();
                    break;
            }
        }

        bw.flush();
        bw.close();
    }
}