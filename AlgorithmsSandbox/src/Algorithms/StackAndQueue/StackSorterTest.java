package Algorithms.StackAndQueue;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackSorterTest {

    @Test
    public void testStackSort() throws StackOverflowException, StackIsEmptyException {
        ArrayStack stack = new ArrayStack(10);
        stack.push(5);
        stack.push(6);
        stack.push(3);
        stack.push(2);
        stack.push(1);
        stack.push(4);

        System.out.println(stack);
        StackSorter.sortStack(stack);
        System.out.println(stack);
    }
}