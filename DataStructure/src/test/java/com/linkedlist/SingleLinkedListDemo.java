package com.linkedlist;

import org.junit.Test;

import java.util.LinkedList;

public class SingleLinkedListDemo {
    @Test
    public void test(){
        HeroNode a = new HeroNode(111, "a");
        HeroNode b = new HeroNode(2, "b");
        HeroNode c = new HeroNode(21, "c");
        HeroNode d = new HeroNode(15, "d");
        HeroNode g = new HeroNode(6, "g");
        HeroNode h = new HeroNode(700, "h");
        HeroNode i = new HeroNode(22, "i");
        HeroNode j = new HeroNode(98, "j");
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        SingleLinkedList singleLinkedList2=new SingleLinkedList();
//        singleLinkedList.add(a);
//        singleLinkedList.add(d);
//        singleLinkedList.add(c);
//        singleLinkedList.add(b);
        singleLinkedList.addByOrder(b);
        singleLinkedList.addByOrder(c);
        singleLinkedList.addByOrder(j);
        singleLinkedList.addByOrder(i);
        //singleLinkedList.list();
        singleLinkedList2.addByOrder(g);
        singleLinkedList2.addByOrder(h);
        singleLinkedList2.addByOrder(d);
        singleLinkedList2.addByOrder(a);
        //singleLinkedList2.list();
        HeroNode heroNode = mergeLinkedList(singleLinkedList.getHead(), singleLinkedList2.getHead());
        singleLinkedList.setHead(heroNode);
        singleLinkedList.list();
//        singleLinkedList.update(g);
//        singleLinkedList.delete(1);
//        singleLinkedList.delete(2);
//        singleLinkedList.delete(3);
//        singleLinkedList.delete(4);
//        singleLinkedList.list();
    }

//合并两个有序链表
    public static HeroNode mergeLinkedList(HeroNode head1, HeroNode head2) {
        if (head1 == null && head2 == null) {
            return null;
        }
        if (head1 == null) return head2;
        if (head2 == null) return head1;
        HeroNode newHeroNode = new HeroNode(0, "");
        HeroNode cur = newHeroNode;
        HeroNode cur1 = head1.next;
        HeroNode cur2 = head2.next;
        while (cur1 != null && cur2 != null) {

            if (cur1.no < cur2.no) {
                cur.next = cur1;
                cur1 = cur1.next;
            } else {
                cur.next = cur2;
                cur2 = cur2.next;
            }
            cur = cur.next;
        }
        if (cur1 != null) cur.next = cur1;
        else cur.next = cur2;
        return newHeroNode;
    }

}

