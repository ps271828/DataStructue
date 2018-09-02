package com.ps.stack;

/**
 * @Author:panshuang
 * @Data:2018/8/29 22:34
 * @Description:栈相关操作接口
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
     * 获取栈大小
     * @return
     */
    int getSize();

    /**
     * 判断栈是否为空
     * @return
     */
    boolean isEmpty();
}
