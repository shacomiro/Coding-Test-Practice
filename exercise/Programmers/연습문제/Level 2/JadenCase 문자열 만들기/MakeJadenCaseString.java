class Solution {
    public String solution(String s) {
        String answer = "";
        String[] splitS = s.split(" ");
		
		for(int i = 0; i < splitS.length; i++) {
			if(!splitS[i].equals("")) {
				Character.toUpperCase(splitS[i].charAt(0));
				answer = answer.concat(Character.toUpperCase(splitS[i].charAt(0)) + splitS[i].substring(1, splitS[i].length()).toLowerCase());
			}
			
			if(i != splitS.length - 1)
                answer = answer.concat(" ");
            else
                while(s.length() != answer.length())
                    answer = answer.concat(" ");
		}
        
        return answer;
    }
}
//+9