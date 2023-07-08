import java.io.*;
import java.util.*;

public class haybales {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("haybales.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("haybales.out")));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n, q;
		n = Integer.parseInt(st.nextToken());
		q = Integer.parseInt(st.nextToken());
		int[] list = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			list[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(list);
		for (int i = 0; i < q; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			pw.println(countHaybales(list, b) - countHaybales(list, a-1));
		}

		pw.close();
	}

	public static int countHaybales(int[] list, int limit) {
		if (list[0] > limit) {
			return 0;
		}

		int min = 0;
		int max = list.length - 1;
		int ans = 0;
		while (min <= max) {
			int mid = (min + max) / 2;
			if (list[mid] <= limit) {
				ans = mid;
				min = mid + 1;
			} else {
				max = mid - 1;
			}
		}

		return ans+1;
	}

}
