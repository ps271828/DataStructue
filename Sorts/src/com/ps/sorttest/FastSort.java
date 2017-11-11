package com.ps.sorttest;

import java.util.Arrays;

public class FastSort {
	public static void main(String[] args) {
		int[] arr = {9,0,5,6,8,7,1,3,2,4};
		quickSort(arr,0, 9);
		System.out.println(Arrays.toString(arr));
	}
	
	/**
	 * 核心思想：
	 * 选取一个基准值，比它小的放在左边，大的放在右边，然后该基准值就会到该趟排序的最后一个位置
	 * 递归地把小于基准值元素的子数列和大于基准值元素的子数列排序
	 * @param numbers 次数为要排序的起始位置
	 * @param start    此数为要排序的结束位置
	 * @param end
	 */
	public static void quickSort(int[] numbers, int start, int end) {   
	    if (start < end) {   
	        int base = numbers[start]; // 选定的基准值（第一个数值作为基准值）   
	        int temp; // 记录临时中间值   
	        int i = start, j = end;   
	        do {   
	            while ((numbers[i] < base) && (i < end))   
	                i++;   
	            while ((numbers[j] > base) && (j > start))   
	                j--;   
	            if (i <= j) {   
	                temp = numbers[i];   
	                numbers[i] = numbers[j];   
	                numbers[j] = temp;   
	                i++;   
	                j--;   
	            }   
	        } while (i <= j);   
	        if (start < j)   
	            quickSort(numbers, start, j);   
	        if (end > i)   
	            quickSort(numbers, i, end);   
	    }   
	}  
}
