package Algorithms;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

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

    @Test
    void sumTwoElements() {
        LinkedList firstList = new LinkedList(new int[]{1, 2, 3, 4, 5, 9, 1, 9, 1});
        System.out.println(firstList);

        LinkedList secondList = new LinkedList(new int[]{5, 9, 3, 5, 7});
        System.out.println(secondList);

        LinkedList result = LinkedList.addLists(firstList, secondList);
        System.out.println(result);
    }

    @Test
    void isPalindrome() {
        LinkedList trueCase = new LinkedList(new int[] {1, 2, 3, 2, 1});
        assertTrue(trueCase.isPalindrome());
        System.out.println(trueCase);

        LinkedList falseCase = new LinkedList(new int[] {1, 2, 3, 4, 5});
        assertFalse(falseCase.isPalindrome());
        System.out.println(falseCase);

        LinkedList oneElement = new LinkedList(new int[] {1});
        assertFalse(falseCase.isPalindrome());
        System.out.println(oneElement);

        LinkedList twoElements = new LinkedList(new int[] {1,1});
        assertFalse(falseCase.isPalindrome());
        System.out.println(twoElements);
    }
    @Test
    void findIntersection () {
        LinkedList firstList = new LinkedList(new int[] {1,2,3,4,5,6,7});
        LinkedList secondList = new LinkedList(new int[] {-1,-2,-3});

        Node secondListConnector = secondList.head;
        while (secondListConnector.next!=null) {
            secondListConnector = secondListConnector.next;
        }
        secondListConnector.next = firstList.head.next;

        System.out.println(firstList);
        System.out.println(secondList);
        System.out.println(firstList.findIntersection(secondList).value);
    }


    private static class ListWithLoop {
        LinkedList list;
        Node loopStart;

        ListWithLoop(LinkedList list, Node loopStart) {
            this.list = list;
            this.loopStart = loopStart;
        }


        public static ListWithLoop[] getManualExamples () {
            ListWithLoop[] testDataArray = new ListWithLoop[1];
            LinkedList list1 = new LinkedList(new int[]{1, 2, 3, 4, 5, 6});
            Node loopStart1 = list1.getKthFromTail(4);
            list1.addToTail(loopStart1);
            testDataArray[0] = new ListWithLoop(list1, loopStart1);
            return testDataArray;
        }
    }

    @Test
    void findLoopStart() {
        for (ListWithLoop listWithLoop: ListWithLoop.getManualExamples()) {
            assertTrue(listWithLoop.loopStart == listWithLoop.list.findLoopStart());
            System.out.println(listWithLoop.loopStart.value);
        }
    }
}