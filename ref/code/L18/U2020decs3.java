package com.deltacoding.usaco.s2020_2021.dec2020.silver;
import java.io.*;
import java.util.*;

public class U2020decs3 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
        Cow[] cowe = new Cow[n+1];
        Cow[] cown = new Cow[n+1];
		int cnte = 0, cntn = 0;
		for(int i=1; i<=n; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			char c = st.nextToken().charAt(0);
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			if(c == 'E') {
				cnte++;
				cowe[cnte] = new Cow(x, y, i);
			}
			if(c == 'N') {
				cntn++;
				cown[cntn] = new Cow(x, y, i);
			}
		}
		Arrays.sort(cowe, 1, cnte+1, new Comparator<Cow>() {

			@Override
			public int compare(Cow o1, Cow o2) {
				return o1.y - o2.y;
			}
		});
		Arrays.sort(cown, 1, cntn+1, new Comparator<Cow>() {

			@Override
			public int compare(Cow o1, Cow o2) {
				return o1.x - o2.x;
			}
		});

		for(int i=1; i<=cntn; i++) {
			for(int j=1; j<=cnte; j++) {
				if(cowe[j].dis < Integer.MAX_VALUE) {
					continue;
				}
				int lenx = cown[i].x - cowe[j].x;
				int leny = cowe[j].y - cown[i].y;
				if(lenx < 0 || leny < 0 || lenx == leny) {
					continue;
				}
				if(lenx > leny) {
					cowe[j].dis = lenx;
					cown[i].count += cowe[j].count + 1;
				} else {
					cown[i].dis = leny;
					cowe[j].count += cown[i].count + 1;
					break;
				}
			}
		}

		for(int i=1; i<=cntn; i++) {
			cowe[cnte + i] = cown[i];
		}

		Arrays.sort(cowe, 1, n+1, new Comparator<Cow>() {

			@Override
			public int compare(Cow o1, Cow o2) {
				return o1.id - o2.id;
			}
		});
		
		
		for(int i=1; i<=n; i++) {
			System.out.println(cowe[i].count);
		}
		
	}
	
	static class Cow {
		int x, y, id;
		int dis = Integer.MAX_VALUE;
		int count = 0;
		public Cow(int x, int y, int id) {
			this.x = x;
			this.y = y;
			this.id = id;
		}
	}
}
