package Sort;

public class MergeSort {
	static void mergeSort(int A[], int p, int r) {
		if(p < r) {
			int q = (p + r) / 2;
			mergeSort(A, p, q);
			mergeSort(A, q+1, r);
			merge(A, p, q, r);
		}
	}
	static void merge(int A[], int p, int q, int r) {
		int[] tmp = new int[A.length];
		int index = p;
		int i = p;
		int j = q + 1;
		while(i<=q && j<=r){
			if(A[i] < A[j])
				tmp[index++] = A[i++];
			else
				tmp[index++] = A[j++];
		}
		while(i<=q)
			tmp[index++] = A[i++];
		while(j<=r)
			tmp[index++] = A[j++];
		
		for(int k = p; k <= r; k++)
			A[k] = tmp[k];
	}
	
	
}
