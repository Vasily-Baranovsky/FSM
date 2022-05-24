package Algorithms;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ArrayQueueTest {

    @Test
    void smokeTest() {
        ArrayQueue arrayQueue = new ArrayQueue(10);
        testOneCycle(arrayQueue, arrayQueue.capacity, 100);
        testOneCycle(arrayQueue, arrayQueue.capacity/2, 200);
        testOneCycle(arrayQueue, arrayQueue.capacity-1, 300);

    }

    private void testOneCycle(ArrayQueue arrayQueue, int cycleSize, int addendum) {
        for (int i = 0; i < cycleSize; i++) {
            assertTrue(arrayQueue.add(i + addendum));
            System.out.println(arrayQueue);
        }
        if(arrayQueue.queueLength == arrayQueue.capacity){
            assertFalse(arrayQueue.add(111));
        }
        for (int i = 0; i < cycleSize; i++) {
            try{
                int peekedValue = arrayQueue.peek();
                int gotValue = arrayQueue.get();
                assertEquals(gotValue, i+addendum);
                assertEquals(peekedValue, gotValue);
                System.out.print("peekedValue: " + peekedValue + ";  ");
            } catch (QueueIsEmptyException e) {
                Assertions.fail();
            }
            System.out.println(arrayQueue);
        }
        try {
            arrayQueue.get();
            Assertions.fail();
        } catch (QueueIsEmptyException e) {
            System.out.println("When queue is empty we've got an exception. All is OK");
        }
    }
}

