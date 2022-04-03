class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int area = brown + yellow;
        int width =  (int)Math.ceil(Math.sqrt(area));
        int height = 0;
        
        while(width <= area) {
            if(area % width == 0)
                height = area / width;
            
            if((width - 2) * (height - 2) == yellow) 
                break;
            
            width++;
        }
        
        answer[0] = width;
        answer[1] = height;
        
        return answer;
    }
}
//+2