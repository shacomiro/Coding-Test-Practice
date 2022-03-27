import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> clothesMap = new HashMap<String, Integer>();
        
        for(String[] singleClothes : clothes) {
            if(!clothesMap.containsKey(singleClothes[1]))
                clothesMap.put(singleClothes[1], 2);
            else 
                clothesMap.replace(singleClothes[1], clothesMap.get(singleClothes[1]) + 1);
        }
        
        for(Entry<String, Integer> entry : clothesMap.entrySet())
			answer *= entry.getValue();
        
        return answer - 1;
    }
}
//+3