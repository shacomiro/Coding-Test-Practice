import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Problem2470 {
    public static String solution(int n, int[] liquids) {
        Arrays.sort(liquids);
        List<Integer> result = twoPointerSearch(n, liquids);

        return String.valueOf(result.get(0) + " " + result.get(1));
    }

    private static List<Integer> twoPointerSearch(int n, int[] elements) {
        int absoluteMin = Integer.MAX_VALUE;
        int lowElement = -1000000000;
        int highElement = 1000000000;

        int lt = 0;
        int rt = n - 1;
        while(lt < rt) {
            int temp = elements[lt] + elements[rt];
            int AbsTemp = Math.abs(temp);

            if(AbsTemp < absoluteMin) {
                absoluteMin = AbsTemp;
                lowElement = elements[lt];
                highElement = elements[rt];

                if(absoluteMin == 0) {
                    break;
                }
            }

            if(temp > 0) {
                rt--;
            } else if(temp < 0) {
                lt++;
            }
        }

        return List.of(lowElement, highElement);
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        bw.write(solution(n, arr));
        bw.flush();
        bw.close();
    }
}
