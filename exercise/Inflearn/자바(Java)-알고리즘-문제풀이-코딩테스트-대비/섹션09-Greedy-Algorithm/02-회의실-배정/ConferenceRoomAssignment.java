import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public int solution(int n, int[][] arr) {
        int answer = 0;

        Arrays.sort(arr, (o1, o2) -> {
            if(o1[1] < o2[1]) return -1;
            else if(o1[1] > o2[1]) return 1;
            else {
                if(o1[0] < o2[0]) return -1;
                else return 1;
            }
        });

        int time = 0;

        for(int[] x : arr) {
            System.out.println(x[0] + ":" + x[1]);
            if(time <= x[0]) {
                answer++;
                time = x[1];
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int arr[][] = new int[n][2];
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        System.out.println(T.solution(n, arr));
    }
}
