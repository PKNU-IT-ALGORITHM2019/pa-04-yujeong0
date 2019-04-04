package Sort;

public class SelectionSort {
	static void selectionSort(int A[]) {

		for(int i = A.length - 1; i >= 1; i--) {
			int max_idx = 0;
			for(int j = 0; j <= i; j++) 
				if (A[max_idx] < A[j]) {
					max_idx = j;
				}
			int tmp = A[max_idx];
			A[max_idx] = A[i];
			A[i] = tmp;
		}
	}
	
	
}
