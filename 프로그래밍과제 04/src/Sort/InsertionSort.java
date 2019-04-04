package Sort;

public class InsertionSort {
	static void insertionSort(int A[]) {
		for(int i = 1; i < A.length; i++) {
			int tmp = A[i];
			int j = i-1;
			while(j >= 0 && tmp < A[j]) {
				A[j + 1] = A[j];
				j--;
			}
			A[j+1] = tmp;
		}
	}
	
	
}
