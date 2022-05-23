import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public int solution(int n, int k, int[] arr) {
        int answer = 0;
        int cnt = 0;
        int lt = 0;

        for(int rt = 0; rt < n; rt++) {
            if(arr[rt] == 0) cnt++;

            if(cnt > k) {
                answer = Math.max(answer, rt - lt);

                while(arr[lt] == 1) lt++;
                cnt--;
                lt++;
            }
        }

        return answer;
    }
    // 풀이 실패. => 강의 시청 후 재풀이 후 성공. 복잡하게 생각해서 문제가 생겼음.
    // rt의 이동 후 조건 성립시 lt를 조건 탈출시까지 변경해야 함.
    // 굳이 직접 배열의 값을 변경할 필요가 없음! -> 0의 위치로 lt가 멈춰야 할 지점을 판단해야 하기 때문.

    public int alternativeSolution(int n, int k, int[] arr) {
        int answer = 0;
        int cnt = 0;
        int lt = 0;

        for(int rt = 0; rt < n; rt++) {
            if(arr[rt] == 0) cnt++;

            while(cnt > k) {
                if(arr[lt] == 0) cnt--;
                lt++;
            }

            answer = Math.max(answer, rt - lt + 1);
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st1.nextToken());
        int k = Integer.parseInt(st1.nextToken());
        int[] arr = new int[n];
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) arr[i] = Integer.parseInt(st2.nextToken());

        System.out.println(T.solution(n, k, arr));
    }
}
