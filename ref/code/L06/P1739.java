import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class P1739 {

	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
		String s = f.readLine();
	    Stack<Character> stack = new Stack<>();
        for(int i=0; i<s.length(); i++) {
        	char c = s.charAt(i);
        	if(c == '(') {
        		stack.push(c);
        	} else if(c == ')' && !stack.isEmpty()) { //一定要判空
        		stack.pop();
        	} else if(c == ')' && stack.isEmpty()){  // 没有左括号和右括号匹配
        		System.out.println("NO");
        		return;
        	}
        }

        //若栈为空则满足条件
        if(stack.isEmpty()) {
        	System.out.println("YES");
        } else {
        	System.out.println("NO");
        }
		
	}
}
