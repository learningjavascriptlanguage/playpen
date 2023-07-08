import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class P1223 {
	static class Person {
		int id, time;
		
		public Person(int id, int time) {
			this.id = id;
			this.time = time;
		}
	}
	
	/*
	 * 样例输入数据第一行后面的空格要去除, 或者用  .trim()去除左右两端空格
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(f.readLine());
		Person persons[] = new Person[n];
		StringTokenizer tk = new StringTokenizer(f.readLine());
		for(int i=0; i<n; i++) {
			persons[i] = new Person(i+1, Integer.parseInt(tk.nextToken()));	
		}
		
		Arrays.sort(persons, new Comparator<Person>() {

			@Override
			public int compare(Person o1, Person o2) {
				return o1.time - o2.time;
			}
		});
		double sum = 0;
		for(int i=0; i<n; i++) {
			sum+=persons[i].time*(n-1-i);
		}
		
		for(int i=0; i<n; i++) {
			System.out.print(persons[i].id+" ");
		}
		System.out.println();		
		System.out.printf("%.2f", sum/n);
	}
}
