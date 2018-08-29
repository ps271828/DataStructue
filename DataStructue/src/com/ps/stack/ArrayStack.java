package com.ps.stack;

/**
 * @Author:panshuang
 * @Data:2018/8/29 22:34
 * @Description:ջ�ӿڣ�ջ�ĺ��ķ���ֻ����������ջ��ջ�Լ��鿴ջ��
 */
public interface ArrayStack <T> {

    /**
     * ��ջ
     */
     void push(T t);

    /**
     * ��ջ
     * @return
     */
    T pop();

    /**
     * �鿴ջ��Ԫ��
     * @return
     */
    T peek();

    /**
     * ��ȡջ�Ĵ�С
     * @return
     */
    int getSize();

    /**
     * �Ƿ�Ϊ�գ��˷�������ջ�ı�Ҫ����
     * @return
     */
    boolean isEmpty();
}
