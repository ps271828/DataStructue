package com.ps.Quene.Impl;

import com.ps.Quene.Quene;

/**
 * @Author:panshuang
 * @Data:2018/9/2 09:42
 * @Description:
 */
public class QueneTest {
    public static void main(String[] args) {
        Quene<Integer> quene = new QueneImpl<>(10);

        for (int i = 0; i < 10; i++) {
           quene.enQuene(i);
           if (i % 3 == 1) {
               quene.deQuene();
           }
            System.out.println(quene.toString());
        }
    }
}
