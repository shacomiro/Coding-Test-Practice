package kakao_blind_recruitment_2021;

public class new_id_recommend {
	public static void main(String[] args) {
		String answer = "~!@#$%^&*()=+[{]}:?,<>/-_.";
		
		int length = answer.length();
        
        answer = answer.toLowerCase();
        
        answer = answer.replaceAll("[~!@#$%^&*()=+\\[{\\]}:?,<>/]", "");
        
        answer = answer.replaceAll("\\.+", "\\.");
        
        if(answer.startsWith(".")) {
        	answer = answer.substring(1, answer.length());
        }
        
        if(answer.endsWith(".")) {
        	answer = answer.substring(0, answer.length() - 1);
        }
        
        if(answer.equals("")) {
        	answer = "a";
        }
		
        if(answer.length() >= 16) {
        	answer = answer.substring(0, 15);
        	
        	if(answer.endsWith(".")) {
        		answer = answer.substring(0, answer.length() - 1);
        	}
        }
        
        if(answer.length() <= 2) {
        	char lastWord = answer.charAt(answer.length() - 1);
        	while(answer.length() < 3) {
        		answer += lastWord;
        	}
        }
        
        System.out.println(answer);
	}
}
