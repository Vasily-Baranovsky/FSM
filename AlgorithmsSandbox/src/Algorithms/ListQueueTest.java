package Algorithms;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class ListQueueTest {
    @Test
    void smokeTest () {
        ListQueue queue = new ListQueue();

        System.out.println("IsEmpty: " + queue.isEmpty());

        for (int i = 0; i<10; i++) {
            queue.add(i);
            System.out.println(queue);
        }

        for (int i = 9; i>=0; i--) {
            try {
                System.out.println("IsEmpty: " + queue.isEmpty() + "; value:" + queue.remove() + "; queue" + queue);
            } catch (QueueIsEmptyException e) {
                System.out.println();
                Assertions.fail("Queue is empty");
            }
        }

        System.out.println("IsEmpty: " + queue.isEmpty());

        try {
            queue.remove();
            Assertions.fail("Queue is not empty");
        } catch (QueueIsEmptyException e) {
            System.out.println("Queue is empty");
        }



    }
}
