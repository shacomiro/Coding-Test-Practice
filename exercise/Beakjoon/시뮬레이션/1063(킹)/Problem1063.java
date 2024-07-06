import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem1063 {
    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());

        StringBuilder kingPosition = new StringBuilder(st1.nextToken());
        StringBuilder stonePosition = new StringBuilder(st1.nextToken());
        int[] king = {8 - Character.getNumericValue(kingPosition.charAt(1)), kingPosition.charAt(0) - 65};
        int[] stone = {8 - Character.getNumericValue(stonePosition.charAt(1)), stonePosition.charAt(0) - 65};
        int[] tempKing = {8 - Character.getNumericValue(kingPosition.charAt(1)), kingPosition.charAt(0) - 65};
        int[] tempStone = {8 - Character.getNumericValue(stonePosition.charAt(1)), stonePosition.charAt(0) - 65};
        int moveTime = Integer.parseInt(st1.nextToken());
        String[] moves = new String[moveTime];

        for(int i = 0; i < moveTime; i++)
            moves[i] = br.readLine();

        for(int i = 0; i < moveTime; i++) {
            for(int j = 0; j < moves[i].length(); j++) {
                char move = moves[i].charAt(j);

                switch(move) {
                    case 'R':
                        tempKing[1] += 1;
                        tempStone[1] += 1;
                        break;
                    case 'L':
                        tempKing[1] -= 1;
                        tempStone[1] -= 1;
                        break;
                    case 'T':
                        tempKing[0] -= 1;
                        tempStone[0] -= 1;
                        break;
                    case 'B':
                        tempKing[0] += 1;
                        tempStone[0] += 1;
                        break;
                    default:
                        break;
                }
            }

            if(0 <= tempKing[0] && tempKing[0] <= 7 && 0 <= tempKing[1] && tempKing[1] <= 7) {
                //움직인 킹이 체스판 안에 있다면
                if(tempKing[0] == stone[0] && tempKing[1] == stone[1]) {
                    //움직인 킹이 기존 돌과 겹칠 경우
                    if(0 <= tempStone[0] && tempStone[0] <= 7 && 0 <= tempStone[1] && tempStone[1] <= 7) {
                        //움직일 돌이 체스판 안에 있을 경우
                        //킹과 돌을 모두 이동
                        king[0] = tempKing[0];
                        king[1] = tempKing[1];
                        stone[0] = tempStone[0];
                        stone[1] = tempStone[1];
                    } else {
                        //움직일 돌이 체스판 밖에 있을 경우
                        //킹과 돌 모두 움직이지 않고 대기
                        tempKing[0] = king[0];
                        tempKing[1] = king[1];
                        tempStone[0] = stone[0];
                        tempStone[1] = stone[1];
                    }
                } else {
                    //움직인 킹이 기존 돌과 겹치지 않을 경우
                    //킹은 이동시키고, 돌은 움직이지 않고 대기
                    king[0] = tempKing[0];
                    king[1] = tempKing[1];
                    tempStone[0] = stone[0];
                    tempStone[1] = stone[1];
                }
            } else {
                //움직인 킹이 체스판 밖에 있다면
                //킹과 돌 모두 움직이지 않고 대기
                tempKing[0] = king[0];
                tempKing[1] = king[1];
                tempStone[0] = stone[0];
                tempStone[1] = stone[1];
            }
        }

        System.out.println(String.valueOf((char)(king[1] + 65)) + String.valueOf(8 - king[0]));
        System.out.println(String.valueOf((char)(stone[1] + 65)) + String.valueOf(8 - stone[0]));

        br.close();
    }

    public static void main(String[] args) throws IOException {
        Problem1063.solution();
    }
}
