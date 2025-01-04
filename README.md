# 자바 문법 종합반 4 week 과제

-----

## 계산기 예외 처리하기

----------------

### 3주차에 완성한 계산기 프로젝트에 예외처리를 추가해봅시다.
### 기존 프로젝트에 아래 파일을 반영해주세요.

### 변경됨 - Main.java (숙제 - 구현 2)

    public class Main {
        public static void main(String[] args) {
            boolean calculateEnded = false;
            // 구현 2.
        }
    }

### 변경됨 - Calculator.java

    public class Calculator {
        private int firstNumber;
        private int secondNumber;
    
        private AbstractOperation operation;
    
        public Calculator(AbstractOperation operation) {
            this.operation = operation;
        }
    
        public Calculator() {
        }

        public void setOperation(AbstractOperation operation) {
            this.operation = operation;
        }
    
        public void setFirstNumber(int firstNumber) {
            this.firstNumber = firstNumber;
        }
    
        public void setSecondNumber(int secondNumber) {
            this.secondNumber = secondNumber;
        }

        public double calculate() {
            double answer = 0;
            answer = operation.operate(this.firstNumber, this.secondNumber);
            return answer;
        }

    }

### 신규 1. BadInputException.java

    public class BadInputException extends Exception {
        public BadInputException(String type) {
            super("잘못된 입력입니다! " + type + "을 입력해주세요!");
        }
    }

### 신규 2. Parser.java (숙제 - 구현 1)

    import java.util.regex.Pattern;
    
    public class Parser {
        private static final String OPERATION_REG = "[+\\-*/]";
        private static final String NUMBER_REG = "^[0-9]*$";
    
        private final Calculator calculator = new Calculator();
    
        public Parser parseFirstNum(String firstInput) {
                    // 구현 1.
    
        }
    
        public Parser parseSecondNum(String secondInput) {
                    // 구현 1.
        }
    
        public Parser parseOperator(String operationInput) {
           // 구현 1.
        }
    
        public double executeCalculator() {
            return calculator.calculate();
        }
    }

### 신규 3. CalculatorApp.java
    import java.util.Scanner;
    
    public class CalculatorApp {

        public static boolean start() throws Exception{
            Parser parser = new Parser();
            Scanner scanner = new Scanner(System.in);
    
            System.out.println("첫번째 숫자를 입력해주세요!");
            String firstInput = scanner.nextLine();
            parser.parseFirstNum(firstInput);
    
            System.out.println("연산자를 입력해주세요!");
            String operator = scanner.nextLine();
            parser.parseOperator(operator);
    
            System.out.println("두번째 숫자를 입력해주세요!");
            String secondInput = scanner.nextLine();
            parser.parseSecondNum(secondInput);
    
            System.out.println("연산 결과 : " + parser.executeCalculator());
            return true;
        }


    }


### 숙제 설명

구현 1, 구현2로 주석 처리된 부분을 직접 구현해 주세요<br/>
추가된 BadInputException은 우리가 이번 과제에서 사용할 예외입니다.<br/>
추가된 CalculatorApp은 우리의 계산기를 실행시켜주는 클래스입니다.<br/>
Parser는 유저의 입력을 받아서 우리가 지난주에 구현한 계산기의 로직으로 전환시켜주는 객체입니다.<br/>
우리는 주로 Parser를 구현할 예정입니다.<br/>
우리는 유저의 입력을 String으로만 받아야 합니다.<br/>
입력받은 String을 숫자나 연산자로 변환하기 위해서 꼭! 예외 처리를 해야 합니다.<br/>
해당 예외 처리를 하기 위해서는 Pattern.match() 메서드가 필요합니다. 해당 부분은 검색하면 알 수 있습니다.<br/>
Pattern.match() 메서드를 사용하기 위한 정규식 표현은 코드 내에 제공되어 있습니다.<br/>
예외는 이미 구현된 BadInputException 객체를 사용합니다.<br/>
예외를 어디에 구현할지는 본인이 결정할 수 있습니다. <br/>
어디가 더 좋을지 고민해 보고 좋은 위치에 구현하고 간단하게 주석으로 자기의 생각을 표현해 주세요

