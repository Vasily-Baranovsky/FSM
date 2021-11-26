package FSMSandbox;

public class IntegerFSM {
    enum State {
        TRIM, READ_INTEGRAL, READ_DECIMAL, SYNTAX_ERROR, END_OF_READING
    }

    private State state = State.TRIM;
    private double result=0;
    private int nextDecimalPosition = 1;

    public void reset() {
        state = State.TRIM;
        result = 0;
        nextDecimalPosition = 1;
    }

    public double getResult() {
        if(state == State.END_OF_READING) {
            return result;
        } else throw new RuntimeException("FSM not in a final state");
    }

    public State getState() {
        return state;
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
                    result = Double.parseDouble(inputChar);
                    state = State.READ_INTEGRAL;
                } else {
                    state = State.SYNTAX_ERROR;
                }
                break;
            case READ_INTEGRAL:
                if(inputChar.matches("[0-9]")) {
                    result = result * 10 + Double.parseDouble(inputChar);
                    state = State.READ_INTEGRAL;
                } else if(inputChar.equals(" ")) {
                    state = State.END_OF_READING;
                } else if(inputChar.equals(".")) {
                    state = State.READ_DECIMAL;
                } else {
                    state = State.SYNTAX_ERROR;
                }
                break;
            case READ_DECIMAL:
                if(inputChar.matches("[0-9]")) {
                    result = result + Double.parseDouble(inputChar)/Math.pow(10, nextDecimalPosition);
                    nextDecimalPosition++;
                    state = State.READ_DECIMAL;
                } else if(inputChar.equals(" ")) {
                    state = State.END_OF_READING;
                }  else {
                    state = State.SYNTAX_ERROR;
                }
                break;
            case SYNTAX_ERROR:
                throw new RuntimeException("FSM is already in syntax error state");
            case END_OF_READING:
                throw new RuntimeException("FSM already in final state");
        }

        return state == State.END_OF_READING || state == State.SYNTAX_ERROR;
    }
}
