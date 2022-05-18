package Algorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OurListStackTest {
    @Test
    void smokeTest(){
        OurStack stack = new OurListStack();

        for (int i=0; i<10; i++) {
            stack.push(i);
            System.out.println(stack);
        }

        for (int i=0; i<10; i++) {
            try {
                System.out.print("peek:" + stack.peek()+ "; ");
                System.out.println("pop: " + stack.pop());
            } catch (StackIsEmptyException e) {
                fail("Stack is empty, when should not");
            }
        }

        try {
            stack.pop();
            fail("stack does not throw exception, when it is empty");
        } catch (StackIsEmptyException e) {
            System.out.println("Pop on empty throws exception");
        }

        try {
            stack.peek();
            fail("stack does not throw exception, when it is empty");
        } catch (StackIsEmptyException e) {
            System.out.println("Peek on empty throws exception");
        }
    }
}