package FSMSandbox;

public class FSMSanbox {
    public static void main(String[] args) {
        String input = "12.563 ";

        IntegerFSM fsm = new IntegerFSM();

        for (int i = 0; i < input.length(); i++) {
            if (fsm.switchState(input.substring(i, i+1))) {
                break;
            }
        }

        System.out.println(fsm.getState());
        System.out.println(fsm.getResult());

    }
}
