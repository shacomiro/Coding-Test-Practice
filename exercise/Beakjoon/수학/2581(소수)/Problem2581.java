import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Problem2581 {
    public ArrayList<Integer> solution(int m, int n) {
        ArrayList<Integer> answer = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        int sum = 0;
        int[] check = new int[n + 1];

        for(int i = 2; i <= n; i++) {
            if(check[i] == 0) {
                if(m <= i) {
                    min = Math.min(min, i);
                    sum += i;
                }
                for(int j = i; j <= n; j += i) check[j] = 1;
            }
        }

        if(sum > 0) {
            answer.add(sum);
            answer.add(min);
        } else {
            answer.add(-1);
        }

        return answer;
    }


    public static void main(String[] args) throws IOException {
        Problem2581 main = new Problem2581();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        br.close();

        for(int x : main.solution(m, n)) System.out.println(x);
    }
}