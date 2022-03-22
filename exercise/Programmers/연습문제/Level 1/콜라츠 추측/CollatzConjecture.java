class Solution {
    public int solution(int num) {
        int time = 0;
        
        if(num == 1) return 0;
        while(time++ < 500) {
            int evenCheck = num % 2;
                        
            if(evenCheck == 1) {
                num = (num * 3) + 1;
            } else {
                num = num / 2;
            }
            
            if(num == 1) return time;
        }
        
        return -1;
    }
}