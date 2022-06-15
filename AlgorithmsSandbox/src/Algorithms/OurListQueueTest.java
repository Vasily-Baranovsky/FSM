package Algorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OurListQueueTest {
    @Test
    void smokeTest(){
        OurListQueue queue = new OurListQueue();

        for (int i=0; i<10; i++) {
            queue.add(i);
            System.out.println(queue);
        }

        for (int i=0; i<10; i++) {
            try {
                System.out.print("peek:" + queue.peek()+ "; ");
                System.out.println("pop: " + queue.remove());
            } catch (QueueIsEmptyException e) {
                fail("Queue is empty, when should not");
            }
        }

        try {
            queue.remove();
            fail("queue does not throw exception, when it is empty");
        } catch (QueueIsEmptyException e) {
            System.out.println("Remove on empty throws exception");
        }

        try {
            queue.peek();
            fail("queue does not throw exception, when it is empty");
        } catch (QueueIsEmptyException e) {
            System.out.println("Peek on empty throws exception");
        }
    }
}