import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public ArrayList<Integer> solution(int n, int[] naturalNumbers) {
        ArrayList<Integer> answer = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            int reverseNum = Integer.parseInt(String.valueOf(new StringBuffer(String.valueOf(naturalNumbers[i])).reverse()));
            if(reverseNum == 1) continue;

            boolean isPrime = true;

            for(int j = 2; j <= Math.sqrt(reverseNum); j++) {
                if (reverseNum % j == 0) {
                    isPrime = false;
                    break;
                }
            }

            if(isPrime) answer.add(reverseNum);
        }

        return answer;
    }

    public ArrayList<Integer> alternativeSolution(int n, int[] arr) {
        ArrayList<Integer> answer = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            int temp = arr[i];
            int reverse = 0;

            while(temp > 0) {
                int t = temp % 10;

                reverse = reverse * 10 + t;
                temp = temp / 10;
            }

            if(isPrime(reverse)) answer.add(reverse);
        }

        return answer;
    }

    public boolean isPrime(int num) {
        if(num == 1) return false;

        for(int i = 2; i < num; i++) {
            if(num % i == 0) return false;
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] naturalNumbers = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            naturalNumbers[i] = Integer.parseInt(st.nextToken());
        }

        for(int i : T.alternativeSolution(n, naturalNumbers)) System.out.print(i + " ");
    }
}
