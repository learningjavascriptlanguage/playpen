import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P1094 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int w = Integer.parseInt(in.readLine());
		int n = Integer.parseInt(in.readLine());
		int[] items = new int[n];
		for (int i = 0; i < n; i++) {
			items[i] = Integer.parseInt(in.readLine());
		}
		Arrays.sort(items);
		int l = 0;
		int r = n-1;
		int count = 0;
		while (l <= r) {

			if (items[l] + items[r] <= w) {
				l++;
				r--;
			} else {
				r--;
			}
			count++;
		}
		System.out.println(count);
	}
}
