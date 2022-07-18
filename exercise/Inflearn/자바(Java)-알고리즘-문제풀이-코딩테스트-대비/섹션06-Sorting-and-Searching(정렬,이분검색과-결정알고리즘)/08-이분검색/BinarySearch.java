import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public int solution(int n, int m, int[] arr) {
        int answer = 0;
        int pivot = n / 2;
        int lt = 0;
        int rt = n - 1;

        Arrays.sort(arr);

        while(lt <= rt) {
            if(arr[pivot] < m) {
                lt = pivot + 1;
                pivot = (lt + rt) / 2;
            } else if(m < arr[pivot]) {
                rt = pivot;
                pivot = (lt + rt) / 2;
            } else {
                answer = pivot + 1;
                break;
            }
        }

        return answer;
    }

    public int alternativeSolution(int n, int m, int[] arr) {
        int answer = 0;
        Arrays.sort(arr);
        int lt = 0;
        int rt = n - 1;

        while(lt <= rt) {
            int mid = (lt + rt) / 2;

            if(arr[mid] == m) {
                answer = mid + 1;
                break;
            } else if(arr[mid] > m) {
                rt = mid - 1;
            } else {
                lt = mid + 1;
            }
        }

        return answer;
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
