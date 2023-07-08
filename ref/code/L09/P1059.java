import java.io.IOException;
import java.util.Scanner;

public class P1059 {
 	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[1001];
        int cnt = 0; 
        for(int i = 0; i < n; i++) {
        	int num = sc.nextInt();
        	if(arr[num] == 0) {
        		cnt++;
        	}
        	arr[num]++;
        }

        System.out.println(cnt);
        for(int i = 1; i <= 1000; i++) {
        	if(arr[i] > 0) {
        		System.out.print(i + " ");
        	}
        }
	}
}
