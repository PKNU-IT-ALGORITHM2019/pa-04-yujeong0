package Sort;

public class QuickSort3 {
	static void quickSort3(int A[], int p, int r) {
		if (p < r) {
			int q = partition(A, p, r);
			quickSort3(A, p, q-1);
			quickSort3(A, q+1, r);
		}
	}
	static int partition(int A[], int p, int r) {
		int i = p - 1;
		int pivot = (int)Math.random()*(r-p+1) + p;
		
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
