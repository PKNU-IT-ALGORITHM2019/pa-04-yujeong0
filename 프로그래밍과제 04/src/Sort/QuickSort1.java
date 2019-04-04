package Sort;

public class QuickSort1 {
	static void quickSort1(int A[], int p, int r) {
		if (p < r) {
			int q = partition(A, p, r);
			quickSort1(A, p, q-1);
			quickSort1(A, q+1, r);
		}
	}
	static int partition(int A[], int p, int r) {
		int i = p - 1;
		int pivot = r;
		for(int j = p; j < r; j++) {
			if(A[j] <= A[pivot]) {
				i = i + 1;
				int tmp = A[i];
				A[i] = A[j];
				A[j] = tmp;
			}
		}
		int tmp = A[i + 1];
		A[i + 1] = A[pivot];
		A[pivot] = tmp;
		
		return i+1;
	}
	
}
