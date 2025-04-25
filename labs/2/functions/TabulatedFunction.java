package functions;
public class TabulatedFunction {
    private FunctionPoint[] arr;
    private int count;

    //конструктор, создает объект табулированной функции по заданным левой и правой границе области определения, а
    // также кол-во точек для табулирования (значения функций в точках равно 0)
    public TabulatedFunction(double leftX, double rightX, int pointsCount) {
        this.count = pointsCount;   //можно убрать this?
        this.arr = new FunctionPoint[pointsCount]; //объявление массива
        for (int i = 0; i < pointsCount; ++i) {
            //вычисление (rightX - leftX) / (pointsCount - 1) формула для вычисления шага между значениями оси X
            this.arr[i] = new FunctionPoint(leftX + i*(rightX - leftX) / (pointsCount - 1), 0);
        }
    }

    //конструктор, получает значения функции в виде массива
    public TabulatedFunction(double leftX, double rightX, double[] values) {
        this.count = values.length;
        this.arr = new FunctionPoint[values.length];
        for (int i = 0; i < values.length; ++i) {
            this.arr[i] = new FunctionPoint(leftX + i*(rightX - leftX) / (values.length - 1), values[i]);
        }
    }

    //возвращает значение левой границы области определения табулированной функции
    public double getLeftDomainBorder() {
        return this.arr[0].x;
    }

    //возвращает значение правой границы области  определения табулированной функции
    public double getRightDomainBorder() {
        return this.arr[count - 1].x;
    }
    
    //возращает значение ф-ции в х, если точка лежит в области определения функции 
    public double getFunctionValue(double X) {
        if (X >= this.getLeftDomainBorder() && X <= this.getRightDomainBorder()) {
            for (int i = 0; i < this.arr.length - 1; i++){
                if (X >= this.arr[i].x && X <= this.arr[i + 1].x) {
                    double y1 = this.arr[i].y;
                    double y2 = this.arr[i + 1].y;
                    double x1 = this.arr[i].x;
                    double x2 = this.arr[i + 1].x;


                    //вычисляем значение ф-ции с помощью линейной интерполяции
                    return y1 + (y2 - y1) * (X - x1)/(x2 - x1);
                }
            }
        }
        //возвращает значение неопределенности, в поле NaN класса Double
        return Double.NaN;
    }
    
    //должен возвращать количество точек
    public int getPointsCount(){
        return count;
    }
    
    //инкапсуляция!!!
    //должен возвращать ссылку на объект, описывающий точку, имеющую указанный номер. 
    public FunctionPoint getPoint(int index){
        FunctionPoint ans = new FunctionPoint(this.arr[index]);
        return ans;
    }

    //инкапсуляция!!!
    //должен заменять указанную точку табулированной функции на заданную
    public void setPoint(int index, FunctionPoint point) {
        if (point.x >= this.getLeftDomainBorder() && point.x <= this.getRightDomainBorder()) {
            this.arr[index].x = point.x;
            this.arr[index].y = point.y;
        }
        //если координата x задаваемой точки лежит вне интервала,
        // определяемого значениями соседних точек табулированной функции,
        // то замену точки проводить не следует
    }

    //возвращает значение абсциссы точки с указанным номером
    public double getPointX(int index) {
        return this.arr[index].x;
    }

    //изменяет значение абсциссы точки с указанным номером
    public void setPointX(int index, double X) {
        if (X >= this.getLeftDomainBorder() && X <= this.getRightDomainBorder()) {
            this.arr[index].x = X;
        }
    }

    //возвращает значение ординаты точки с указанным номером
    public double getPointY(int index) {
        return this.arr[index].y;
    }

    //изменяет значение ординаты точки с указанным номером
    public void setPointY(int index, double Y) {
        this.arr[index].y = Y;
    }

    //удаляет заданную точку табулированной функции
    //метод arraycopy копирует данные из this.arr, начиная с эл-ов index + 1
    //до index + 1 + (this.getPointsCount() - index - 1 - 1) в массив this.arr
    // в index до index + (this.getPointsCount() - index - 1 - 1)
    public void deletePoint(int index) {
        System.arraycopy(this.arr,index + 1, this.arr, index,this.getPointsCount() - index - 1);
        --this.count;
    }

    //инкапсуляция!!!
    //добавляет новую точку табулированной функции
    public void addPoint(FunctionPoint point) {
        if (count == this.arr.length){
            FunctionPoint[] newArr = new FunctionPoint[count + 5];
            System.arraycopy(this.arr,0,newArr,0,count);
            arr = newArr;
        }
        int index = 0;
        while (index < count && this.arr[index].x < this.arr.x){
            index++;
        }

        System.arraycopy(this.arr, index,this.arr,index + 1,count - index);
        this.arr[index] = point;
        count++;
    }
}