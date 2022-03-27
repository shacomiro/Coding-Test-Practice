class Solution {
    int solution(int[][] land) {
        int maxPoint = 0;
        int[] cumulativePoints = new int[4];
        int[] expectedPoints = new int[4];
        int currentLine = 0;
        
        for(int i = 0; i < land[0].length; i++) {
            cumulativePoints[i] = land[0][i];
            expectedPoints[i] = land[0][i];
        }
        
        for(int n = 1; n < land.length; n++) {
            currentLine = currentLine % 4;
            
            for(int i = 0; i < 4; i++) {
                int maxValue = 0;
                
                for(int j = 0; j < 4; j++)
                    if(i != j && maxValue < cumulativePoints[j])
                        maxValue = cumulativePoints[j];
                    
                expectedPoints[i] = land[n][i] + maxValue;
            }
            
            for(int k = 0; k < 4; k++)
                cumulativePoints[k] = expectedPoints[k];
            
            currentLine++;
        }
        
        for(int k = 0; k < 4; k++)
            maxPoint = Math.max(maxPoint, cumulativePoints[k]);
        
        return maxPoint;
    }
}