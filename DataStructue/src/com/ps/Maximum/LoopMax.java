package com.ps.Maximum;

/**
 * @Author:panshuang
 * @Data:2018/8/5 17:40
 * @Description:����ѭ�������������
 */
public class LoopMax {
    public  static int maximum(int[] arr) {
        /**
         * ���ֵ����ʼΪ0
         */
        int maxnum = 0;
        for (int i = 0; i <  arr.length; i++) {
            for (int j=i; j < arr.length; j++) {
                int thisSum = 0;
                for (int k=i; k < j; k++) {
                    thisSum += arr[k];
                    if (thisSum > maxnum) {
                        maxnum = thisSum;
                    }
                }
            }
        }
        return maxnum;
    }

    public static void main (String[] args) {
        int[] arr = new int[]{1,-2,3,5,-6,9,10,-6,-7,9};
        System.out.println(maximum(arr));
    }
}
