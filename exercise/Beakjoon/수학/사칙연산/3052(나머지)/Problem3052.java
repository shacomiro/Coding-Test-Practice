import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

class Solution3052 {
    private List<Integer> numbers;
    private boolean[] remainders;

    public Solution3052(List<Integer> numbers) {
        this.numbers = numbers;
        this.remainders = new boolean[42];
    }

    public String solve() {
        int count = 0;

        for(int number : numbers) {
            int r = number % 42;

            if(!remainders[r]) {
                remainders[r] = true;
                count++;
            }
        }

        return String.valueOf(count);
    }
}

public class Problem3052 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        List<Integer> list = new ArrayList<>(10);
        for(int i = 0; i < 10; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }

        bw.write(new Solution3052(list).solve());
        bw.flush();
        bw.close();
    }
}
