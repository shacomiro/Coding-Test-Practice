import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        ArrayList<Stack<Integer>> machine = new ArrayList<>();
        Stack<Integer> basket = new Stack<>();

        for(int i = 0; i < board.length; i++) {
            Stack<Integer> stack = new Stack<>();
            for(int j = board.length - 1; j >= 0; j--) if(board[j][i] != 0) stack.push(board[j][i]);
            machine.add(stack);
        }

        for(int move : moves) {
            if(!machine.get(move - 1).isEmpty()) {
                int topDoll = 0;
                if(!basket.isEmpty()) topDoll = basket.peek();

                if(topDoll == machine.get(move - 1).peek()) {
                    basket.pop();
                    machine.get(move - 1).pop();
                    answer += 2;
                } else basket.push(machine.get(move - 1).pop());
            }
        }

        return answer;
    }

    public int alternativeSolution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();

        for(int pos : moves) {
            for(int i = 0; i < board.length; i++) {
                if(board[i][pos - 1] != 0) {
                    int tmp = board[i][pos - 1];
                    board[i][pos - 1] = 0;

                    if(!stack.isEmpty() && tmp == stack.peek()) {
                        stack.pop();
                        answer += 2;
                    } else stack.push(tmp);

                    break;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] board = new int[n][n];

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) board[i][j] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        int[] moves = new int[m];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++) moves[i] = Integer.parseInt(st.nextToken());

        System.out.println(T.solution(board, moves));
    }
}
