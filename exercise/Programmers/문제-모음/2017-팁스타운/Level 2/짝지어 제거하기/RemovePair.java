import java.util.Stack;

class Solution
{
    public int solution(String s)
    {
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            
            if(stack.empty()) {
                stack.add(c);
            } else {
                if(stack.peek() == c)
                    stack.pop();
                else
                    stack.push(c);
            }
        }

        return stack.size() == 0 ? 1 : 0;
    }
}
//+4
//스택 활용