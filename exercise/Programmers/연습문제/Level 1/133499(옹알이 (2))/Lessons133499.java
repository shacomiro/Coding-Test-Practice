import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Lessons133499 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String[] arr = new String[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = st.nextToken();
        }

        bw.write(String.valueOf(new Solution().solution(arr)));
        bw.flush();
        bw.close();
    }

    static class Solution {
        private static final String[] PRONUNCIATIONS = { "aya", "ye", "woo", "ma" };

        public int solution(String[] babbling) {
            int answer = 0;

            for (int i = 0; i < babbling.length; i++) {
                String b = babbling[i];

                // 연속된 같은 발음이 있는지 필터링
                if (b.contains(PRONUNCIATIONS[0].repeat(2)) || b.contains(PRONUNCIATIONS[1].repeat(2)) || b.contains(PRONUNCIATIONS[2].repeat(2)) || b.contains(PRONUNCIATIONS[3].repeat(2))) {
                    continue;
                }

                // 발음할 수 있는 단어를 공백으로 치환
                b = b.replace(PRONUNCIATIONS[0], " ");
                b = b.replace(PRONUNCIATIONS[1], " ");
                b = b.replace(PRONUNCIATIONS[2], " ");
                b = b.replace(PRONUNCIATIONS[3], " ");

                // 남은 공백을 모두 제거
                b = b.replace(" ", "");

                // 문자열이 비어있다면 모두 발음할 수 있는 단어
                if (b.length() == 0) {
                    answer++;
                }
            }

            return answer;
        }
    }
}
