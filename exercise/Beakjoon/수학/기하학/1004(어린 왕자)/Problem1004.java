import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Solution1004 {
    private int[] start;
    private int[] end;
    private int[][] planetarySystems;

    public Solution1004(int[] start, int[] end, int[][] planetarySystems) {
        this.start = start;
        this.end = end;
        this.planetarySystems = planetarySystems;
    }

    public String solve() {
        int count = 0;

        for(int[] ps : planetarySystems) {
            boolean isStartInSystem = isInPlanetarySystem(ps, start);
            boolean isEndInSystem = isInPlanetarySystem(ps, end);

            if((isStartInSystem && !isEndInSystem) || (!isStartInSystem && isEndInSystem)) {
                count++;
            }
        }

        return String.valueOf(count);
    }

    private boolean isInPlanetarySystem(int[] planetarySystem, int[] point) {
        if(Math.pow(planetarySystem[2], 2) >= Math.pow(planetarySystem[0] - point[0], 2) + Math.pow(planetarySystem[1] - point[1], 2)) {
            return true;
        }

        return false;
    }
}

public class Problem1004 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        for(int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int[] arr1 = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
            int[] arr2 = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
            int n = Integer.parseInt(br.readLine());
            int[][] arr3 = new int[n][3];
            for(int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                arr3[j][0] = Integer.parseInt(st.nextToken());
                arr3[j][1] = Integer.parseInt(st.nextToken());
                arr3[j][2] = Integer.parseInt(st.nextToken());
            }

            bw.write(new Solution1004(arr1, arr2, arr3).solve());
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}
