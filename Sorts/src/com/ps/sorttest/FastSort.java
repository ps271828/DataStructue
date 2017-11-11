package com.ps.sorttest;

import java.util.Arrays;

public class FastSort {
	public static void main(String[] args) {
		int[] arr = {9,0,5,6,8,7,1,3,2,4};
		quickSort(arr,0, 9);
		System.out.println(Arrays.toString(arr));
	}
	
	/**
	 * ����˼�룺
	 * ѡȡһ����׼ֵ������С�ķ�����ߣ���ķ����ұߣ�Ȼ��û�׼ֵ�ͻᵽ������������һ��λ��
	 * �ݹ�ذ�С�ڻ�׼ֵԪ�ص������кʹ��ڻ�׼ֵԪ�ص�����������
	 * @param numbers ����ΪҪ�������ʼλ��
	 * @param start    ����ΪҪ����Ľ���λ��
	 * @param end
	 */
	public static void quickSort(int[] numbers, int start, int end) {   
	    if (start < end) {   
	        int base = numbers[start]; // ѡ���Ļ�׼ֵ����һ����ֵ��Ϊ��׼ֵ��   
	        int temp; // ��¼��ʱ�м�ֵ   
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
