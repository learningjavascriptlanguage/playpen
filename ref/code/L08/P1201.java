import java.io.*;
import java.util.*;

public class P1201 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		Map<String, Integer> map = new HashMap<>(); // key: name  value: money
		int n = Integer.parseInt(in.readLine());
		String[] name = new String[n];
		for(int i=0; i<n; i++) {
			name[i] = in.readLine();
			map.put(name[i], 0);
		}

		for(int i=0; i<n; i++) {
			String giver = in.readLine();
			StringTokenizer tk = new StringTokenizer(in.readLine());
			int giftNum, personNum;
			giftNum = Integer.parseInt(tk.nextToken());
			personNum = Integer.parseInt(tk.nextToken());
			if(personNum == 0)
				continue;
			int average = giftNum/personNum;
			map.put(giver, map.get(giver) - average * personNum);
			for(int j=0; j<personNum; j++) {
				String receiver = in.readLine();
				map.put(receiver, map.get(receiver) + average);
			}
		}

		for(int i=0; i<n; i++) {
			System.out.println(name[i] + " " + map.get(name[i]));
		}

	}
}