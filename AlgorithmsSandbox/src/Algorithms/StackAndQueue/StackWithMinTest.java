package Algorithms.StackAndQueue;

import Algorithms.StackIsEmptyException;
import org.junit.jupiter.api.Test;

import java.rmi.MarshalException;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class StackWithMinTest {
    private static class ValueAndMinContainer {
        int value;
        int minimum;

        ValueAndMinContainer (int value, int minimum) {
            this.value = value;
            this.minimum = minimum;
        }
    }


    @Test
    void push() {
        generalTest();
    }

    @Test
    void getMin() {
        generalTest();
    }

    @Test
    void pop() {
        generalTest();
    }

    @Test
    void peek() {
        generalTest();
    }

    @Test
    void isEmpty() {
        generalTest();
    }


    private void generalTest() {
        StackWithMin stack = new StackWithMin();

        ValueAndMinContainer[] testData = generateTestArray(10);
        for (int i=0; i < testData.length; i++) {
            stack.push(testData[i].value);

            try {
                assertEquals(stack.peek(), testData[i].value);
                assertEquals(stack.getMin(), testData[i].minimum);
            } catch (StackIsEmptyException e) {
                fail();
            }
        }

        for (int i=testData.length-1; i >= 0; i--) {
            try {
                assertEquals(testData[i].minimum, stack.getMin());
                assertEquals(testData[i].value, stack.pop());
            } catch (StackIsEmptyException e) {
                fail();
            }
        }

        assertTrue(stack.isEmpty());
    }


    private ValueAndMinContainer[] generateTestArray(int numberOfTestElements) {
        int currentMin = Integer.MAX_VALUE;
        ValueAndMinContainer[] testValues = new ValueAndMinContainer[numberOfTestElements];

        for (int i=0; i < numberOfTestElements; i++) {
            int value = (int)(Math.random()*Integer.MAX_VALUE);

            currentMin = Math.min(currentMin, value);

            testValues[i] = new ValueAndMinContainer(value, currentMin);
        }
        return testValues;
    }

}