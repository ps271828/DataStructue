package com.ps.sorttest;

import java.util.Arrays;

public class MaoPaoSort {
	public static void main(String[] args) {
		int[] arr = {9,0,1,5,7,8,5,4,2,3,6};
		maoPaoSort(arr);
		System.out.println(Arrays.toString(arr));
	}
	
	/**
	 * 核心思想：
	 * 将每一个数与余下的数相比较，如果比后面的数大，交换位置，每比较完一趟将要比较的长度减一
	 * @param arr
	 */
	
    public static void maoPaoSort(int[] arr){
    	for(int i=0;i<arr.length;i++){
    		for(int j=1;j<arr.length-i;j++){
    			if(arr[i]>=arr[j]){
    				int temp = arr[i];
    				arr[i] = arr[j];
    				arr[j] = temp;
    			}
    		}
    	}
    }
}
