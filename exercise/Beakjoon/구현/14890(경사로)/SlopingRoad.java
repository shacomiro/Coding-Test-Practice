import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SlopingRoad {
    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][N];
        for(int i = 0; i < N; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());

            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st2.nextToken());
            }
        }
        ArrayList<String> horizontalSlope = new ArrayList<>();
        ArrayList<String> verticalSlope = new ArrayList<>();

        int route = 0;

        for(int line = 0; line < N; line++) {

            horizontal:
            for(int i = 0; i < N; i++) {
                if(map[line][i] == -1) continue;

                int currHeight = map[line][i];
                int nextHeight;
                if(i+1 < N) {
                    nextHeight = map[line][i+1];
                } else {
                    route++;
                    break;
                }

                int gap = currHeight - nextHeight;
                if(gap == 0) {
                    continue;
                } else if(gap == 1) {
                    for(int j = i+1; j <= i+L; j++) {
                        if(j > N - 1 || map[line][j] != nextHeight || horizontalSlope.contains(""+line+j)) break horizontal;
                        horizontalSlope.add(""+line+j);
                    }
                } else if(gap == -1) {
                    for(int j = i+1-L; j <= i; j++) {
                        if(j < 0 || map[line][j] != currHeight || horizontalSlope.contains(""+line+j)) break horizontal;
                        horizontalSlope.add(""+line+j);
                    }
                } else {
                    break;
                }
            }
            horizontalSlope.clear();

            vertical:
            for(int i = 0; i < N; i++) {
                if(map[line][i] == -1) continue;

                int currHeight = map[i][line];
                int nextHeight;
                if(i+1 < N) {
                    nextHeight = map[i+1][line];
                } else {
                    route++;
                    break;
                }

                int gap = currHeight - nextHeight;
                if(gap == 0) {
                    continue;
                } else if(gap == 1) {
                    for(int j = i+1; j <= i+L; j++) {
                        if(j > N - 1 || map[j][line] != nextHeight || verticalSlope.contains(""+j+line)) break vertical;
                        verticalSlope.add(""+j+line);
                    }
                } else if(gap == -1) {
                    for(int j = i+1-L; j <= i; j++) {
                        if(j < 0 || map[j][line] != currHeight || verticalSlope.contains(""+j+line)) break vertical;
                        verticalSlope.add(""+j+line);
                    }
                } else {
                    break;
                }
            }
            verticalSlope.clear();
        }

        System.out.println(route);
    }

    public static void main(String[] args) throws IOException {
        SlopingRoad.solution();
    }
}
