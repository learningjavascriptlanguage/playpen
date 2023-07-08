import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class ArrayListSample {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    // list:  Data structure  CRUD (create read update delete)
		ArrayList<Integer> list = new ArrayList<>();

		// create
		for(int i=1; i<=5; i++) {
			list.add(i);
		}
		
		// read
		for(int i=0; i<5; i++) {
			System.out.print(list.get(i) + " ");
		}
		System.out.println();
		
		// update
		list.set(2, 8);
		print(list);
		list.add(0, 9);		
		print(list);
		
		// delete
		list.remove(3);
		print(list);
		
		list.remove(Integer.valueOf(5));
		print(list);

		// Array  <->  List 互相转化
		Integer[] arr = list.toArray(new Integer[list.size()]);
//		
		List<Integer> newList = Arrays.asList(arr);

		// sort
		list.sort(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return Integer.compare(o1, o2);
			}
		});
		
		Collections.sort(list, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return Integer.compare(o1, o2);
			}
		});

		// for loop, 按照index loop
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i) + " ");
		}
		System.out.println();

		// for each
		for(Integer i : list) {
			System.out.print(i + " ");
		}
		System.out.println();

//		// Iterator
		Iterator<Integer> itr = list.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		
	}

	
	static void print(ArrayList<Integer> list) {
		for(int i=0; i<list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}
		System.out.println();
	}
}
