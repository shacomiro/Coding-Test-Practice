import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    public int solution(int begin, int end) {
        int answer = 0;
        int n = 0;
        int i = 1;

        while(n <= end) {
            for(int j = 0; j < i; j++) {
                n++;
                if(begin <= n && n <= end) answer += i;
            }

            i++;
        }

        return answer;
    }


    public static void main(String[] args) throws IOException {
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int begin = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        br.close();

        System.out.println(main.solution(begin, end));
    }
}