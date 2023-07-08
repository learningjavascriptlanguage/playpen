import java.io.*;
import java.util.*;

public class MergeSort {
	static int[] a = new int[500001];
	static int[] temp = new int[500001];
	static int cnt = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		
		StringTokenizer tk = new StringTokenizer(in.readLine());
		for(int i=0; i<n; i++) {
			a[i] = Integer.parseInt(tk.nextToken());
		}
		
		mergeSort(0, n-1);
		
//		for(int i=0; i<n; i++) {
//			System.out.print(a[i] + " ");
//		}
		
		System.out.println(cnt);
	}
	
	static void mergeSort(int left, int right) {
		if(left == right)
			return;
		
		int mid=(left+right)/2;
		mergeSort(left, mid);
		mergeSort(mid+1, right);
		
		// merge
		int i=left, j=mid+1, k=left;
		while(i<=mid && j<=right) {
			if(a[i]<=a[j]) {
				temp[k]=a[i];
				i++;
			} else {
				temp[k]=a[j];
				j++;
				cnt+=mid-i+1;
			}
			k++;
		}
		
		while(i<=mid) {
			temp[k]=a[i];
			i++;
			k++;
		}
		
		while(j<=right) {
			temp[k]=a[j];
			j++;
			k++;
		}
		
		for(int x=left; x<=right; x++) {
			a[x]=temp[x];
		}
		
	}
}