class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        String[][] map1 = new String[n][n];
		String[][] map2 = new String[n][n];
        
        for(int i = 0; i < arr1.length; i++) {
			int code = arr1[i];
			int idx = n - 1;
			int cnt = n;
			
			while(code > 0 || cnt != 0) {
				if(code % 2 == 1)
					map1[i][idx] = "#";
				else
					map1[i][idx] = " ";
				
				code = code / 2;
				idx--;
				cnt--;
			}
		}
        
        for(int i = 0; i < arr2.length; i++) {
			int code = arr2[i];
			int idx = n - 1;
			int cnt = n;
			
			while(code > 0 || cnt != 0) {
				if(code % 2 == 1)
					map2[i][idx] = "#";
				else
					map2[i][idx] = " ";
				
				code = code / 2;
				idx--;
				cnt--;
			}
		}
        
        for(int x = 0; x < n; x++) {
			answer[x] = "";
			
			for(int y = 0; y < n; y++) {
				if(map1[x][y].equals("#") || map2[x][y].equals("#")) 
					answer[x] = answer[x].concat("#");
                else
                    answer[x] = answer[x].concat(" ");
			}
		}
        
        return answer;
    }
}