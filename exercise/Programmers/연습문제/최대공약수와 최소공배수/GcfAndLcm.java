class Solution {
    public int[] solution(int n, int m) {
        int bigNum, smallNum;
        int g, l;
        
        if(n > m) {
            bigNum = n;
            smallNum = m;
        } else {
            bigNum = m;
            smallNum = n;
        }
        
        g = getG(bigNum, smallNum);
        l = (bigNum * smallNum) / g;
        
        int[] answer = {g, l};
        return answer;
    }
    
    public int getG(int b, int s) {
        int g;
        
        if(b % s == 0) {
            g = s;
        } else {
            g = getG(s, (b % s));
        }
        
        return g;
    }
}