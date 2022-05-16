import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public int solution(int n, int[][] arr) {
        int answer = 1;
        int num = 0;
        int[][] isSameClass = new int[n][n];

        for(int grade = 0; grade < 5; grade++) {
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    if(isSameClass[i][j] == 1) continue;
                    if(i != j && arr[i][grade] == arr[j][grade]) {
                        isSameClass[i][j] = 1;
                        isSameClass[j][i] = 1;
                    }
                }

                int sum = 0;
                for(int j = 0; j < n; j++) sum += isSameClass[i][j];

                if(sum > num) {
                    num = sum;
                    answer = i + 1;
                }
            }
        }

        return answer;
    }

    public int alternativeSolution(int n, int[][] arr) {
        int answer = 0;
        int max = 0;

        for(int i = 0; i < n; i++) {
            int cnt = 0;

            for(int j = 0; j < n; j++) {
                for(int grade = 0; grade < 5; grade++) {
                    if(i != j && arr[i][grade] == arr[j][grade]) {
                        cnt++;
                        break;
                    }
                }
            }

            if(cnt > max) {
                max = cnt;
                answer = i;
            }
        }

        return answer + 1;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][5];

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int j = 0; j < 5; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(T.solution(n, arr));
    }
}
