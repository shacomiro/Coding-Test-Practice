import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Solution2512 {
    private int[] budgetRequests;
    private int budgetLimit;

    public Solution2512(int[] budgetRequests, int budgetLimit) {
        this.budgetRequests = budgetRequests;
        this.budgetLimit = budgetLimit;
    }

    public String solve() {
        int min = 0;
        int max = 0;

        for(int budgetReq : budgetRequests) {
            min = Math.min(min, budgetReq);
            max = Math.max(max, budgetReq);
        }

        return String.valueOf(binarySearch(budgetLimit, min, max));
    }

    private int binarySearch(int target, int start, int end) {
        int mid = 0;
        int max = 0;
        
        while(start <= end) {
            mid = (start + end) / 2;
            int expBudget = getExpectedBudget(mid);

            if(expBudget == target) {
                return mid;
            } else if(expBudget < target) {
                max = Math.max(max, mid);
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return max;
    }

    private int getExpectedBudget(int budgetLimit) {
        int sum = 0;

        for(int budgetReq : budgetRequests) {
            sum += (budgetReq > budgetLimit) ? budgetLimit : budgetReq ;
        }

        return sum;
    }
}

public class Problem2512 {
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
        int m = Integer.parseInt(br.readLine());
        
        bw.write(new Solution2512(arr, m).solve());
        bw.flush();
        bw.close();
    }
}
