class Solution {
    public int solution(String s) {
        int answer = s.length();
     
        for(int i = 1; i < s.length() + 1; i++) {
            StringBuilder sb = new StringBuilder();
            int cutSize = i;
            String targetWord = "";
            String currWord = "";
            int cnt = 0;
            
            for(int j = 0; j < s.length(); j = j + cutSize) {
                if(j + cutSize > s.length()) {
                    cutSize = s.length() - j;
                }
                
                currWord = s.substring(j, j + cutSize);

                if(targetWord.equals("")) {
                    targetWord = s.substring(j, j+ cutSize);
                    cnt++;

                    if(j + cutSize == s.length())
                        if(cnt == 1) sb.append(targetWord);
                        else sb.append(cnt+targetWord);
                } else {
                    if(currWord.equals(targetWord)) {
                        cnt++;

                        if(j + cutSize == s.length())
                            if(cnt == 1) sb.append(targetWord);
                            else sb.append(cnt+targetWord);
                    } else {
                        if(cnt == 1) sb.append(targetWord);
                        else sb.append(cnt+targetWord);

                        targetWord = currWord;
                        cnt = 1;

                        if(j + cutSize == s.length())
                            if(cnt == 1) sb.append(targetWord);
                            else sb.append(cnt+targetWord);
                    }
                }
            }
            
            answer = Math.min(answer, sb.length());
        }

        return answer;
    }
}
//+5