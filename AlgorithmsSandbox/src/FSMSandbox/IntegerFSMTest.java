package FSMSandbox;

import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.*;

class IntegerFSMTest {

    //test correct reading of integer and decimal
    //test correct syntax error processing
    private int numberOfCases = 10000;


    private void testSingleValue() {
        TestInput testInput = TestInput.getTestInput();
        IntegerFSM fsm = new IntegerFSM();

        for (int i = 0; i < testInput.inputString.length(); i++) {
            if (fsm.switchState(testInput.inputString.substring(i, i+1))) {
                break;
            }
        }

        if(fsm.getState() == IntegerFSM.State.END_OF_READING) {
            Assertions.assertTrue(testInput.isCorrect);
        }
    }


    @org.junit.jupiter.api.Test
    void switchState() {

        for (int i = 0; i <= numberOfCases; i++) {
            testSingleValue();
        }
    }
}