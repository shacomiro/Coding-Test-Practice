import java.util.Arrays;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        int ai = 0;
        int bi = 0;
        
        Arrays.sort(A);
        Arrays.sort(B);
        
        while(bi < B.length) {
            int num = B[bi];
            
            if(A[ai] < num) {
                answer++;
                ai++;
            }
            
            bi++;
        }
        
        return answer;
    }
}
//+6, 30min