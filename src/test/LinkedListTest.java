package src.test;

import java.util.LinkedList;

public class LinkedListTest {
    void test(){
        //底层是双链表
        LinkedList<Integer> nums = new LinkedList<>();
        LinkedList<String> strings = new LinkedList<>();
        boolean flag = nums.isEmpty();
        int size = nums.size();
        boolean exist = nums.contains(1);
        boolean bResult = nums.add(1);
        nums.addLast(2);
        nums.addFirst(3);
        int first = nums.removeFirst();
        int last = nums.removeLast();

    }
}
