package com.ps.sorttest;

import java.util.Arrays;

/**
 * 核心思想：
 * 对数组进行一个分组，然后对每个分组进行插入排序，分治策略 
 * @author Administrator
 *
 */
public class XiErSort {
      public static void main(String[] args) {
		int[] arr = {1,4,3,2,5,6,9,8,7,0};
		xiErSort(arr);
		System.out.println(Arrays.toString(arr));
	}
      
      public static void sort1(int []arr){
    	           //增量gap，并逐步缩小增量
    	           for(int gap=arr.length/2;gap>0;gap/=2){
    	              //从第gap个元素，逐个对其所在组进行直接插入排序操作
    	                for(int i=gap;i<arr.length;i++){
    	                    int  j = i;
    	                    int temp = arr[j];
    	                    if(arr[j]<arr[j-gap]){
    	                        while(j-gap>=0 && temp<arr[j-gap]){
    	                            //移动法
    	                            arr[j] = arr[j-gap];
    	                            j-=gap;
    	                        }
    	                        arr[j] = temp;
    	                    }
    	                }
    	            }
    	        }
      
      //交换法
      public static void xiErSort(int[] arr){
    	  //最外层控制分组，第二层控制排好序的数组，内层控制排序轮数
    	  for(int gap = arr.length/2;gap>0;gap/=2){
    		  for(int j=0;j<arr.length;j+=gap){
    			  for(int k=0;k<j;k+=gap){
    				  if((j+gap)<arr.length&&arr[j+gap]<arr[k]){
    					  int temp = arr[j+gap];
    					  arr[j+gap] = arr[k];
    					  arr[k] = temp;
    				  }
    			  }
    		  }
    	  }
      }
}
