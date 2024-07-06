import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Problem23882 {
    private static int count;

    public static String solution(int n, int k, int[] arr) {
        StringBuilder answer = new StringBuilder();
        count = k;

        selectionSort(n, arr);

        if(count > 0) {
            return String.valueOf(-1);
        }

        for(int num : arr) {
            answer.append(num).append(" ");
        }
        
        return answer.toString();
    }

    private static void selectionSort(int n, int[] elements) {
        for(int i = n - 1; i > 0; i--) {
            int last = i;

            for(int j = i - 1; j >= 0; j--) {
                if(elements[last] < elements[j]) {
                    last = j;
                }
            }

            if(last != i) {                
                swap(elements, last, i);

                count--;
                if(count == 0) {
                    break;
                }
            }
        }
    }

    private static void swap(int[] elements, int index1, int index2) {
        int temp = elements[index1];
        elements[index1] = elements[index2];
        elements[index2] = temp;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st1.nextToken());
        int k = Integer.parseInt(st1.nextToken());
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st2.nextToken());
        }
        
        bw.write(solution(n, k, arr));
        bw.flush();
        bw.close();
    }
}
