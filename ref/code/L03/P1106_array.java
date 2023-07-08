import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class P1106_array {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
		String s = f.readLine();
		int k = Integer.parseInt(f.readLine());
		char[] c = s.toCharArray();
		int length = s.length();
		
		boolean sorted = false;  // 优化速度
		for(int i=0; i<k; i++) {
			if(!sorted) {
				int j;
				for(j=0; j<length-1; j++) {
					if(c[j]>c[j+1]) {
						for(int x = j; x<length-1; x++) {
							c[x]=c[x+1];
						}
						break;
					}
				}
				if(j == length) {
					sorted = true;
				}
			}
			
			length--;
		}
		
		boolean nonZero = false;
		for(int i=0; i<length-1; i++) {
			if(c[i]!='0') {
				nonZero = true;
			}
			if(nonZero) {
				System.out.print(c[i]);
			}
		}
		
		System.out.println(c[length-1]);
		

	}
}
