package Sort;

public class HeapSort {
	
	static void heapSort(int[] A) {
		BUILD_MAX_HEAP(A);
		int heapsize = A.length-1;
		for(int i = heapsize; i >= 1 ; i--) {
			swap(A, 0, i);
			heapsize = heapsize - 1;
			MAX_HEAPIFY(A, 0, heapsize);
		}
	}
	static void MAX_HEAPIFY (int[] A, int i, int heapsize) {
		while (2*i + 1 <= heapsize) {
			int k;
			if(2*i + 1 == heapsize) k = 2*i + 1;
			else {
				if(A[2*i + 1] > A[2*i + 2]) k = 2*i + 1;
				else k = 2*i + 2;
			}
			if (A[i] >= A[k]) return;
			swap(A, i, k);
			i = k;
		}
	}
	static void BUILD_MAX_HEAP(int[] A) {
		for(int i = A.length/2 - 1; i >= 0;i--) {
			MAX_HEAPIFY(A, i, A.length - 1);
		}
	}
	static void swap(int[] A, int a, int b) {
		int  tmp = A[a];
		A[a] = A[b];
		A[b] = tmp;
	}
	
}
