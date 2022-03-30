class Solution {
    public int solution(String name) {
        int move = 0;
        char[] names = name.toCharArray();
        char[] output = new char[name.length()];
        for(int i = 0; i < output.length; i++) {
            output[i] = 'A';
        }
        
        int cursor = 0;
        int vector = 1;
        int[] weight = new int[name.length()];
        int cnt = 0;
        StringBuilder sb = new StringBuilder(name);
        
        for(int i = 0; i < weight.length; i++) {
            int target = (int) sb.charAt(i);

            if(target != 65)
                cnt++;
            
            if(target - 65 <= 13)
                weight[i] = target - 65;
            else
                weight[i] = 91 - target;
        }
        
        while(true) {
            int left, right;
            
            if(weight[cursor] != 0) {
                move += weight[cursor];
                //System.out.println("가중치 "+weight[cursor]+" 처리 || 누적 이동 : "+move);
                weight[cursor] = 0;
                cnt--;
            }
            
            if(cnt == 0) break;
            
            if(cursor + 1 == weight.length) right = 0;
            else right = cursor + 1;
            if(cursor - 1 == -1) left = weight.length - 1;
            else left = cursor - 1;
            move++;
            //System.out.println("이동 1회 | 누적 : "+move);
            //ABABAAAAAAAAB
            //커서1 -> 마지막A = 12
            //0-1(13-(12+1))+(1)
            //8 
            //1+1+2+1+5+1=11
            
            while(true) {
                if(weight[left] != 0 && weight[right] != 0) {
                    
                    
                    if(vector == 1) {
                        cursor = right;
                    } else {
                        cursor = left;
                    }
                    break;
                } else if(weight[left] == 0 && weight[right] != 0) {
                    vector = 1;
                    cursor = right;
                    break;
                } else if(weight[left] != 0 && weight[right] == 0) {
                    vector = -1;
                    cursor = left;
                    break;
                }
                
                if(right + 1 == weight.length) right = 0;
                else right += 1;
                if(left - 1 == -1) left = weight.length - 1;
                else left -= 1;
                move++;
                //System.out.println("이동 1회 | 누적 : "+move);
            }
        }
        
        return move;
    }
}