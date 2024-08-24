import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

class Solution12789 {
    private Deque<Integer> wait1;
    private Deque<Integer> wait2;

    public Solution12789(List<Integer> numbers) {
        this.wait1 = new ArrayDeque<>(numbers);
        this.wait2 = new ArrayDeque<>();
    }

    public String solve() {
        int accept = 1;

        while(true) {
            if(!wait2.isEmpty() && wait2.peek() == accept) {
                wait2.pop();
                accept++;
            } else if(!wait1.isEmpty()) {
                int curr = wait1.pop();

                if(curr == accept) {
                    accept++;
                } else {
                    wait2.push(curr);
                }
            } else {
                break;
            }
        }

        return wait1.isEmpty() && wait2.isEmpty() ? "Nice" : "Sad";
    }
}

public class Problem12789 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>(n);
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        bw.write(new Solution12789(list).solve());
        bw.flush();
        bw.close();
    }
}
