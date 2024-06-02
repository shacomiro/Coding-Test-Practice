import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem23899 {
    private static int equalCount;
    private static int[] targetArr;
    private static boolean isEqual;

    public static String solution(int n, int[] arr1, int[] arr2, int count) {
        targetArr = arr2;
        equalCount = count;

        if(equalCount == n) {
            return "1";
        }

        selectionSort(n, arr1);

        return isEqual ? "1" : "0";
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

                if(Arrays.equals(elements, targetArr)) {
                    isEqual = true;
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

        int n = Integer.parseInt(br.readLine());
        int[] arr1 = new int[n];
        int[] arr2 = new int[n];
        int count = 0;
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr1[i] = Integer.parseInt(st1.nextToken());
            arr2[i] = Integer.parseInt(st2.nextToken());
            
            if(arr1[i] == arr2[i]) {
                count++;
            }
        }

        bw.write(solution(n, arr1, arr2, count));
        bw.flush();
        bw.close();
    }
}