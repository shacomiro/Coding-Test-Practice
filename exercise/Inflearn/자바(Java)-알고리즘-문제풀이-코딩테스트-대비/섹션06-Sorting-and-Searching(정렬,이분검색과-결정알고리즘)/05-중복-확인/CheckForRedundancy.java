import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    //해시맵 등의 자료형을 활용하여 중복값을 점검하는 방식으로 O(n) 시간복잡도 안으로 해결하는 것도 가능하나
    //여기서는 O(nlogn)의 시간복잡도를 가지는 정렬 방식으로 풀이함.
    
    public String solution(int n, int[] arr) {
        String answer = "U";

        Arrays.sort(arr);
        for(int i = 0; i < n - 1; i++) {
            if(arr[i] == arr[i + 1]) {
                answer = "D";
                break;
            }
        }

        return answer;
    }

    public String alternativeSolution(int n, int[] arr) {
        String answer = "U";
        
        Arrays.sort(arr);
        for(int i = 0; i < n - 1; i++) {
            if(arr[i] == arr[i + 1]) return "D";
        }
        
        return answer;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());

        System.out.println(T.solution(n, arr));
    }
}
