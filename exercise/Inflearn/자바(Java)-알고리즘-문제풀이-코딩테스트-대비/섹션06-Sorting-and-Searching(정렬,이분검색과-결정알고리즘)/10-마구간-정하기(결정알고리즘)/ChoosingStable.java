import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public int solution(int n, int m, int[] arr) {
        int answer = 0;

        Arrays.sort(arr);
        int lt = arr[0];
        int rt = arr[n - 1];
        int idx = 0;

        while(lt <= rt) {
            int mid = (lt + rt) / 2;
          
            if(count(arr, mid) >= m) {
                answer = mid;
                lt = mid + 1;
            } else rt = mid - 1;
        }

        return answer;
    }

    public int count(int[] arr, int distance) {
        int cnt = 1;

        int lt = 0;
        for(int rt = 1; rt < arr.length; rt++) {
            if(arr[rt] - arr[lt] >= distance) {
                cnt++;
                lt = rt;
            }
        }

        return cnt;
    }

    public int alternativeSolution(int n, int c, int[] arr) {
        int answer = 0;

        Arrays.sort(arr);
        int lt = 1;
        int rt = arr[n - 1];

        while(lt <= rt) {
            int mid = (lt + rt) / 2;

            if(alternativeCount(arr, mid) >= c) {
                answer = mid;
                lt = mid + 1;
            } else rt = mid - 1;
        }

        return answer;
    }

    public int alternativeCount(int[] arr, int dist) {
        int cnt = 1;
        int ep = arr[0];

        for(int i = 1; i < arr.length; i++) {
            if(arr[i] - ep >= dist) {
                cnt++;
                ep = arr[i];
            }
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
