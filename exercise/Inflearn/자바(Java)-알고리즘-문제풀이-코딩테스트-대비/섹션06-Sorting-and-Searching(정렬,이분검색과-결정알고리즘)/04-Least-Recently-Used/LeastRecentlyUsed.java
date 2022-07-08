import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public int[] solution(int s, int n, int[] arr) {
        int[] answer = new int[s];

        for(int o = 0; o < n; o++) {
            boolean notInCache = true;

            for(int t = 0; t < s; t++) {
                if(answer[t] == 0) break;
                if(answer[t] == arr[o]) {
                    notInCache = false;

                    for(int i = t; i > 0; i--) {
                        int tmp = answer[i - 1];
                        answer[i - 1] = answer[i];
                        answer[i] = tmp;
                    }

                    break;
                }
            }

            if(notInCache) {
                for(int i = s - 1; i > 0; i--) answer[i] = answer[i - 1];
                answer[0] = arr[o];
            }
        }

        return answer;
    }

    public int[] alternativeSolution(int size, int n, int[] arr) {
        int[] cache = new int[size];

        for(int x : arr) {
            int pos = -1;

            for(int i = 0; i < size; i++) if(x == cache[i]) pos = i;
            if(pos == -1) {
                for(int i = size - 1; i >= 1; i--) {
                    cache[i] = cache[i - 1];
                }
            } else {
                for(int i = pos; i >= 1; i--) {
                    cache[i] = cache[i - 1];
                }
            }
            cache[0] = x;
        }

        return cache;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st1.nextToken());
        int n = Integer.parseInt(st1.nextToken());
        int[] arr = new int[n];
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) arr[i] = Integer.parseInt(st2.nextToken());

        for(int i : T.solution(s, n, arr)) System.out.print(i + " ");
    }
}
