package myfirstpackage;
public class MyFirstPackage{
    // Два приватных поля: операнды
    private int operandA, operandB;

    //Метод для получения значения первого операнда
    public int getA() {
        return operandA;
    }

    //Метод для получения значения второго операнда
    public int getB() {
        return operandB;
    }

    //Метод для модификации значения первого операнда
    public void setA(int operandA) {
        this.operandA = operandA;
    }

    //Метод для модификации значения второго операнда
    public void setB(int operandB) {
        this.operandB = operandB;
    }

    // Конструктор с параметрами
    public MyFirstPackage(int operandA, int operandB) {
        this.operandA = operandA;
        this.operandB = operandB;
    }

    //Сложение двух операндов
    public int add() {
        return operandA + operandB;
    }
}