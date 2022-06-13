import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public int[] solution(int n, int[] arr) {
        for(int i = 0; i < n; i++) {
            int minIdx = i;

            for(int j = i; j < n; j++)
                if(arr[j] < arr[minIdx])
                    minIdx = j;

            int tmp = arr[i];
            arr[i] = arr[minIdx];
            arr[minIdx] = tmp;
        }

        return arr;
    }

    public int[] alternativeSolution(int n, int[] arr) {
        for(int i = 0; i< n - 1; i++) {
            int idx = i;

            for(int j = 0; j < n; j++)
                if(arr[j] < arr[idx]) idx = j;

            int tmp = arr[i];
            arr[i] = arr[idx];
            arr[idx] = tmp;
        }

        return arr;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());

        for(int i : T.solution(n, arr)) System.out.print(i + " ");
    }
}
