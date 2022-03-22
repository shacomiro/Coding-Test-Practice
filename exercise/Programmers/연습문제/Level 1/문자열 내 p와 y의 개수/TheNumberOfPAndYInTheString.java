class Solution {
    boolean solution(String s) {
		int pCount = 0;
		int yCount = 0;
		char[] characters = s.toLowerCase().toCharArray();
		
		for(char character : characters) {
			if(character == 'p') pCount++;
			else if(character == 'y') yCount++;
		}
		
		return pCount == yCount ? true : false;
    }
}