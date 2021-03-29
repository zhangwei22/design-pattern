package com.example.algorithm.list.inversion;

import com.example.algorithm.common.entity.SingleNode;

public class reverseList {

    /**
     * 实现一：递归反转
     */
    public static SingleNode reverse1(SingleNode head) {
        if (head == null || head.getNext() == null) {
            // head为空链，或当前节点在尾结点，则直接返回
            return head;
        }
        // 先反转后续结点head.getNext
        SingleNode reHead = reverse1(head.getNext());
        // 将当前结点的指针指向前一结点
        head.getNext().setNext(head);
        // 前一结点的指针域置为null
        head.setNext(null);
        // 返回反转后新链表的头结点
        return reHead;
    }

    /**
     * 实现二：遍历反转
     */
    public static SingleNode reverse2(SingleNode head) {
        if (head == null) {
            return head;
        }
        // 上一结点
        SingleNode preNode = head;
        // 当前结点
        SingleNode curNode = head.getNext();
        // 临时结点,用于保存当前结点的指针域（即下一结点）
        SingleNode tmpNode;
        // 当前结点为空，说明位于尾结点
        while (curNode != null) {
            tmpNode = curNode.getNext();
            curNode.setNext(preNode);
            // 指针往下移动
            preNode = curNode;
            curNode = tmpNode;
        }
        // 最后将原链表的头结点指针域置为null，换回新链表的头结点，即原链表的尾结点
        head.setNext(null);

        return preNode;
    }

    public static void main(String[] args) {
        SingleNode head = new SingleNode(0);
        SingleNode node1 = new SingleNode(1);
        SingleNode node2 = new SingleNode(2);
        SingleNode node3 = new SingleNode(3);
        head.setNext(node1);
        node1.setNext(node2);
        node2.setNext(node3);

        // 打印反转前的node
        SingleNode h = head;
        while (h != null) {
            System.out.print(h.getData() + ",");
            h = h.getNext();
        }

//        head = reverse1(head);
        head = reverse2(head);
        System.out.print("\n*****************反转后*****************\n");

        SingleNode rh = head;
        while (rh != null) {
            System.out.print(rh.getData() + ",");
            rh = rh.getNext();
        }

    }

}
