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

    @Test
    void isIntersection() {
        LinkedList list1 = new LinkedList(new int[] {1, 2, 3, 4, 5});
        System.out.print("List1: ");
        System.out.println(list1);
        LinkedList list2 = new LinkedList(new int[] {11, 12, 13, 14, 15});
        list2.addToTail(list1.getKthFromTail(3));
        System.out.print("List2: ");
        System.out.println(list2);

        Node intersectionNode = list1.areListsIntersect(list2);
        System.out.print("Intersection node list1 and list2: ");
        System.out.println(intersectionNode);

        intersectionNode = list2.areListsIntersect(list1);
        System.out.print("Intersection node list2 and list1: ");
        System.out.println(intersectionNode);

        LinkedList list3 = new LinkedList(new int[] {21, 22, 23, 24, 25});
        list3.addToTail(list1.head);
        System.out.print("List3: ");
        System.out.println(list3);

        intersectionNode = list1.areListsIntersect(list3);
        System.out.print("Intersection node list1 and list3: ");
        System.out.println(intersectionNode);

        LinkedList list4 = new LinkedList(new int[] {31});
        list4.addToTail(list1.getKthFromTail(4));
        System.out.print("List4: ");
        System.out.println(list4);

        intersectionNode = list1.areListsIntersect(list4);
        System.out.print("Intersection node list1 and list4: ");
        System.out.println(intersectionNode);

        intersectionNode = list4.areListsIntersect(list1);
        System.out.print("Intersection node list4 and list1: ");
        System.out.println(intersectionNode);
    }

    @Test
    void findLoop() {
        MarkedLinkedList list = new MarkedLinkedList(1);
        list.addToTail(new MarkedNode(2, null));
        MarkedNode nd = new MarkedNode(3, null);
        list.addToTail(nd);
        list.addToTail(new MarkedNode(4, null));
        list.addToTail(new MarkedNode(5, null));
        list.addToTail(new MarkedNode(6, null));
        list.addToTail(new MarkedNode(7, nd));

        MarkedNode result = list.findLoop();
        System.out.println("Loop starts at node: " + result);
        System.out.println(list);
    }
}