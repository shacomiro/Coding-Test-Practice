import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;

public class AC {
    public static String solution(String methodsStr, int n, String StrNumbers) {
        char[] methods = methodsStr.toCharArray();
        String[] StrNumbersArr = StrNumbers.substring(1, StrNumbers.length() - 1).split(",");
        Deque<String> deque = new ArrayDeque<>();
        boolean isFlipped = false;

        for(String strNum : StrNumbersArr) {
            if(!strNum.isEmpty()) {
                deque.add(strNum);
            }
        }

        for(char method : methods) {
            switch(method) {
                case 'R':
                    isFlipped = !isFlipped;
                    break;
                case 'D':
                    if(deque.isEmpty()) {
                        return "error";
                    }

                    if(isFlipped) {
                        deque.pollLast();
                    } else {
                        deque.pollFirst();
                    }
                    break;
            }
        }

        return printNumbers(deque, isFlipped);
    }

    public static String printNumbers(Deque<String> deque, boolean isFlipped) {
        StringBuilder sb = new StringBuilder();

        sb.append("[");
        while(!deque.isEmpty()) {
            if(isFlipped) {
                sb.append(deque.pollLast());
            } else {
                sb.append(deque.pollFirst());
            }

            if(!deque.isEmpty()) {
                sb.append(",");
            }
        }
        sb.append("]");

        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        for(int i = 0; i < t; i++) {
            String methodsStr = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String NumbersStr = br.readLine();

            bw.write(String.valueOf(solution(methodsStr, n, NumbersStr)));
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }    
}
