package com.example.algorithm.common.entity;

/**
 * 单向链表节点
 */
public class SingleNode {
    //数据域
    private int data;
    //指针域
    private SingleNode next;

    public SingleNode(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public SingleNode getNext() {
        return next;
    }

    public void setNext(SingleNode next) {
        this.next = next;
    }
}
