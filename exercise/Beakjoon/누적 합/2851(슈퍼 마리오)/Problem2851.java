import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Solution2851 {
    private int[] mushrooms;

    public Solution2851(int[] mushrooms) {
        this.mushrooms = mushrooms;
    }

    public String solve() {
        int sum = 0;
        int score = 0;

        for(int i = 0; i < 10; i++) {
            sum += mushrooms[i];
            score = getApproximation(score, sum);
        }

        return String.valueOf(score);
    }

    private int getApproximation(int current, int compare) {
        int absCurr = Math.abs(100 - current);
        int absComp = Math.abs(100 - compare);
        
        return (absCurr == absComp) ? Math.max(current, compare) : ((absCurr < absComp) ? current : compare);
    }
}

public class Problem2851 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] arr = new int[10];
        for(int i = 0; i < 10; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        bw.write(new Solution2851(arr).solve());
        bw.flush();
        bw.close();
    }
}
