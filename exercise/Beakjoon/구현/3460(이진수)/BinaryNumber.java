import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class BinaryNumber {
    public String[] solution(int n, int[] arr) {
        String[] answer = new String[n];

        for(int i = 0; i < n; i++) {
            int num = arr[i];
            int cnt = 0;
            StringBuilder sb = new StringBuilder();

            while(num > 0) {
                if(num % 2 != 0)  sb.append(cnt).append(" ");

                num /= 2;
                cnt++;
            }

            answer[i] = sb.toString();
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BinaryNumber main = new BinaryNumber();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for(int i = 0; i < n; i++) arr[i] = Integer.parseInt(br.readLine());

        for(String s : main.solution(n, arr)) System.out.println(s);
    }
}