class Solution {
    public String solution(int n) {
        StringBuffer answer = new StringBuffer();
        StringBuffer num;
        
        while(n != 0) {
            if(n % 3 == 0) num = new StringBuffer("4");
            else num = new StringBuffer(Integer.toString(n % 3));
            
            answer = num.append(answer);
            
            if(n % 3 == 0) n = (n / 3) - 1;
            else n /= 3;
        }
        
        return answer.toString();
    }
}