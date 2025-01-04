import java.util.Objects;

public class Calculator {
    private int firstNumber;
    private int secondNumber;
    AbstractOperation operation;

    public Calculator (AbstractOperation abstractOperation){
        this.operation = abstractOperation;
    }
    public Calculator() {}
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
    }}
