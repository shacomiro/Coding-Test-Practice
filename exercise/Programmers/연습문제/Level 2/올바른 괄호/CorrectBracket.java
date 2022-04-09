class Solution {
    boolean solution(String s) {
        char[] arr = s.toCharArray();
        int start = 0;
        int bracket = 0;
        
        if(arr.length % 2 != 0 || arr[0] == ')' || arr[arr.length - 1] == '(')
            return false;
        else {
            while(start <= arr.length - 1) {
                if(arr[start++] == '(')
                    bracket++;
                else
                    bracket--;
                
                if(bracket < 0)
                    return false;
            }
        }
        
        if(bracket  == 0)
            return true;

        return false;
    }
}
//+5