class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];        
        
        for(int x = 0; x < answer.length; x++) {            
            for(int y = 0; y < answer[x].length; y++) {
                int a = 0;
                int b = 0;
                
                while(a < arr1[0].length && b < arr2.length) {
                    answer[x][y] += arr1[x][a++] * arr2[b++][y];
                }
            }    
        }
        
        return answer;
    }
}
//+5