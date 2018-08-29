package com.ps.stack.Impl;

import com.ps.stack.ArrayStack;

/**
 * @Author:panshuang
 * @Data:2018/8/29 23:06
 * @Description:栈测试
 */
public class ArrayStackTest {

    public static void  main(String[] args) {
        ArrayStack<Integer> stack = new ArrayStackImpl<>();

        for (int i = 0; i < 5; i++) {
            stack.push(i);
            System.out.println(stack);
        }

        stack.pop();
        System.out.println(stack);
    }
}
