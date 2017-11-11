package com.ps.sorttest;

import java.util.Arrays;

public class SelectSort {
	public static void main(String[] args) {
		int[] arr = {9,0,5,6,8,7,1,3,2,4};
		selectSort(arr);
		System.out.println(Arrays.toString(arr));
	}
	
	/**
	 * 核心思想：
	 *  选择排序<br/>  
     * <li>在未排序序列中找到最小元素，存放到排序序列的起始位置</li>  
     * <li>再从剩余未排序元素中继续寻找最小元素，然后放到排序序列末尾。</li>  
     * <li>以此类推，直到所有元素均排序完毕。</li>
	 * @param arr
	 */
	
    public static void selectSort(int[] arr){
    	for(int i=0;i<arr.length;i++){
    		for(int j=arr.length-1;j>i;j--){
    			if(arr[i]>arr[j]){
    				int temp = arr[i];
    				arr[i] = arr[j];
    				arr[j] = temp;
    			}
    		}
    	}
    }
    
    /**
     * 归并排序：
     * 核心思想：分数进行插入排序
     */
}
