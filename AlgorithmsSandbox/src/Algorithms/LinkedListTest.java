package Algorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {

    private LinkedList generateTestSequentialList(int n) {
        LinkedList list = new LinkedList(0);
        for (int i=0; i<n; i++) {
            list.addToTail(i);
        }
        return list;
    }

    @Test
    void getKthFromTail() {
        for (int i=0; i<10; i++) {
            LinkedList list = generateTestSequentialList(i);
            for (int j=1; j<i; j++) {
                assertTrue(list.getKthFromTail(j).value==i-j);
                System.out.println(list.getKthFromTail(j) + "j = " + j);
            }
        }
    }

    @Test
    void partition() {
        LinkedList list = new LinkedList(1);
        list.addToTail(10);
        list.addToTail(8);
        list.addToTail(12);
        list.addToTail(2);
        list.addToTail(7);
        list.addToTail(2);
        list.addToTail(9);
        list.addToTail(3);

        System.out.println(list);

        list.partition(5);

        System.out.println(list);
    }
}