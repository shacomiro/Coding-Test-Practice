import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Problem1927 {
    public static ArrayList<Integer> byPriorityQueue(int[] operations) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        ArrayList<Integer> answer = new ArrayList<>();

        for(int x : operations) {
            if(x == 0) {
                if(minHeap.peek() == null) {
                    answer.add(0);
                } else {
                    answer.add(minHeap.poll());
                }
            } else {
                minHeap.add(x);
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] operations = new int[n];

        for(int i = 0; i < n; i++) {
            operations[i] = Integer.parseInt(br.readLine());
        }

        for(int num : byPriorityQueue(operations)) {
            bw.write(String.valueOf(num));
            bw.newLine();
        }

        bw.flush();
        bw.close();
    }
}