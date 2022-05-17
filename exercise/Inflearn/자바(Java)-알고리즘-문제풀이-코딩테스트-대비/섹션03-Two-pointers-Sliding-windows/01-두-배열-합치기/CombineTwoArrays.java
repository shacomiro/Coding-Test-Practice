import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public int[] solution(int n, int[] arr1, int m, int[] arr2) {
        int[] answer = new int[n + m];

        int idx = 0;
        int pt1 = 0;
        int pt2 = 0;

        while(pt1 < n || pt2 < m) {
            if(pt1 == n) {
                answer[idx++] = arr2[pt2++];
                continue;
            } else if(pt2 == m) {
                answer[idx++] = arr1[pt1++];
                continue;
            }

            if(arr1[pt1] <= arr2[pt2]) {
                answer[idx++] = arr1[pt1++];
            } else if(arr1[pt1] > arr2[pt2]) {
                answer[idx++] = arr2[pt2++];
            }
        }

        return answer;
    }

    public ArrayList<Integer> alternativeSolution(int n, int[] arr1, int m, int[] arr2) {
        ArrayList<Integer> answer = new ArrayList<>();
        int p1 = 0;
        int p2 = 0;

        while(p1 < n && p2 < m) {
            if(arr1[p1] < arr2[p2]) answer.add(arr1[p1++]);
            else answer.add(arr2[p2++]);
        }

        while(p1 < n) answer.add(arr1[p1++]);
        while(p2 < m) answer.add(arr2[p2++]);

        return answer;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr1 = new int[n];
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr1[i] = Integer.parseInt(st1.nextToken());
        }
        int m = Integer.parseInt(br.readLine());
        int[] arr2 = new int[m];
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++) {
            arr2[i] = Integer.parseInt(st2.nextToken());
        }

        for(int num : T.alternativeSolution(n, arr1, m, arr2)) {
            System.out.print(num + " ");
        }
    }
}
