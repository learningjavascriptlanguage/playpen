import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class P1106_list {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
		String s = f.readLine();
		int k = Integer.parseInt(f.readLine());
		ArrayList<Character> list = new ArrayList<>();
		for(int i=0; i<s.length(); i++) {
			list.add(s.charAt(i));
		}

		
		for(int i=0; i<k; i++) {
			boolean sorted = true;  // 优化速度
			for(int j=0; j<list.size()-1; j++) {
				if(list.get(j)>list.get(j+1)) {
					list.remove(j);
					sorted = false;
					break;
				}
			}
			if(sorted) {
				list.remove(list.size() - 1);
			}
		}

		// 去除前导零
		boolean nonZero = false;
		for(int i=0; i<list.size() - 1; i++) {
			if(list.get(i)!='0') {
				nonZero = true;
			}
			if(nonZero) {
				System.out.print(list.get(i));
			}
		}

		System.out.println(list.get(list.size() - 1));  // 不管是不是零，最后一位一定要输出
	}
}
