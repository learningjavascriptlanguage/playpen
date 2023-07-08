import java.io.IOException;
import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeSet;

public class P1059_TreeSet {
 	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        TreeSet<Integer> set = new TreeSet<>(); // ascending
        
//        TreeSet<Integer> set = new TreeSet<>(new Comparator<Integer>() {
//
//			@Override
//			public int compare(Integer o1, Integer o2) {
//				return o2 - o1;   // descending
//			}
//		});

        for(int i = 0; i < n; i++) {
        	int num = sc.nextInt();
        	set.add(num);
        }
        
        System.out.println(set.size());
        while(!set.isEmpty()) {
        	System.out.print(set.pollFirst() + " ");
        }
        sc.close();
	}
}
