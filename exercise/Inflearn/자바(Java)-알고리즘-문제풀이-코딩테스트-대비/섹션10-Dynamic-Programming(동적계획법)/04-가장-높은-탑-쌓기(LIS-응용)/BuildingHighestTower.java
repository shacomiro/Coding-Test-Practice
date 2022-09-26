import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Brick implements Comparable<Brick> {
    public int s;
    public int h;
    public int w;

    public Brick(int s, int h, int w) {
        this.s = s;
        this.h = h;
        this.w = w;
    }

    @Override
    public int compareTo(Brick o) {
        return o.s - this.s;
    }
}

public class Main {
    static int[] dy;

    public int solution(ArrayList<Brick> arr) {
        int answer = 0;
        Collections.sort(arr);
        dy[0] = arr.get(0).h;
        answer = dy[0];

        for(int i = 1; i < arr.size(); i++) {
            int maxH = 0;

            for(int j = i - 1; 0 <= j; j--) {
                if(arr.get(j).w > arr.get(i).w && dy[j] > maxH) maxH = dy[j];
            }
            dy[i] = maxH + arr.get(i).h;

            answer = Math.max(answer, dy[i]);
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dy = new int[n];
        ArrayList<Brick> arr = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            arr.add(new Brick(s, h, w));
        }

        System.out.println(T.solution(arr));
    }
}