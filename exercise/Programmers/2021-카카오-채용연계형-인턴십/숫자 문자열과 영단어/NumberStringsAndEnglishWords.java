import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;


class Solution {
    public int solution(String s) {
        Map<String, String> wordsMap = new HashMap<String, String>() {{ put("0","zero");
																		put("1","one");
																		put("2","two");
																		put("3","three");
																		put("4","four");
																		put("5","five");
																		put("6","six");
																		put("7","seven");
																		put("8","eight");
																		put("9","nine");
		}};		
		
		for(Entry<String, String> word : wordsMap.entrySet()) {
			s = s.replaceAll(word.getValue(), word.getKey());
		}
		
		return Integer.parseInt(s);
    }
}