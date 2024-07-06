import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem2490 {
    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] nums = new int[3];

        for(int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int j = 0; j < 4; j++) {
                nums[i] += Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < 3; i++) {
            if(nums[i] == 4)
                System.out.println("E");
            else if(nums[i] == 3)
                System.out.println("A");
            else if(nums[i] == 2)
                System.out.println("B");
            else if(nums[i] == 1)
                System.out.println("C");
            else if(nums[i] == 0)
                System.out.println("D");
        }
    }

    public static void main(String[] args) throws IOException {
        Problem2490.solution();
    }
}
