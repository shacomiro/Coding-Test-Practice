import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public int[] solution(int n) {
        int[] answer = new int[n];
        answer[0] = 1;
        answer[1] = 1;

        getFibonacci(answer[0], answer[1], 2, answer);

        return answer;
    }

    public void getFibonacci(int a, int b, int idx, int[] arr) {
        if(idx < arr.length) {
            arr[idx] = a + b;
            getFibonacci(b, arr[idx], idx + 1, arr);
        }
    }

    //피보나치를 구할 때 재귀만 이용하는 것보다는 배열이나 for(반복문)을 통해서 구하는 것이 성능이 더 좋다.
    //-> 재귀는 스택 프레임이 계속 쌓이기 때문에 메모리가 많이 필요하고, 무거워서 성능이 나쁘다.
    public int DFS(int n) {
        if(n == 1) return 1;
        else if(n == 2) return 1;
        else return DFS(n - 2) + DFS(n - 1);
    }

    //중복값을 계산하지 않고 결과값을 '기억'해두어 낭비를 최소화하는 방법.
    static int[] fibo;

    public int imporoveDFS(int n) {
        if(n == 1) return fibo[n] = 1;
        else if(n == 2) return fibo[n] = 1;
        else return fibo[n] = imporoveDFS(n - 2) + imporoveDFS(n - 1);
    }

    public int memoizationDFS(int n) {
        // 기억하는 값을 바로 출력(메모이제이션) => 하지만 재귀는 여전히 for문보다 느리다.
        // (복귀주소, 메모리, 스택 등 사용량이 매우 많음. 반복문이라면 반복문 자체의 정보만 가지고 있으면 충분)
        if(fibo[n] > 0) return fibo[n];

        if(n == 1) return fibo[n] = 1;
        else if(n == 2) return fibo[n] = 1;
        else return fibo[n] = memoizationDFS(n - 2) + memoizationDFS(n - 1);
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for(int i : T.solution(n)) System.out.print(i + " ");
        System.out.println();
//        for(int i = 1; i <= n; i++) System.out.print(T.DFS(i) + " ");
//        System.out.println();
        fibo = new int[n + 1];
        T.memoizationDFS(n);
        for(int i = 1; i <= n; i++) System.out.print(fibo[i] + " ");
    }
}
