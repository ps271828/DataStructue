package com.ps.stack.Impl;

import java.util.Stack;

/**
 * @Author:panshuang
 * @Data:2018/8/31 23:06
 * @Description:
 */
public class NextGreateNum {

    /**
     * 给定两个没有重复元素的数组 nums1 和 nums2 ，其中nums1 是 nums2 的子集。找到 nums1 中每个元素在 nums2 中的下一个比其大的值。
     * nums1 中数字 x 的下一个更大元素是指 x 在 nums2 中对应位置的右边的第一个比 x 大的元素。如果不存在，对应位置输出-1。
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];
        Stack<Integer> num1Stack = new Stack<>();
        for (int i = nums1.length -1; i >= 0; i--) {
            num1Stack.push(nums1[i]);
        }

        //Stack<Integer> num2Stack = new Stack<>();
        int j = 0;
        while(num1Stack.size() != 0){
            int curr = num1Stack.pop();
            boolean flag = false;
            for (int i =  0; i < nums2.length; i++) {
                if (curr == nums2[i]) {
                   flag = true;
                }

                if (flag && nums2[i] > curr) {
                   result[j] = nums2[i];
                   break;
                }

                if (i == nums2.length-1 && result[j] == 0) {
                    result[j] = -1;
                }
            }
            j++;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] a = new int[]{4,1,2};
        int[] b = new int[]{1,3,4,2};
        int[] c = nextGreaterElement(a, b);
        for (int curr : c) {
            System.out.println(curr);
        }
    }
}
