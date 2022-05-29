import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
    public int solution(int n, int k, int[] arr) {
        int answer = -1;
        TreeSet<Integer> set = new TreeSet<>();
        int cnt = 0;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(i == j) continue;
                for(int l = 0; l < n; l++) {
                    if(i == l || j == l) continue;

                    set.add(arr[i] + arr[j] + arr[l]);
                }
            }
        }

        while(!set.isEmpty()) {
            int value = set.pollLast();
            cnt++;
            if(cnt == k) answer = value;
        }

        return answer;
    }

    public int alternativeSolution(int n, int k, int[] arr) {
        int answer = -1;
        TreeSet<Integer> tSet = new TreeSet<>(Collections.reverseOrder());

        for(int i = 0; i < n; i++)
            for(int j = i + 1; j < n; j++)
                for(int l = j + 1; l < n; l++)
                    tSet.add(arr[i] + arr[j] + arr[l]);

        int cnt = 0;

        for(int x : tSet) {
            cnt++;
            if(cnt == k) return x;
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
