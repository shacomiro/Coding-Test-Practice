import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public int solution(int n, int m, int[][] arr) {
        int answer = 0;

        for(int mento = 1; mento <= n; mento++) {
            for(int menti = 1; menti <= n; menti++) {
                if(mento == menti) continue;
                boolean isCanMentor = true;

                checkMentor:
                for(int i = 0; i < m; i++) {
                    for(int j = 0; j < n; j++) {
                        for(int k = 0; k < n; k++) {
                            if(arr[i][j] == mento && arr[i][k] == menti && j > k) {
                                isCanMentor = false;
                                break checkMentor;
                            }
                        }
                    }
                }

                if(isCanMentor) answer++;
            }
        }

        return answer;
    }

    public int alternativeSolutionOne(int n, int m, int[][] arr) {
        int answer = 0;

        for(int i = 0; i <= n; i++) {
            for(int j = 0; j <= n; j++) {
                if(i == j) continue;

                boolean isPossibleMentor = true;
                int pi = 0;
                int pj = 0;

                for(int k = 0; k < m; k++) {
                    for(int s = 0; s < n; s++) {
                        if(arr[k][s] == i) pi = s;
                        if(arr[k][s] == j) pj = s;
                    }

                    if(pi > pj) {
                        isPossibleMentor = false;
                        break;
                    }
                }

                if(isPossibleMentor) answer++;
            }
        }

        return answer;
    }

    public int alternativeSolutionTwo(int n, int m, int[][] arr) {
        int answer = 0;

        for(int i = 0; i <= n; i++) {
            for(int j = 0; j <= n; j++) {
                if(i == j) continue;

                int cnt = 0;
                int pi = 0;
                int pj = 0;

                for(int k = 0; k < m; k++) {
                    for(int s = 0; s < n; s++) {
                        if(arr[k][s] == i) pi = s;
                        if(arr[k][s] == j) pj = s;
                    }

                    if(pi < pj) cnt++;
                }

                if(cnt == m) answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st1.nextToken());
        int m = Integer.parseInt(st1.nextToken());
        int[][] arr = new int[m][n];

        for(int i = 0; i < m; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());

            for(int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st2.nextToken());
            }
        }

        System.out.println(T.solution(n, m, arr));
    }
}
