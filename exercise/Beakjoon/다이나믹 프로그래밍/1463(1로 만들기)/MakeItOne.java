import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class MakeItOne {
    public int solution(int n) {
        int[] dp = new int[n + 1];
        
        for(int x = n; x > 0; x--) {
            int nextStep = dp[x] + 1;
            
            if(x % 3 == 0) {
                if(dp[x / 3] == 0 || nextStep < dp[x / 3]) {
                    dp[x / 3] = dp[x] + 1;
                }
            }
            
            if(x % 2 == 0) {
                if(dp[x / 2] == 0 || nextStep < dp[x / 2]) {
                    dp[x / 2] = dp[x] + 1;
                }
            }
            
            if(dp[x - 1] == 0 || nextStep < dp[x - 1]) {
                dp[x - 1] = dp[x] + 1;
            }
        }
        
        return dp[1];
    }
    
    public static void main(String[] args) throws IOException {
        MakeItOne main = new MakeItOne();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        System.out.print(main.solution(n));
    }
}