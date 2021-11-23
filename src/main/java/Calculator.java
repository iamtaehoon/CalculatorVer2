public class Calculator {
    private int thisCalculatorsIndex;
    private Boolean turnOn = false;
    private int ans;

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
    }

    public boolean getPowerStatus() {
        return turnOn;
    }
}
