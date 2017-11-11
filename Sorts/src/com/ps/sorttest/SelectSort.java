package com.ps.sorttest;

import java.util.Arrays;

public class SelectSort {
	public static void main(String[] args) {
		int[] arr = {9,0,5,6,8,7,1,3,2,4};
		selectSort(arr);
		System.out.println(Arrays.toString(arr));
	}
	
	/**
	 * ����˼�룺
	 *  ѡ������<br/>  
     * <li>��δ�����������ҵ���СԪ�أ���ŵ��������е���ʼλ��</li>  
     * <li>�ٴ�ʣ��δ����Ԫ���м���Ѱ����СԪ�أ�Ȼ��ŵ���������ĩβ��</li>  
     * <li>�Դ����ƣ�ֱ������Ԫ�ؾ�������ϡ�</li>
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
     * �鲢����
     * ����˼�룺�������в�������
     */
}
