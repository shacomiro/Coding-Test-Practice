import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

class Solution3273 {
    private int[] numbers;
    private int target;

    public Solution3273(int[] numbers, int target) {
        this.numbers = numbers;
        this.target = target;
    }

    public String solve() {
        int count = 0;
        int lt = 0;
        int rt = numbers.length - 1;

        Arrays.sort(numbers);

        while(lt < rt) {
            int sum = numbers[lt] + numbers[rt];

            if(sum == target) {
                count++;
            }

            if(sum > target) {
                rt--;
            } else {
                lt++;
            }
        }

        return String.valueOf(count);
    }
}

public class Problem3273 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int x = Integer.parseInt(br.readLine());

        bw.write(new Solution3273(arr, x).solve());
        bw.flush();
        bw.close();
    }
}
