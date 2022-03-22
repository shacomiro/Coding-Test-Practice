import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public String[] solution(String[] strings, int n) {
        List<String> list = new ArrayList<String>();
        
        for(int i = 0; i < strings.length; i++)
            list.add(strings[i].substring(n, n + 1) + strings[i]);
        
        Collections.sort(list);
        
        for(int i = 0; i < list.size(); i++)
            list.set(i, list.get(i).substring(1, list.get(i).length()));
        
        return list.toArray(new String[list.size()]);
    }
}