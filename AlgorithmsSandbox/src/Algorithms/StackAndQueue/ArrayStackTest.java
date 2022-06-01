package Algorithms.StackAndQueue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

// TODO: 31.05.2022 дописать toString and tests for peek, isEmpty, pop

class ArrayStackTest {
    ArrayStack arrayStack;

    @BeforeEach
    public void setUp() {
        arrayStack = new ArrayStack(5);
    }

    @Test
    public void push_test() {
        assertTrue(arrayStack.isEmpty());
        try {
            arrayStack.push(1);
            arrayStack.push(2);
            arrayStack.push(3);
            arrayStack.push(4);
            arrayStack.push(5);
            System.out.println("All elements have been added!");
        } catch (StackOverflowException e) {
            fail();
        }
        try {
            arrayStack.push(6);
            fail();
        } catch (StackOverflowException e) {
            System.out.println("Stack overflow!");
        }
    }

    @Test
    public void pop_test() {
        push_test();
        try {
            assertEquals(5,arrayStack.pop());
        } catch (StackIsEmptyException e) {
            fail();
        }

    }

}
