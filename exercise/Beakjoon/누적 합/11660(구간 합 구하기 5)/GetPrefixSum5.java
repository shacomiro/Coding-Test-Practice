import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

class GetPrefixSum5 {
    public int[] solution(int n, int m, int[][] arr, int[][] range) {
        int[] answer = new int[m];
        int[][] dp = new int[n + 1][n + 1];
        
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + arr[i - 1][j - 1];
            }
        }
        
        for(int i = 0; i < m; i++) {
            int fromX = range[i][0];
            int fromY = range[i][1];
            int toX = range[i][2];
            int toY = range[i][3];

            answer[i] = dp[toX][toY] - dp[fromX - 1][toY] - dp[toX][fromY - 1] + dp[fromX - 1][fromY - 1];
        }
        
        return answer;
    }
    
    public static void main(String[] args) throws IOException {
        GetPrefixSum5 main = new GetPrefixSum5();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st1.nextToken());
        int m = Integer.parseInt(st1.nextToken());
        int[][] arr = new int[n][n];
        int[][] range = new int[m][4];
        
        for(int i = 0; i < n; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st2.nextToken());
            }
        }
        
        for(int i = 0; i < m; i++) {
            StringTokenizer st3 = new StringTokenizer(br.readLine());
            for(int j = 0; j < 4; j++) {
                range[i][j] = Integer.parseInt(st3.nextToken());
            }
        }
        
        int[] answer = main.solution(n, m, arr, range);
        for(int sum : answer) {
            System.out.println(sum);
        }
    }
}
