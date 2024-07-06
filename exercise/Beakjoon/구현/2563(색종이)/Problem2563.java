import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem2563 {
    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] drawingPaper = new int[100][100];
        int result = 0;

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());
            int endX = startX + 10;
            int endY = startY + 10;

            for(int y = startY; y < endY; y++) {
                for(int x = startX; x < endX; x++) {
                    if(drawingPaper[y][x] == 1)
                        continue;

                    drawingPaper[y][x] = 1;
                    result++;
                }
            }
        }

        System.out.println(result);
    }

    public static void main(String[] args) throws IOException {
        Problem2563.solution();
    }
}
