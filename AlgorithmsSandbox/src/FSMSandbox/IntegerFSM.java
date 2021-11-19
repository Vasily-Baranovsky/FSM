package FSMSandbox;

public class IntegerFSM {
    enum State {
        TRIM, READ_INTEGRAL, READ_DECIMAL, SYNTAX_ERROR, END_OF_READING
    }

    private State state = State.TRIM;
    private double result=0;

    public void reset() {
        state = State.TRIM;
        result = 0;
    }

    public IntegerFSM() {
        reset();
    }

    // return true, if state is final
    boolean switchState(String inputChar)  {
        switch (state) {
            case TRIM:
                if (inputChar.equals(" ")) {
                    state = State.TRIM;
                }
                else if (inputChar.matches("[0-9]")) {

                }
                break;
            case READ_INTEGRAL:
                break;
            case READ_DECIMAL:
                break;
            case SYNTAX_ERROR:
            case END_OF_READING:
                throw new RuntimeException("FSM already in final state");
        }

        return state == State.END_OF_READING || state == State.SYNTAX_ERROR;
    }
}
