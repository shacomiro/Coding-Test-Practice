import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public int solution(int n, int m, int[] arr) {
        int answer = 0;
        int size = 0;
        int remainDisk = m;
        int idx = 0;
        int sum = 0;

        while(idx < n) {
            if(size < sum + arr[idx]) {
                sum = 0;

                if(remainDisk <= 1) {
                    size += 1;
                    remainDisk = m;
                    idx = 0;
                } else remainDisk--;
            } else sum += arr[idx++];
        }

        answer = size;

        return answer;
    }

    // 결정 알고리즘은 lt~rt 범위 내의 요소들에서 찾으려는 값이 확실히 있는 경우에만 사용 가능.
    // rt-lt = mid, mid번째 값이 정답인가를 체크하며 이분검색.
    // 이 문제의 경우, 가능한 모든 용량의 조합을 가리키는 배열을 만들거나, 범위를 직접 lt,rt에 지정해고, 이 범위에서 lt,rt를 활용해 이분검색을 진행하면 된다.
    public int alternativeSolution(int n, int m, int[] arr) {
        int answer = 0;
        int lt = Arrays.stream(arr).max().getAsInt();
        int rt = Arrays.stream(arr).sum();

        while(lt <= rt) {
            int mid = (lt + rt) / 2;

            if(count(arr, mid) <= m) {
                answer = mid;
                rt = mid - 1;
            } else lt = mid + 1;
        }

        return answer;
    }

    public int count(int[] arr, int capacity) {
        int cnt = 1;
        int sum = 0;

        for(int x : arr) {
            if(sum + x > capacity) {
                cnt++;
                sum = x;
            } else sum += x;
        }

        return cnt;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st1.nextToken());
        int m = Integer.parseInt(st1.nextToken());
        int[] arr = new int[n];
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) arr[i] = Integer.parseInt(st2.nextToken());

        System.out.println(T.solution(n, m, arr));
    }
}
