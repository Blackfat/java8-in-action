package com.blackfat.algorithm;

/**
 * @author wangfeiyang
 * @desc
 * @create 2019/1/29-14:12
 */
public class LinkedListAlgo {

    public static Node createNode(int value) {
        return new Node(value, null);
    }

    public static class Node {
        private int data;
        private Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        public int getData() {
            return data;
        }
    }

    // 单链表反转
    public static Node reverse(Node list){
        Node headNode = null;// 反转后的头结点

        Node  currentNode = list;

        Node previousNode = null; //当前节点的前一个节点

        while(currentNode != null){
            Node nextNode = currentNode.next;
            if(nextNode == null){
                headNode = currentNode;
            }
            currentNode.next = previousNode;
            previousNode = currentNode;
            currentNode = nextNode;

        }
        return headNode;
    }

    // 检测环
    public static boolean checkCircle(Node list){
        if(list == null) {
            return false;
        }
        Node  fast = list.next;
        Node  slow = list;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;

            if (slow == fast) return true;
        }
        return false;
    }

    // 有序链表合并
    public static Node mergeSortedLists(Node la, Node lb){
        if (la == null) return lb;
        if (lb == null) return la;

        Node head = null;
        if (la.data <= lb.data){
            head = la;
            head.next = mergeSortedLists(la.next, lb);
        } else {
            head = lb;
            head.next = mergeSortedLists(la, lb.next);
        }
        return head;
    }

    // 删除倒数第k个节点
    public static Node deleteLastKth(Node list, int k){
        Node fast = list;
        int i = 1;
        while(fast != null && i < k){
            fast = fast.next;
            ++i;
        }

        if(fast == null){
            return null;
        }

        // 找到第k个节点
        Node slow = list;
        Node prev = null;
        while (fast.next != null) {
            fast = fast.next;
            prev = slow;
            slow = slow.next;
        }

        // 删除第k个节点
        if (prev == null) {
            list = list.next;
        } else {
            prev.next = prev.next.next;
        }
        return list;
    }

    // 求中间节点
    public static Node findMiddleNode(Node list){
        if (list == null) return null;

        Node fast = list;
        Node slow = list;

        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }



}
