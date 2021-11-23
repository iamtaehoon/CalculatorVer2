import java.util.regex.Pattern;

public class Calculator {
    private int thisCalculatorsIndex;
    private Boolean turnOn = false;
    private int ans = 0;
    String operation;

    public Calculator(int thisCalculatorsIndex) {
        this.thisCalculatorsIndex = thisCalculatorsIndex;
    }



    public void pressPowerBtn() {
        turnOn = !turnOn;
        printCalculatorStatus();
    }

    private void printCalculatorStatus() {
        if (turnOn) {
            System.out.println(thisCalculatorsIndex +"번 계산기의 전원이 켜졌습니다.");
            return;
        }
        System.out.println(thisCalculatorsIndex +"번 계산기의 전원이 꺼졌습니다.");
        resetCalculatorAns();
    }

    private void resetCalculatorAns() { // resetCalculator 가 더 나은 함수명일 수 있음. 마지막에 고민해주자.
        ans = 0;
    }

    public boolean getPowerStatus() {
        return turnOn;
    }

    public int operate(String operationYouEntered) {
        String operationAfterPreProcessing = preProcessingAboutOperation(operationYouEntered);
        System.out.println("operationAfterPreProcessing = " + operationAfterPreProcessing);
        return ans;
    }

    private String preProcessingAboutOperation(String operation) {
        this.operation = operation;
        checkInvalidChar(operation);
        //문자열이 만약 *,/,+,- 로 시작하면 ans를 앞에 붙여줘야한다.
        operation = addInitialValueIfSymbolStart();
        return operation + "=";
    }

    private String addInitialValueIfSymbolStart() {
        if (firstIs("*") || firstIs("/") || firstIs("+") || firstIs("-")) {
            return Integer.toString(ans) + operation;
        }
        return operation;

    }

    private boolean firstIs(String symbol) {
        return operation.substring(0, 1).equals(symbol);
    }

    private void checkInvalidChar(String operation) {
        String patterns = "^[0-9|\\+|\\-|\\*|\\/|\\(|\\)]*$";
        boolean containInvalidChar = !Pattern.matches(patterns, operation);
        if (containInvalidChar) {
            throw new IllegalArgumentException("0~9, +,-,*,/,(,) 이외의 문자가 입력되었습니다.");
        }
    }
}
