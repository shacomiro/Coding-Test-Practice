import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Solution17478 {
    private final String[] p = {
        "어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.",
        "\"재귀함수가 뭔가요?\"",
        "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.",
        "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.",
        "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"",
        "\"재귀함수는 자기 자신을 호출하는 함수라네\"",
        "라고 답변하였지."
    };
    private final String underBar = "____";
    private int n;

    public Solution17478(int n) {
        this.n = n;
    }

    public String solve() {
        StringBuilder sb = new StringBuilder();

        sb.append(p[0]).append("\n");
        recursion(sb, 0);

        return sb.toString();
    }

    private void recursion(StringBuilder sb, int depth) {
        write(sb, depth, p[1]);

        if(depth == n) {
            write(sb, depth, p[5]);
        } else {
            for (int i = 2; i <= 4; i++) { 
                write(sb, depth, p[i]);
            }
            recursion(sb, depth + 1);
        }

        write(sb, depth, p[6]);
    }

    private void write(StringBuilder sb, int depth, String paragraph) {
        sb.append(underBar.repeat(depth)).append(paragraph).append("\n");
    }
}

public class Problem17478 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(new Solution17478(Integer.parseInt(br.readLine())).solve());
        bw.flush();
        bw.close();
    }
}
