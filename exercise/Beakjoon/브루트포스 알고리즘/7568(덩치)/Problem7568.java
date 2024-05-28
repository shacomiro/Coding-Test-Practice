import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Problem7568 {
    public static String solution(short[][] people, short size) {
        StringBuilder answer = new StringBuilder();

        for(short i = 0; i < size; i++) {
            int rank = 1;

            for(short j = 0; j < size; j++) {
                if(i == j) {
                    continue;
                }

                if(people[i][0] < people[j][0] && people[i][1] < people[j][1]) {
                    rank++;
                }
            }

            answer.append(rank).append(" ");
        }
        
        return answer.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        short n = Short.parseShort(br.readLine());
        short[][] people = new short[n][2];
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            people[i][0] = Short.parseShort(st.nextToken());
            people[i][1] = Short.parseShort(st.nextToken());
        }

        bw.write(solution(people, n));
        bw.flush();
        bw.close();
        
    }
}
