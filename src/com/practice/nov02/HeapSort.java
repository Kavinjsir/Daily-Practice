package com.practice.nov02;

import java.lang.reflect.InvocationTargetException;

import com.practice.oct31.SortTestHelper;

public class HeapSort {

	private HeapSort() {}
	
	public static void sort(Comparable[] arr) {
		int n = arr.length;
		
		// 注意，此时我们的堆是从0开始索引的
        // 从(最后一个元素的索引-1)/2开始
        // 最后一个元素的索引 = n-1
		for(int i = (n - 1 - 1) / 2; i >= 0; --i) {
			//shiftDown(arr, n, i);
		}
		
		for(int i = n - 1; i > 0; --i) {
			swap(arr, 0, i);
			//shiftDown(arr, i, 0);
		}
	}
	
	private static void swap(Object[] arr, int i, int j) {
		Object t =arr[j];
		arr[i] = arr[j];
		arr[j] = t;
	}
	
	// 优化的shiftDown过程, 使用赋值的方式取代不断的swap,
    // 该优化思想和我们之前对插入排序进行优化的思路是一致的
	private static void shiftDown(Comparable[] arr, int n, int k) {
		Comparable e = arr[k];
		while(2*k+1 < n) {
			int j = 2*k+1;
			if(j+1<n && arr[j+1].compareTo(arr[j]) > 0) {
				j++;
			}
			
			if(e.compareTo(arr[j]) >= 0) {
				break;
			}
			arr[k] = arr[j];
			k = j;
		}
		arr[k] = e;
	}
	
	
	public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
		int N =1000000;
		Integer[] arr = SortTestHelper.generateRandomArray(N, 0, N);
		SortTestHelper.testSort("com.practice.nov02.HeapSort", arr);
	}

}