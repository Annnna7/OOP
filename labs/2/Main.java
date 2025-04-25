import functions.*;

public class Main{
    public static void main(String[] args) {
        double[] parabola = {0, 1, 4, 9, 16};
        TabulatedFunction square = new TabulatedFunction(-2, 2, parabola);
        for (int i = 0; i < parabola.getPointsCount(); ++i) {
            System.out.println("X"+(i)+" = "+parabola.getPointX(i)+" Y"+(i)+" = "+parabola.getPointY(i));
        }
        //область определения
        System.out.println("Function domain");
        System.out.println(square.getLeftDomainBorder() + " " + square.getRightDomainBorder() + "\n");
        //Нахождение значений функции
        //System.out.println("Function value");
        //System.out.println("x = -4 ans = " + square.getFunctionValue(-4));
        //System.out.println("x = -2 ans = " + square.getFunctionValue(-2));
        //System.out.println("x = 1,5 ans = " + square.getFunctionValue(1.5));
        //
        System.out.println("count = " + square.getPointsCount());
        //
        //square.deletePoint(6);
        //for (int i = 0; i< square.getPointsCount(); ++i) {
        //    System.out.println("X"+(i)+" = "+square.getPointX(i)+" Y"+(i)+" = "+square.getPointY(i));
        //}
        //FunctionPoint q = new FunctionPoint (-3.5,4);
        //square.addPoint(q);
        //for (int i = 0; i< square.getPointsCount(); ++i) {
        //    System.out.println("X"+(i)+" = "+square.getPointX(i)+" Y"+(i)+" = "+square.getPointY(i));
        //}
    }
}