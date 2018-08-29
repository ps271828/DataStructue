package com.ps.stack;

/**
 * @Author:panshuang
 * @Data:2018/8/29 22:34
 * @Description:栈接口，栈的核心方法只有三个，进栈出栈以及查看栈顶
 */
public interface ArrayStack <T> {

    /**
     * 入栈
     */
     void push(T t);

    /**
     * 出栈
     * @return
     */
    T pop();

    /**
     * 查看栈顶元素
     * @return
     */
    T peek();

    /**
     * 获取栈的大小
     * @return
     */
    int getSize();

    /**
     * 是否为空，此方法不是栈的必要操作
     * @return
     */
    boolean isEmpty();
}
