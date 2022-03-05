package hash;

import java.util.Arrays;
import java.util.HashSet;

public class PhoneNumberList {

	public static void main(String[] args) {
//		String[] phone_book = {"119", "97674223", "1195524421"};
//		String[] phone_book = {"123","456","789"};
		String[] phone_book = {"12","123","1235","567","88"};
		
		
		System.out.println(solution(phone_book));
	}
	
	//전화번호 목록
	public static boolean solution(String[] phone_book) {
		HashSet<String> phoneBookSet = new HashSet<String>(Arrays.asList(phone_book));
		
		for(String criteriaPhoneNumber : phoneBookSet) {
			for(int i = 1; i < criteriaPhoneNumber.length(); i++) {
				if(phoneBookSet.contains(criteriaPhoneNumber.substring(0, i))) return false;
			}
		}
		
		return true;
	}
}
