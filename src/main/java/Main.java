public class Main {
    public static void main(String[] args) {
        System.out.println("hello");

        Calculator calculator1 = new Calculator(1);
        calculator1.pressPowerBtn();
//        calculator1.pressPowerBtn();
//        calculator1.pressPowerBtn();

        User user = new User();
        System.out.println(user.returnResultUsingCalculator(calculator1, "213"));


//        구현 기능 목록
//
//        계산기를 켠다.
//
//        계산기가 켜져 있을 때만 사용자들은 연산을 수행할 수 있다. 계산기가 켜져 있지 않은 경우, 예외를 사용해 계산기가 켜져 있지 않음을 알린다. 계산기가 꺼질 때 내부 값을 전부 지운다. 각 계산기는 서로 다른 값을 갖는다. 초기값은 0이다. 연산이 올바른 양식인지를 확인한다.
//
//        숫자와 (,),+,-,*,/ 이외에 다른 값이 있으면 연산을 실행하지 않는다. (여기서 확인해주는게 맞을까라는 의문이 생김. 뒤에서 연산 과정에서 오류를 발생시키는 게 더 효율적일까?) 괄호로만 이루어진 연산은 잘못된 양식이다. 입력한 문자열이 숫자로 시작하는 경우, 기존의 값을 지우고 해당 연산을 실행한다. 입력한 문자열이 연산기호로 시작하는 경우, 기존의 값을 가장 왼쪽의 값으로 포함시켜 문자열을 만들어준다. 계산기를 통해 계산을 한다.
//
//        입력값이나 연산 결과가 너무 크거나 작은 경우, 결과값이 범위를 벗어났음을 알린다. 사용자는 계산을 통해 나온 값을 저장한다.
//
//        각 사용자는 서로 다른 값을 갖는다.


    }
}
