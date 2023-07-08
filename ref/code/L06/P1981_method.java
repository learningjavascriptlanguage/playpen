import java.io.*;
import java.util.*;

public class P1981_method {
	
	static final int MOD = 10000;
	
	static int begin = 0, index = 0; // begin表示一串数字的起点位置
	
	static int readNumber(String s) {		
		int num = 0;
		while(index < s.length()) {
			if(!Character.isDigit(s.charAt(index))) {
				num = Integer.parseInt(s.substring(begin, index));
				begin = index + 1;
				break;
			}
			index++;
		}
		return num;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String s = in.readLine();
		s += '#'; // 添加一个结束标志
		
		Stack<Integer> stack = new Stack<>();
		// 读取第一个数
		stack.push(readNumber(s)%MOD);
		
		while(index<s.length()) {
			// 读取+ 或  *
			char c = s.charAt(index);
			index++;
			// 读取下一个数
			stack.push(readNumber(s)%MOD);

			if(c == '*') {
				int num1 = stack.pop();
				int num2 = stack.pop();
				stack.push((num1*num2)%MOD);
			}
		}
		
		int ans = 0;
		while(!stack.isEmpty()) {
			ans = (ans + stack.pop())%MOD;
		}
	    
		System.out.println(ans);
	}

}