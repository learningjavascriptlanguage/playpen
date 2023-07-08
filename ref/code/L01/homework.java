import java.io.*;
import java.util.*;

public class homework {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("homework.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("homework.out")));
		int n = Integer.parseInt(br.readLine());
		int[] num = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		long min = Integer.MAX_VALUE;
		long sum = 0;
		long bestSum = 0;
		long bestLeft = 1;
		ArrayList<Integer> allValid = new ArrayList<>();
		for (int i = n - 1; i > 0; i--) {
			sum += num[i];
			min = Math.min(min, num[i]);
			if(i <= n - 2) {
				if ((sum - min) * bestLeft > bestSum * (n - i - 1)) { // 十字相乘法
					allValid.clear(); // 由于出现更大的平均数，要把之前找到的i全部清掉
					allValid.add(i);
					bestSum = sum - min;
					bestLeft = n - i - 1;
				} else if((sum - min) * bestLeft == bestSum * (n - i - 1)) { // 出现和之前最大平均数一样的值
					allValid.add(i);
				}
			}			
		}
		for(int i = allValid.size() - 1; i >=0; i--) {
			pw.println(allValid.get(i));
		}
		br.close();
		pw.close();
	}
}