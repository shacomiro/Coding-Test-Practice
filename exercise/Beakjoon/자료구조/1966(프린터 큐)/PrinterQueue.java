import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class PrinterQueue {
    public static int solution(int m, int[] priorities) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        Queue<Document> printerQueue = new LinkedList<>();

        for(int i = 0; i < priorities.length; i++) {
            priorityQueue.add(priorities[i]);
            printerQueue.add(new Document(i, priorities[i]));
        }
        int count = 0;
        
        while(!printerQueue.isEmpty()) {
            Document document = printerQueue.poll();
            if(document.getPriority() == priorityQueue.peek()) {
                priorityQueue.poll();
                count++;

                if(document.getIndex() == m) {
                    break;
                }
            } else {
                printerQueue.add(document);
            }
        }

        return count;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCase = Integer.parseInt(br.readLine());
        for(int i = 0; i < testCase; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            StringTokenizer st2 = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st1.nextToken());
            int m = Integer.parseInt(st1.nextToken());
            int[] priorities = new int[n];
            for(int idx = 0; idx < n; idx++) {
                priorities[idx] = Integer.parseInt(st2.nextToken());
            }

            bw.write(String.valueOf(solution(m, priorities)));
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}

class Document implements Comparable<Document> {
    private int index;
    private int priority;

    public Document(int index, int priority) {
        this.index = index;
        this.priority = priority;
    }

    public int getIndex() {
        return index;
    }

    public int getPriority() {
        return priority;
    }

    @Override
    public int compareTo(Document o) {
        if(this.priority == o.priority) {
            return this.index - o.index;
        }
        return o.priority - this.priority;
    }

    @Override
    public String toString() {
        return "[index:" + this.index + ", priority:"  + this.priority + "]";
    }
}