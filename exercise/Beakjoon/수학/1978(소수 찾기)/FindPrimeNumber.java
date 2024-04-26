import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    public int solution(int[] arr) {
        int answer = 0;
        Arrays.sort(arr);
        int size = arr[arr.length - 1];
        int[] check = new int[size + 1];
        int idx = 0;

        if(arr[0] == 1) idx++;
        for(int i = 2; i <= size; i++){
            if(check[i] == 0) {
                if(i == arr[idx]) answer++;
                for(int j = i; j <= size; j += i) check[j] = 1;
            }
            if(i == arr[idx]) idx++;
        }

        return answer;
    }


    public static void main(String[] args) throws IOException {
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());
        br.close();

        System.out.println(main.solution(arr));
    }
}