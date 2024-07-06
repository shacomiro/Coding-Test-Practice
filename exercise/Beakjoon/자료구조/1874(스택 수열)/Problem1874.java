import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Problem1874 {
    public static List<String> solution(int n, int[] sequence) {
        List<String> task = new ArrayList<>();
        Deque<Integer> stack = new ArrayDeque<>();
        int targetIdx = 0;

        for(int i = 0; i < n; i++) {
            stack.push(i + 1);
            task.add("+");

            while(!stack.isEmpty() && stack.peek() == sequence[targetIdx]) {
                stack.pop();
                task.add("-");
                targetIdx++;
            }
        }

        if(!stack.isEmpty()) {
            return new ArrayList<>(List.of("NO"));
        }

        return task;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] sequence = new int[n];
        for(int i = 0; i < n; i++) {
            sequence[i] = Integer.parseInt(br.readLine());
        }

        for(String s : solution(n, sequence)) {
            bw.write(s);
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}