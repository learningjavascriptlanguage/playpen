import java.io.*;
import java.util.*;

/**
二分查找
样例1
input:
10
1 3 4 5 7 8 9 10 20 21
11
output:
not found

样例2
input:
10
1 3 4 5 7 8 9 10 20 21
9
output:
7 
 */
public class BinarySearch {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		int[] data = new int[n+1];
		StringTokenizer tk = new StringTokenizer(in.readLine());
		for(int i=1; i<=n; i++) {
			data[i] = Integer.parseInt(tk.nextToken());  // 确保数据有序
		}
		int target = Integer.parseInt(in.readLine());
		int left = 1, right = n;
		while(left <= right) {
			int mid = (left+right)/2; // 防止溢出写法 left + (right-left)/2
			if(data[mid] == target) {
				System.out.println(mid);
				return;
			}

			if(target < data[mid]) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}

		System.out.println("not found");
			
//		int pos = Arrays.binarySearch(data, 1, n+1, target);
//		if(pos < 0) {
//			// 如果target不存在，相当于c++ upper_bound效果
//			System.out.println(-(pos + 1));
//		} else {
//			// 如果target存在，相当于c++ lower_bound效果
//			System.out.println(pos);
//		}

	}
}