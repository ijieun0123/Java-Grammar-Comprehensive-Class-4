import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        boolean calculateEnded = false;
        Scanner scanner = new Scanner(System.in);

        // 구현 2
        while(!calculateEnded){
            try{
                CalculatorApp calculatorApp = new CalculatorApp();
                calculatorApp.start();

                System.out.println("계산기를 종료하시겠습니까 ? ( exit )");
                String isExit = scanner.next();
                if(isExit.equals("exit")){
                    System.out.println("계산기를 종료합니다.");
                    calculateEnded = true;
                }
            } catch (BadInputException e){
                System.out.println(e.getMessage());
            } catch (ArithmeticException e){
                System.out.println("0으로 나누기를 할 수 없습니다.");
            }
        }
    }
}