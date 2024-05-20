import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class FibonacciNumber {
    public int solution(int n) {
        int[] numbers = new int[n + 1];

        return getFibonacci(n, numbers);
    }

    public int getFibonacci(int n, int[] numbers) {
        if(numbers[n] != 0) return numbers[n];

        if(n == 0) numbers[n] = 0;
        else if(n == 1 || n == 2) numbers[n] = 1;
        else numbers[n] = getFibonacci(n - 2, numbers) + getFibonacci(n - 1, numbers);

        return numbers[n];
    }

    public static void main(String[] args) throws IOException {
        FibonacciNumber main = new FibonacciNumber();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        br.close();

        System.out.println(main.solution(n));
    }
}