import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        char[] c = s.toCharArray();
        
        Deque<Character> stack;
        boolean flag;
        
        for(int i = 0; i < c.length; i++) { // n번 회전
            char first = c[0];
            for(int j = 0; j < c.length - 1; j++) {
                c[j] = c[j + 1];
            }
            c[c.length - 1] = first;
            
            // System.out.println(Arrays.toString(c));
            stack = new LinkedList<>();
            flag = false;
            for(int j = 0; j < c.length; j++) {
                char el = c[j];
                if(el == '(' || el == '[' || el == '{') stack.addLast(el);
                else {
                    if(!stack.isEmpty()) {
                        char stackEl = stack.pollLast();
                        if(el == ')' && stackEl == '(') continue;
                        else if(el == ']' && stackEl == '[') continue;
                        else if(el == '}' && stackEl == '{') continue;
                        else {
                            flag = true;
                            break;
                        }
                    }
                    else {
                        flag = true;
                        break;
                    }
                }
            }
            if(!stack.isEmpty()) flag = true;
            if(!flag) answer++;
        }
        
        return answer;
    }
}
