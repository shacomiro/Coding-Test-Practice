import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public int[] solution(int n, int[] arr) {
        int[] answer = new int[2];
        int[] copyOfArr = arr.clone();
        int idx = 0;

        Arrays.sort(copyOfArr);
        for(int i = 0; i < n; i++)
            if(arr[i] != copyOfArr[i]) answer[idx++] = i + 1;

        return answer;
    }

    public ArrayList<Integer> alternativeSolution(int n, int[] arr) {
        ArrayList<Integer> answer = new ArrayList<>();
        int[] tmp = arr.clone();

        Arrays.sort(tmp);
        for(int i = 0; i < n; i++) {
            if(arr[i] != tmp[i]) answer.add(i + 1);
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

        for(int i : T.solution(n, arr)) System.out.print(i + " ");
    }
}
