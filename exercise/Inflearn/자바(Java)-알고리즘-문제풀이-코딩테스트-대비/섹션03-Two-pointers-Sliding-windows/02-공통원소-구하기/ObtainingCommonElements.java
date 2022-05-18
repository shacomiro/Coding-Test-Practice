import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public ArrayList<Integer> solution(int n, int m, int[] arr1, int[] arr2) {
        ArrayList<Integer> answer = new ArrayList<>();

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        for(int pt1 = 0; pt1 < n; pt1++) {
            for(int pt2 = 0; pt2 < m; pt2++) {
                if(arr1[pt1] < arr2[pt2]) break;
                else if(arr1[pt1] == arr2[pt2]) {
                    answer.add(arr1[pt1]);

                    break;
                }
            }
        }

        return answer;
    }
    //시간 초과 위기를 겪음.

    public ArrayList<Integer> alternativeSolution(int n, int m, int[] arr1, int[] arr2) {
        ArrayList<Integer> answer = new ArrayList<>();
        int pt1 = 0;
        int pt2 = 0;

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        while(pt1 < n && pt2 < m) {
            if(arr1[pt1] == arr2[pt2]) {
                answer.add(arr1[pt1]);
                pt1++;
                pt2++;
            } else if(arr1[pt1] < arr2[pt2]) {
                pt1++;
            } else {
                pt2++;
            }
        }

        return answer;
    }
    //두 배열을 오름차순 정렬한 후, 포인터들끼리 비교했을 때 같지 않으면서 작은 숫자인 경우는 더이상 교집합일 수 없으므로 해당 포인터를 증가시키면서 진행한다.

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

        for(int num : T.solution(n, m, arr1, arr2)) {
            System.out.print(num + " ");
        }
    }
}
