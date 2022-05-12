import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    // 제곱근을 이용한 방법
    public int solution(int n) {
        ArrayList<Integer> primeList = new ArrayList<>();
        boolean isPrime;

        for(int num = 2; num < n; num++) {
            if(!primeList.isEmpty()) {
                isPrime = true;

                for(int prime : primeList) {
                    if(prime > Math.sqrt(num)) break;

                    if(num % prime == 0) {
                        isPrime = false;
                        break;
                    }
                }

                if(isPrime) primeList.add(num);
            } else {
                primeList.add(num);
            }
        }

        return primeList.size();
    }

    //에라토스테네스 체를 이용한 방법
    public int alternativeSolution(int n) {
        int answer = 0;
        int[] check = new int[n + 1];

        for(int i = 2; i <= n; i++) {
            if(check[i] == 0) {
                answer++;

                for(int j = i; j <= n; j = j + i) check[j] = 1;
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        System.out.println(T.alternativeSolution(n));
    }
}
