public class Main {
    public static void main(String[] args) {

        Calculator calculator1 = new Calculator(1);
        calculator1.pressPowerBtn();

        User user = new User();
        user.returnResultUsingCalculator(calculator1, "*213-132");

    }
}
