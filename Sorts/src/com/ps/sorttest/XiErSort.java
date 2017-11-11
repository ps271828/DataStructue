package com.ps.sorttest;

import java.util.Arrays;

/**
 * ����˼�룺
 * ���������һ�����飬Ȼ���ÿ��������в������򣬷��β��� 
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
    	           //����gap��������С����
    	           for(int gap=arr.length/2;gap>0;gap/=2){
    	              //�ӵ�gap��Ԫ�أ�����������������ֱ�Ӳ����������
    	                for(int i=gap;i<arr.length;i++){
    	                    int  j = i;
    	                    int temp = arr[j];
    	                    if(arr[j]<arr[j-gap]){
    	                        while(j-gap>=0 && temp<arr[j-gap]){
    	                            //�ƶ���
    	                            arr[j] = arr[j-gap];
    	                            j-=gap;
    	                        }
    	                        arr[j] = temp;
    	                    }
    	                }
    	            }
    	        }
      
      //������
      public static void xiErSort(int[] arr){
    	  //�������Ʒ��飬�ڶ�������ź�������飬�ڲ������������
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
