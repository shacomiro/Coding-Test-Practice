import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public int[] solution(int n, int k, int[] arr) {
        int[] answer = new int[n - k + 1];
        HashMap<Integer, Integer> map = new HashMap<>();
        int idx = 0;
        int lt = 0;

        for(int rt = 0; rt < n; rt++) {
            map.put(arr[rt], map.getOrDefault(arr[rt], 0) + 1);

            if(rt - lt == k) {
                map.put(arr[lt], map.get(arr[lt]) - 1);
                if(map.get(arr[lt]) == 0) map.remove(arr[lt]);
                lt++;
            }

            if(rt - lt == k - 1)  answer[idx++] = map.size();
        }

        return answer;
    }

    public ArrayList<Integer> alternativeSolution(int n, int k, int[] arr) {
        ArrayList<Integer> answer = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < k - 1; i++) map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);

        int lt = 0;
        for(int rt = k - 1; rt < n; rt++) {
            map.put(arr[rt], map.getOrDefault(arr[rt], 0) + 1);
            answer.add(map.size());
            map.put(arr[lt], map.get(arr[lt] - 1));

            if(map.get(arr[lt]) == 0) map.remove(arr[lt]);
            lt++;
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

        for(int i : T.solution(n, k, arr)) {
            System.out.print(i + " ");
        }
    }
}
