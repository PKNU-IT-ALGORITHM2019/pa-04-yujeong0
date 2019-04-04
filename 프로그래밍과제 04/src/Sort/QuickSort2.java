package Sort;

public class QuickSort2 {
	static void quickSort2(int A[], int p, int r) {
		if (p < r) {
			int q = partition(A, p, r);
			quickSort2(A, p, q-1);
			quickSort2(A, q+1, r);
		}
	}
	static int partition(int A[], int p, int r) {
		int i = p - 1;
		int a = A[p];
		int b = A[(p+r)/2];
		int c = A[r];
		
		int pivot;
		if(a > b && a < c || a < b && a > c) pivot = p;
		else if(b > a && b < c || b < a && b > c) pivot = (p+r)/2;
		else pivot = r;
		
		int t = A[r];
		A[r] =  A[pivot];
		A[pivot] = t;
		
		for(int j = p; j < r; j++) {
			if(A[j] <= A[r]) {
				i = i + 1;
				int tmp = A[i];
				A[i] = A[j];
				A[j] = tmp;
			}
		}
		int tmp = A[i + 1];
		A[i + 1] = A[r];
		A[r] = tmp;
		
		return i + 1;
	}
	
	
}
