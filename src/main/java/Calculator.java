import java.util.ArrayList;
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

    public int operateEntered(String operationYouEntered) {
        String operationAfterPreProcessing = preprocessingAboutOperation(operationYouEntered);
        System.out.println("operationAfterPreProcessing = " + operationAfterPreProcessing);
        //TODO 각 기호랑 인자를 나눠준다.
        //TODO 나눈 값을 큐에 넣어준다.
        //TODO 곱/나눗셈을 먼저 진행해주고, 이후에 덧/뺄셈을 진행한다. 만약 두개의 인자 중 계산이 완료되지 않은 값이 있으면 계산을 완료시킨다.
        //TODO 잘못된 값으로 계산을 할 수 없으면 IllegalArgument를 띄워준다.
        operateAfterPreprocessing(operationAfterPreProcessing); //TODO 이름을 어떻게 지어줘야 할지 고민이 많이 됨.
        return ans;
    }

    private int operateAfterPreprocessing(String operationAfterPreProcessing) {
        operationAfterPreProcessing += "=";
        ArrayList<String> factorList = new ArrayList<>();
        ArrayList<Character> symbolList = new ArrayList<>();
        int operationLength = operationAfterPreProcessing.getBytes().length;

        int first = 0;
        int last;
        int bracketLevel = 0;

        for (int i = 0; i < operationLength; i++) {
            char c = operationAfterPreProcessing.charAt(i);
            last = i;
            if (c == '(') {
                if (bracketLevel == 0) {
                    first = i;
                }
                bracketLevel += 1;
                continue;
            }
            if (c == ')') {
                bracketLevel -= 1;
            }

            if ((bracketLevel == 0) & (c == '+' || c == '-' || c == '*' || c == '/' || c == '=')) {
                last = i;
//                if (first == last) {
//                    System.out.println("오류 -> 기호 사이에 숫자가 있지 않음");
//                }
                String factor = operationAfterPreProcessing.substring(first, last);

                factorList.add(factor);
                symbolList.add(c);
                first = i + 1;
            }
        }

        for (String s : factorList) {
            System.out.println("s = " + s);
        }
        for (Character character : symbolList) {
            System.out.println("character = " + character);
        }

        return 0;
    }


    private String preprocessingAboutOperation(String operation) {
        this.operation = operation;
        checkInvalidChar(operation);
        //문자열이 만약 *,/,+,- 로 시작하면 ans를 앞에 붙여줘야한다.
        operation = addInitialValueIfSymbolStart();
        return operation; // =이 여기서 들어가면 안될 거 같음.
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
