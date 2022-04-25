import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

class Solution {
    public int[] solution(String s) {
        Map<String, Integer> map = new HashMap<>();
        Pattern p = Pattern.compile("[0-9]+");
        Matcher m = p.matcher(s);
        
        while(m.find()) {
            String word = m.group();
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        
        int[] answer = new int[map.size()];
        for(String key : map.keySet()) {
            answer[map.size() - map.get(key)] = Integer.parseInt(key);
        }
        
        return answer;
    }
}
//+1