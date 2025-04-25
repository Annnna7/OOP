package functions;
public class FunctionPoint{
    double x, y;
    public FunctionPoint(double a, double b){
        this.x = a; this.y = b;
    }
    public FunctionPoint(FunctionPoint point){
        this.x = point.x;
        this.y = point.y;
    }
    public FunctionPoint(){
        this.x = 0; this.y = 0;
    }
}