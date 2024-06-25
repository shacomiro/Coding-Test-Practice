import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class Solution10773 {
    private Deque<Integer> stack;
    private List<Integer> numbers;

    public Solution10773(List<Integer> numbers) {
        this.stack = new ArrayDeque<>();
        this.numbers = numbers;
    }

    public String solve() {
        for(int number : numbers) {
            if(number == 0) {
                stack.pop();
            } else {
                stack.push(number);
            }
        }

        int sum = 0;
        for(int number : stack) {
            sum += number;
        }

        return String.valueOf(sum);
    }
}

public class Problem10773 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int k = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>(k);
        for(int i = 0; i < k; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }

        bw.write(new Solution10773(list).solve());
        bw.flush();
        bw.close();
    }
}
