import java.util.HashMap;
import java.util.Map;

class Solution {
    public String[] solution(String[] record) {
        Map<String, String> map = new HashMap<>();
        int size = 0;
        
        for(int i = 0; i < record.length; i++) {
            String[] info = record[i].split(" ");
            
            if(info[0].equals("Enter")) {
                map.put(info[1], info[2]);
            } else if(info[0].equals("Change")) {
                map.replace(info[1], info[2]);
                size--;
            }
            
            size++;
        }
        
        String[] answer = new String[size];
        int idx = 0;
        
        for(int i = 0; i < record.length; i++) {
            String[] info = record[i].split(" ");
            
            if(info[0].equals("Enter")) {
                answer[idx] = map.get(info[1]) + "님이 들어왔습니다.";
            } else if(info[0].equals("Leave")) {
                answer[idx] =  map.get(info[1]) + "님이 나갔습니다.";
            } else {
                idx--;
            }
            
            idx++;
        }
        
        return answer;
    }
}
//+2