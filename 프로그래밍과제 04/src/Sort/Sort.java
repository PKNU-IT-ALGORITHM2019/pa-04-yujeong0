package Sort;

import java.util.Arrays;

public class Sort {
	static int NUMBER = 1000;
	   static int[] array = new int[100000];
	   
	   public static void main(String [] args) {
	      double start, end;
	      double[][] time = new double[10][10];

	      System.out.println("            Random1000   Reverse1000   Random10000  Reverse10000  Random100000  Reverse100000");
	      
	      int j = 0, k = 0;
	      while(NUMBER <= 100000) {
	         for(int i = 0; i < 10; i++) {
	            j = 0;
	            for(int t = 0; t < NUMBER; t++)
	               array[t] = (int)(Math.random() * NUMBER) + 1;

	            start = System.currentTimeMillis(); 
	            BubbleSort.bubbleSort(array);
	            end = System.currentTimeMillis(); 
	            time[j++][k] += end-start;

	            start = System.currentTimeMillis(); 
	            SelectionSort.selectionSort(array);
	            end = System.currentTimeMillis(); 
	            time[j++][k] += end-start;

	            start = System.currentTimeMillis(); 
	            MergeSort.mergeSort(array, 0, NUMBER-1);
	            end = System.currentTimeMillis(); 
	            time[j++][k] += end-start;

	            start = System.currentTimeMillis(); 
	            InsertionSort.insertionSort(array);
	            end = System.currentTimeMillis(); 
	            time[j++][k] += end-start;
	            
	            if(NUMBER != 100000) {
	            	start = System.currentTimeMillis(); 
	            	QuickSort1.quickSort1(array, 0, NUMBER-1);
	            	end = System.currentTimeMillis(); 
	            	time[j++][k] += end-start;
	            }
	            
	            start = System.currentTimeMillis(); 
	            QuickSort2.quickSort2(array, 0, NUMBER-1);
	            end = System.currentTimeMillis(); 
	            time[j++][k] += end-start;
	            
	            if(NUMBER != 100000) {
	            	start = System.currentTimeMillis(); 
	            	QuickSort3.quickSort3(array, 0, NUMBER-1);
	            	end = System.currentTimeMillis(); 
	            	time[j++][k] += end-start;
	            }
	            
	            start = System.currentTimeMillis(); 
	            HeapSort.heapSort(array);
	            end = System.currentTimeMillis(); 
	            time[j++][k] += end-start;
	            
	            start = System.currentTimeMillis(); 
	            Arrays.sort(array);
	            end = System.currentTimeMillis(); 
	            time[j++][k] += end-start;
	         }
	         for(int i = 0;i < j;i++) 
	        	 time[i][k] /= 10000;
	         
	         k++; j = 0;
	         
	         int n = NUMBER;
	         for(int i = 0; i < NUMBER; i++) 
	            array[i] = n--;

	         start = System.currentTimeMillis(); 
	         BubbleSort.bubbleSort(array);
	         end = System.currentTimeMillis(); 
	         time[j++][k] = end-start;

	         start = System.currentTimeMillis(); 
	         SelectionSort.selectionSort(array);
	         end = System.currentTimeMillis(); 
	         time[j++][k] = end-start;

	         start = System.currentTimeMillis(); 
	         InsertionSort.insertionSort(array);
	         end = System.currentTimeMillis(); 
	         time[j++][k] = end-start;
	         
	         start = System.currentTimeMillis(); 
	         MergeSort.mergeSort(array, 0, NUMBER-1);
	         end = System.currentTimeMillis(); 
	         time[j++][k] = end-start;
	         
	         if(NUMBER != 100000) {
	        	 start = System.currentTimeMillis(); 
	        	 QuickSort1.quickSort1(array, 0, NUMBER-1);
	        	 end = System.currentTimeMillis(); 
	        	 time[j++][k] = end-start;
	         }
	         
	         start = System.currentTimeMillis(); 
	         QuickSort2.quickSort2(array, 0, NUMBER-1);
	         end = System.currentTimeMillis(); 
	         time[j++][k] = end-start;

	         if(NUMBER != 100000) {
	        	 start = System.currentTimeMillis(); 
	        	 QuickSort3.quickSort3(array, 0, NUMBER-1);
	        	 end = System.currentTimeMillis(); 
	        	 time[j++][k] = end-start;
	         }
	         
	         start = System.currentTimeMillis(); 
	         HeapSort.heapSort(array);
	         end = System.currentTimeMillis(); 
	         time[j++][k] = end-start;
	         
	         start = System.currentTimeMillis(); 
	         Arrays.sort(array);
	         end = System.currentTimeMillis(); 
	         time[j++][k] = end-start;

	         for(int i = 0;i < j;i++) 
	        	 time[i][k] /= 1000;
	         
	         k++;
	         NUMBER *= 10;
	      }
	      
	      int i = 0;
	      System.out.print("Bubble    ");
	      for(int t = 0; t < k; t++) 
	         System.out.printf("%12.3f  ", time[i][t]);
	      System.out.println();
	      i++;
	      
	      System.out.print("Selection ");
	      for(int t = 0; t < k; t++) 
	    	  System.out.printf("%12.3f  ", time[i][t]);
	      System.out.println();
	      i++;
	      
	      System.out.print("Insertion ");
	      for(int t = 0; t < k; t++) 
	    	  System.out.printf("%12.3f  ", time[i][t]);
	      System.out.println();
	      i++;
	      
	      System.out.print("Merge     ");
	      for(int t = 0; t < k; t++) 
	    	  System.out.printf("%12.3f  ", time[i][t]);
	      System.out.println();
	      i++;
	      
	      System.out.print("Quick1    ");
	      for(int t = 0; t < k-1; t++) 
	    	  System.out.printf("%12.3f  ", time[i][t]);
	      System.out.println("StackOverflowError");
	      i++;
	      
	      System.out.print("Quick2    ");
	      for(int t = 0; t < k; t++) 
	    	  System.out.printf("%12.3f  ", time[i][t]);
	      System.out.println();
	      i++;
	      
	      System.out.print("Quick3    ");
	      for(int t = 0; t < k-1; t++) 
	    	  System.out.printf("%12.3f  ", time[i][t]);
	      System.out.println("StackOverflowError");
	      i++;
	      
	      System.out.print("Heap      ");
	      for(int t = 0; t < k; t++) 
	    	  System.out.printf("%12.3f  ", time[i][t]);
	      System.out.println();
	      i++;
	      
	      System.out.print("Library   ");
	      for(int t = 0; t < k; t++) 
	    	  System.out.printf("%12.3f  ", time[i][t]);
	      System.out.println();
	      i++;
	   }
}
