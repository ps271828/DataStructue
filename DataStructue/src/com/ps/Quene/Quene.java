package com.ps.Quene;

/**
 * @Author:panshuang
 * @Data:2018/9/2 08:53
 * @Description:队列接口
 */
public interface Quene <T> {

    /**
     * 入队
     */
    void enQuene(T t);

    /**
     * 出队   时间复杂度  O（n）
     */
    T deQuene();

    /**
     * 查看队首
     */
    T getFront();

    /**
     * 获取size
     */
    Integer getSize();

    /**
     * 是否为空
     */
    boolean isEmpty();
}
