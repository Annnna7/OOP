class MyFirstClass{
    public static void main(String[] s) {
        int i, j;
        //с помощью конструктора формируем начальное состояние объекта
        MySecondClass o = new MySecondClass(0, 0);
        for (i = 1; i <= 8; i++){
            for (j = 1; j <= 8; j++){
                o.setA(i);
                o.setB(j);
                System.out.print(o.add());
                System.out.print(" ");
            }
            System.out.println(" ");
         }
    }
}

class MySecondClass{
    // Два приватных поля
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

    // Конструктор с параметрами, имя конструктора совпадает с именем клас
    public MySecondClass(int operandA, int operandB) {
        this.operandA = operandA;
        this.operandB = operandB;
    }

    //Сложение двух операндов
    public int add() {
        return operandA + operandB;
    }
}