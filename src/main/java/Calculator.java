import java.util.regex.Pattern;

public class Calculator {
    private int thisCalculatorsIndex;
    private Boolean turnOn = false;
    private int ans = 0;

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
        ans = 0; // 이걸 ans = 0 으로 놔두는 것보다 꺼진 경우 상태로 만들어서 빼주는 게 나을지 / 아니면 어차피 한줄이니까 그냥 안만드는게 나을지..?
    }

    public boolean getPowerStatus() {
        return turnOn;
    }

    public int operate(String operationYouEntered) {
        //문자열이 제대로 된건지 확인한다.
        checkThisOperationIsCorrect(operationYouEntered);
        return ans;
    }

    private int checkThisOperationIsCorrect(String operation) {
        // ^[0-9]*$
        checkInvalidChar(operation);
        return 1;
    }

    private void checkInvalidChar(String operation) {
        String patterns = "^[0-9|\\\\+|-|\\\\*|/]*$";
        boolean containInvalidChar = !Pattern.matches(patterns, operation);
        if (containInvalidChar) {
            throw new IllegalArgumentException("0~9, +,-,*,/ 이외의 문자가 입력되었습니다.");
        }
    }
}
