import java.util.ArrayList;

public class User {
    private ArrayList<Integer> answerList = new ArrayList<>();

    public int returnResultUsingCalculator(Calculator calculator, String operationYouEntered) {
        if (calculatorIsOn(calculator)) {
            return calculator.operateEntered(operationYouEntered);
        }
        throw new IllegalStateException("계산기의 전원이 켜지지 않았습니다");

    }

    private boolean calculatorIsOn(Calculator calculator) {
        return calculator.getPowerStatus();
    }
}
